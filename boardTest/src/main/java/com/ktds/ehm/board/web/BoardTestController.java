package com.ktds.ehm.board.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktds.ehm.board.service.BoardService;
import com.ktds.ehm.board.vo.BoardVO;

@Controller
public class BoardTestController {
	private Logger logger = LoggerFactory.getLogger(BoardTestController.class);
		
	
	private BoardService boardService;
	
	public void setBoardService(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@RequestMapping("/board/list")
	public ModelAndView viewBoardListPage(){
		ModelAndView view = new ModelAndView();
		
		List<BoardVO> boards = boardService.getAllBoard();
		
		view.addObject("boards", boards);
		view.setViewName("board/list");
		System.out.println("List:"  + boards.size());
		return view;
	}
	@RequestMapping("/board/json")
	@ResponseBody
	public List<BoardVO> viewBOardListPage2(){
		return boardService.getAllBoard();
	}
	@RequestMapping("/board/detail/{id}")
	public ModelAndView viewDetailPage(@PathVariable int id){
		ModelAndView view = new ModelAndView();
		BoardVO board = boardService.getOneBoard(id);
		view.addObject("board", board);
		view.setViewName("board/detail");
		return view;
	}
	@RequestMapping("/board/write")
	public String viewWritePate(){
		return "board/write";
	}
	
	@RequestMapping(value="board/write",method=RequestMethod.POST)
	public String doWriteAction(@Valid @ModelAttribute("writeForm") BoardVO boardVO, Errors errors, HttpServletRequest requset){
		String ip= requset.getRemoteAddr();
		HttpSession session = requset.getSession();
		boardVO.setIp(ip);
		logger.debug("(000)");
		
		String urlPattern;
		if ( errors.hasErrors()) {
			
			logger.debug("(0)");
			urlPattern = "board/write";
		}
		else{
			
			logger.info("(1)");
			//파일처리
			if(!boardVO.getFile().isEmpty()){
				logger.info("여기오나?" + boardVO.getFile().getOriginalFilename());
				String fileName = boardVO.getFile().getOriginalFilename();
				String filePath = "D:\\uploadFiles\\" + fileName;
				File newFile = new File(filePath);
				try {
					boardVO.getFile().transferTo(newFile);
				} catch (IllegalStateException e) {
					throw new RuntimeException(e.getMessage(),e);
				} catch (IOException e) {
					throw new RuntimeException(e.getMessage(),e);
				}
				boardVO.setPost(fileName);
			}
			
			boolean isSuccess = boardService.insertBoard(boardVO);
			logger.info(isSuccess + "");
			if ( isSuccess ) {
				urlPattern = "redirect:/board/list";
			}else{
				urlPattern = "redirect:/board/write";
			}
		}
		return urlPattern;
	}
	
	@RequestMapping("/board/delete/{id}")
	public String doDeleteAction(@PathVariable int id){
		
		boolean isSuccess = boardService.deleteBoard(id);
		String urlPattern;
		if ( isSuccess ) {
			urlPattern = "redirect:/board/list";
		}else{
			urlPattern = "redirect:/board/detail";
		}
		return urlPattern;
	}

}
