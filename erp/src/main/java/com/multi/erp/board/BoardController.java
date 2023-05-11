package com.multi.erp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	BoardService service;

	public BoardController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public BoardController(BoardService service) {
		super();
		this.service = service;
	}

	@GetMapping("/board/write")
	public String writePage() {

		return "board/write"; // 뷰등록
	}

	@PostMapping("/board/write")
	public String write(BoardDTO board) {

		service.insert(board);
		return "redirect:/board/list.do"; // 컨트롤러 요청 재지정
	}

	@RequestMapping("/board/list.do")
	public ModelAndView list() {
		List<BoardDTO> boardlist = service.boardList();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("boardlist", boardlist);
		return mav; // 뷰등록
	}

	@RequestMapping("/board/search.do")
	public ModelAndView search(String search) {
		ModelAndView mav = new ModelAndView("board/list");
		List<BoardDTO> boardlist = service.search(search.trim());
		System.out.println(boardlist);
		mav.addObject("boardlist", boardlist);
		return mav;
	}
	
	@RequestMapping("/board/read")
	public ModelAndView read(String board_no) {
		ModelAndView mav = new ModelAndView("board/read");
		BoardDTO board =  service.getBoardInfo(board_no);
		mav.addObject("board", board);
		return mav;
	}
	@RequestMapping("/board/delete")
	public String delete(String board_no) {
		service.delete(board_no);
		return "redirect:/board/list.do"; // 컨트롤러 요청 재지정
	}
}
