package com.naver.cafe.club.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.naver.cafe.club.service.ClubService;
import com.naver.cafe.club.vo.ClubListVO;
import com.naver.cafe.club.vo.ClubSearchVO;
import com.naver.cafe.club.vo.ClubVO;
import com.naver.cafe.common.Auth;
import com.naver.cafe.common.Session;
import com.naver.cafe.common.SessionUtil;
import com.naver.cafe.common.web.DownloadUtil;
import com.naver.cafe.common.web.pager.ListPageExplorer;
import com.naver.cafe.menu.vo.MenuVO;
import com.naver.cafe.reply.vo.ReplyVO;
import com.naver.cafe.user.vo.UsersVO;
import com.nhncorp.lucy.security.xss.XssFilter;

@Controller
public class ClubController {
	private Logger logger = LoggerFactory.getLogger(ClubController.class);
	
	private ClubService clubService;

	public void setClubService(ClubService clubService) {
		this.clubService = clubService;
	}

	@RequestMapping("/login")
	public String login(HttpServletRequest request,HttpServletResponse response){
		SessionUtil.set(request, "_USER_", "엄혜미");
		return "redirect:/club/111";
	}
	
	// 메뉴클릭 접근시 요기로..
	@Auth("USR")
	@RequestMapping("/club/{menuId}/init")
	public String viewClubListInintPage(@PathVariable String menuId, HttpSession session) {
		// invalidate() 는 session자체를 지워버리는것
		// removeAttribute()는 해당 세팅부분만 없애는것
		session.removeAttribute("_SEARCH_");

		return "redirect:/club/" + menuId;
	}
	
	@Auth({"USR"})
	//@Auth("USR")
	@RequestMapping("/club/{menuId}")
	public ModelAndView viewClubListPage(@PathVariable String menuId, ClubSearchVO clubSearchVO,HttpSession session) {
		
		UsersVO UserVO = (UsersVO) session.getAttribute(Session.MEMBER);
		ModelAndView view = new ModelAndView();

		if (UserVO == null) {
			RedirectView redirectView = new RedirectView(); // redirect url 설정
			redirectView.setUrl("/cafe/user/signIn");
			redirectView.setExposeModelAttributes(false);

			view.setView(redirectView);
		}
		else{
		
			//3page에서 검색하다가 detail에서 목록돌아가기를 한경우 1page로 돌아가네?
			//최초 접속인경우 or detail에서 목록 돌아가기한경우 고쳐보자..
			//null 체크로 제어 하기 위해 pageNo를 int -> String으로 변경함
			// why? int 디폴트 값 : 0 이어서 pageNo가 0 이면 첫페이지로 가므로
			// String: null   
			if( clubSearchVO.getPageNo() == null ||
					clubSearchVO.getPageNo().length() == 0) {
				
				ClubSearchVO clubSearchVOInSession = 
						(ClubSearchVO) session.getAttribute("_SEARCH_");
				//session에 검색정보가 있으면 clubSearchVO 를 넣어서 해당 pageNo를 가져올수 있음
				if ( clubSearchVOInSession != null){
					clubSearchVO = clubSearchVOInSession;
				}
			}
			
			clubSearchVO.setMenuId(menuId);
	
			ClubListVO clubListVO = clubService.getAllClub(clubSearchVO);
	
			//현재 pageNo정보가 있는 clubSearchVO 를 세션에 담아놓음 
			session.setAttribute("_SEARCH_", clubSearchVO);
			
			
			view.addObject("menu", clubListVO.getMenuList());
			//System.out.println("clubListVO.getClubList().size()" + clubListVO.getClubList().size());
			
			
	//XSS START
		
			XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
			String subject;
			for (ClubVO club : clubListVO.getClubList()) {
				subject = club.getSubject();
				subject = filter.doFilter(subject);
                club.setSubject(subject);
			}

	//XSS END
			
			view.addObject("clubList", clubListVO.getClubList());
			
			view.addObject("totalCount", clubListVO.getPager().getTotalArticleCount());
			view.addObject("curruntMenu", clubListVO.getCurruntMenu());
			view.addObject("menuId", menuId);
			
			ListPageExplorer pageExplorer = new ListPageExplorer(clubListVO.getPager());
			String pager = pageExplorer.getPagingList("pageNo", " @ ", "이전", "다음", "searchForm");
			view.addObject("pager", pager);
	
			view.setViewName("club/list");
			
		}
		return view;
	}

