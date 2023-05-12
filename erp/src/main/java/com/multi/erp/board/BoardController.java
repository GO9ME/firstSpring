package com.multi.erp.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.multi.erp.member.MemberDTO;

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
		return "redirect:/board/list.do/all"; // 컨트롤러 요청 재지정
	}

	@RequestMapping("/board/list.do/{category}")
	public ModelAndView list(@PathVariable String category) {
//		List<BoardDTO> boardlist = service.boardList();
		System.out.println("category : " + category);
		List<BoardDTO> boardlist = service.findByCategory(category);
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("category", category);
		mav.addObject("boardlist", boardlist);
		return mav; // 뷰등록
	}

	@RequestMapping("/board/search.do")
	public ModelAndView search(String tag, String search) {
		ModelAndView mav = new ModelAndView("board/list");
//		List<BoardDTO> boardlist = service.search(search.trim());
		List<BoardDTO> boardlist = service.search(tag, search.trim());
		System.out.println(boardlist);
		mav.addObject("boardlist", boardlist);
		return mav;
	}

//
//	@RequestMapping("/board/read")
//	public ModelAndView read(String board_no) {
//		ModelAndView mav = new ModelAndView("board/read");
//		BoardDTO board =  service.getBoardInfo(board_no);
//		mav.addObject("board", board);
//		return mav;
//	}
	
	@RequestMapping("/board/read.do/{board_no}/{state}")
	public String read(@PathVariable String board_no, @PathVariable String state, Model model) {
		BoardDTO board = service.getBoardInfo(board_no);
		String view = "";

		if (state.equals("READ")) {
			view = "board/read";
			System.out.println(view);
		} else {
			view = "board/update";
		}
		model.addAttribute("board", board);
		return view;
	}

	@RequestMapping("/board/delete.do/{board_no}")
	public String delete(@PathVariable String board_no, HttpSession session) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String view = "";
		if (user != null) {
			view = "redirect:/emp/login.do";
		} else {
			int result = service.delete(board_no);
			view = "redirect:/board/list.do/all";

		}
		return view; // 컨트롤러 요청 재지정
	}
	
	@RequestMapping("/board/update.do")
	public String update(BoardDTO board, HttpSession session, HttpServletRequest request) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String view = "";
		if (user != null) {
			int result = service.update(board);
			String referer = request.getHeader("Referer");
			view = "redirect:"+ referer;
		} else {
			view = "redirect:/emp/login.do";

		}
		return view; 
	}

}
