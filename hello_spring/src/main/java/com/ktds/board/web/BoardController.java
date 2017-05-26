package com.ktds.board.web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ktds.board.service.BoardService;
import com.ktds.board.vo.BoardListVO;
import com.ktds.board.vo.BoardSearchVO;
import com.ktds.board.vo.BoardVO;
import com.ktds.commons.Session;
import com.ktds.commons.web.DownloadUtil;
import com.ktds.commons.web.pager.ClassicPageExplorer;
import com.ktds.user.vo.UsersVO;

@Controller
public class BoardController {
	private Logger logger = LoggerFactory.getLogger(BoardController.class);

	private BoardService boardService;

	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}


	// @RequestMapping("/board/{pagerNo}") 이렇게도 쓸수는 있겠군..
	@RequestMapping("/board")
	public ModelAndView viewBoardListPage(HttpSession session, BoardSearchVO boardSearchVO) {
		/*
		 * pager를 위한 현재 page세팅 여기에 쓰지 않고 BoardSearchVO에 써주자..
		 * 
		 * int pageNo = boardSearchVO.getPageNo(); Pager pager =
		 * boardSearchVO.getPager(); pager.setPageNumber(pageNo);
		 */
		ModelAndView view = new ModelAndView();
		UsersVO UserVO = (UsersVO) session.getAttribute("_USER_");

		if (UserVO == null) {
			RedirectView redirectView = new RedirectView(); // redirect url 설정
			redirectView.setUrl("/hello_spring/user/signIn");
			redirectView.setExposeModelAttributes(false);

			view.setView(redirectView);

		} else {

			/* /WEB-INF/view/board/list.jsp */
			view.setViewName("board/list");
			// TODO
			BoardListVO boardList = boardService.getAllArticles(boardSearchVO);
			// System.out.println(allArticles.size());
			// view.addObject("allArticles", allArticles);
			view.addObject("allArticles", boardList.getBoardList());

			ClassicPageExplorer pageExplorer = new ClassicPageExplorer(boardList.getPager());

			String pager = pageExplorer.getPagingList("pageNo", "[@]", "PREV", "NEXT", "searchForm");

			view.addObject("pager", pager);

		}
		return view;

	}

	/*
	 * @RequestMapping("/board/json")
	 * 
	 * @ResponseBody public List<BoardVO> getBoardListJson() { // TODO return
	 * boardService.getAllArticles(boardSearchVO); }
	 */
	// @PathVariable url변수에 매핑시켜줌
	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewDetailPage(@PathVariable int id) {
		ModelAndView view = new ModelAndView();
		view.setViewName("board/detail");
		BoardVO article = boardService.getOneArticle(id);
		view.addObject("article", article);
		return view;
	}

	@RequestMapping("/board/download/{boardId}")
	public void downLoadFile(@PathVariable int boardId, 
				HttpServletRequest request, HttpServletResponse response) {
		BoardVO article = boardService.getOneArticle(boardId);
		DownloadUtil downloadUtil = DownloadUtil.getInstance("D:\\uploadFiles\\");

		try {
			downloadUtil.download(request, response, article.getRealFileName(), article.getDisplayFileName());
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e.getMessage(), e);
		}

	}

	// write page보여주는것 이건 get방식으로..그냥 url 만 넣어도 되지만, 아래 post가 있으니 get으로 명시해주자
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String viewWritePage() {
		return "board/write";
	}

	// write 는 post방식으로 처리해야하므로 위와 다름
	/* @RequestMapping("/board/write") <= 이건 get방식이니 post방식으로 바꾸자 */
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	// 필요한게 있으면 아래 arg에 적어주면 됨, 순서는 상관없음
	/*
	 * @Valid 객체명, Errors는 바로 뒤에 붙어야 함 @ModelAttribute 도 적어주자
	 * commandName=>writeForm 를 boardVO에 넘겨줌
	 */
	public String doWriteAction(@Valid @ModelAttribute("writeForm") BoardVO boardVO, Errors errors,
			HttpServletRequest requset, HttpSession session) {

		
		String receiveToken = boardVO.getCsrf_token();
		String sessionToken = (String) session.getAttribute(Session.CSRF_TOKEN);
		
		if( !receiveToken.equals( sessionToken ) ){
			throw new RuntimeException("잘못된 접근입니다.");
		}
		
		
		
		logger.info(boardVO.getSubject());

		String ip = requset.getRemoteAddr();
		boardVO.setIp(ip);
		
		UsersVO userVO = (UsersVO) session.getAttribute("_USER_");
		String writer = userVO.getUserId();

		boardVO.setWriter(writer);

		String returnUrl;
		if (errors.hasErrors()) {
			returnUrl = "board/write";
		} else {

			// 파일처리
			if (boardVO.getFile() != null && !boardVO.getFile().isEmpty()) {
				// 암호화된 파일명
				String fileName = UUID.randomUUID().toString();

				// String filePath = "D:\\uploadFiles\\" +
				// boardVO.getFile().getOriginalFilename();
				String filePath = "D:\\uploadFiles\\" + fileName;
				File newFile = new File(filePath);

				try {
					boardVO.getFile().transferTo(newFile);
				} catch (IllegalStateException e) {
					throw new RuntimeException(e.getMessage(), e);
				} catch (IOException e) { // 파일의 경로를 못찾을때 에러 발생 fileNotfound에러
											// 발생
					throw new RuntimeException(e.getMessage(), e);
				}
				boardVO.setPost(boardVO.getFile().getOriginalFilename());

				// 파일의 원본명
				boardVO.setDisplayFileName(boardVO.getFile().getOriginalFilename());

				boardVO.setRealFileName(fileName);
			}

			boolean isSucess = boardService.insertArticle(boardVO);

			if (isSucess) {
				returnUrl = "redirect:/board";
			} else {
				returnUrl = "redirect:/board/write";
			}
		}
		return returnUrl;
	}

	@RequestMapping("/board/delete/{id}")
	public String doDeleteAction(@PathVariable int id) {

		boolean isSuccess = boardService.deleteBoard(id);
		String urlPattern;
		if (isSuccess) {
			urlPattern = "redirect:/board";
		} else {
			urlPattern = "redirect:/board/detail";
		}
		return urlPattern;
	}

}