	// detail 클릭시 조회수를 증가시는 역할
	// detail 클릭시 중간단계를 거쳐서 간다
	// transaction 때문에 select 시  update조회수 증가를 시킬수가 없음 => 분리하자
	@Auth("USR")
	@RequestMapping("/club/read/{menuId}/{id}")
	public String viewReadDetailPage(@PathVariable String menuId, @PathVariable String id,ClubSearchVO clubSearchVO) {
		clubSearchVO.setArticleId(id);
		boolean isSuccess = clubService.addReadCount(clubSearchVO);
		
		return "redirect:/club/detail/" + menuId + "/" + id;
	}
	@Auth("USR")
	@RequestMapping("/club/detail/{menuId}/{id}")
	public ModelAndView viewDetailPage(@PathVariable String menuId, @PathVariable String id,ClubSearchVO clubSearchVO) {

		ModelAndView view = new ModelAndView();

		//ClubVO article = (ClubVO) clubService.getOneClub(clubSearchVO);
		//view.addObject("article", article);
		
		view.setViewName("club/detail");
		view.addObject("menuId", menuId);
		
		clubSearchVO.setArticleId(id);
		Map<String,Object> club = clubService.getOneClub(clubSearchVO);
		ClubVO clubVO = (ClubVO) club.get("club");
		List<MenuVO> allMenu = (List<MenuVO>) club.get("menu");
		List<MenuVO> currentMenu = (List<MenuVO>) club.get("currentMenu");
		//List<ReplyVO> replyList = (List<ReplyVO>) club.get("reply");
//XSS방어 처리 start
		XssFilter filter = XssFilter.getInstance("lucy-xss-superset.xml");
		String subject  = filter.doFilter(clubVO.getSubject());
		String content = filter.doFilter(clubVO.getContent());
	
		logger.info("filter: " + filter.getInstance() + "subject : " + subject + "content: " + content);
		
		clubVO.setSubject(subject);
		clubVO.setContent(content);
//XSS방어 처리 end		
		view.addObject("clubVO", clubVO);
		view.addObject("menu", allMenu);
		view.addObject("currentMenu", currentMenu);
		//view.addObject("replyList", replyList);
		return view;
	}
	@Auth({"USR","ADM"})
	@RequestMapping(value="/club/write/{menuId}",method=RequestMethod.GET)
	public ModelAndView viewWriteArticlePage(@PathVariable String menuId){
		ModelAndView view = new ModelAndView();
		view.setViewName("club/write");
		view.addObject("menuId", menuId);
		return view;
	}
	@Auth("USR")
	@RequestMapping(value="/club/write/{menuId}",method=RequestMethod.POST)
	public String doWriteArticleAction(@PathVariable String menuId,ClubVO clubVO, HttpSession session){
		
		String receiveToken = clubVO.getCsrf_token();
		String sessionToken = (String) session.getAttribute(Session.CSRF_TOKEN);
		
		if( !receiveToken.equals( sessionToken ) ){
			throw new RuntimeException("잘못된 접근입니다.");
		}
		clubVO.setMenuId(menuId);
		
		String memberId = ((UsersVO) session.getAttribute(Session.MEMBER)).getUserId();
		
		clubVO.setMemberId(memberId);
		
		boolean isSuccess = clubService.addNewClub(clubVO);
		
		return "redirect:/club/"+menuId;
	} 
	
	
	@Auth("USR")
	@RequestMapping(value="/club/upload",method=RequestMethod.POST)
	public void doUploadFile(
			MultipartHttpServletRequest request,HttpServletResponse response){
		
		MultipartFile file = request.getFile("file");
		if( file != null && !file.isEmpty() ){
			File uploadPath = new File("D:\\uploadFiles\\"
							+file.getOriginalFilename().replaceAll(" ", "_"));
			try {
				file.transferTo(uploadPath);
			} catch (IllegalStateException | IOException e) {
				throw new RuntimeException(e.getMessage(),e);
			}
		}
		
		try {
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script>");
			out.write(" parent.document.getElementById('uploadFiles').innerHTML +=");
			/*@PathVariable 띄어쓰기 . 못들어감 변경해주자*/
			out.write("'<p>http://localhost:8080/cafe/club/download/" + 
					file.getOriginalFilename()
			.replaceAll(" ", "_")
			.replaceAll("[.]", "_dot_")+"<p>';");
			out.write("</script>");
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	@Auth("USR")
	@RequestMapping("/club/download/{fileName}")
	public void downloadAttachedFile(@PathVariable String fileName
			,HttpServletRequest request
			,HttpServletResponse response){
		
		DownloadUtil download = 
				DownloadUtil.getInstance("D:\\uploadFiles\\");
		fileName = fileName.replaceAll("_dot_", ".");
		
		try {
			download.download(request, response, fileName, fileName);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(),e);
		}

	}
	@Auth("USR")
	@RequestMapping(value="/club/reply/write",method=RequestMethod.POST)
	public void doWriteReply(ReplyVO replyVO,HttpServletResponse response){
		
		replyVO.setMemberId("user");
		boolean isSuccess = clubService.writeReply(replyVO);
		try {
			PrintWriter out = response.getWriter();
			if ( isSuccess ) {
				out.write("OK");
			}
			else{
				out.write("FAIL");
			}
			out.flush();
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
	}
	
}
