package com.multi.erp.board;

import java.io.IOException;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.multi.erp.member.MemberDTO;

@Controller
public class BoardController {

	BoardService service;

	FileUploadLogic fileuploadservice;

	public BoardController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public BoardController(BoardService service, FileUploadLogic fileuploadservice) {
		this.service = service;
		this.fileuploadservice = fileuploadservice;
	}

	@GetMapping("/board/write")
	public String writePage(HttpSession session) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		String view = "";
		if (user != null) {
			view = "board/write";
		} else {
			view = "redirect:/emp/login.do";
		}
		return view; // 뷰등록
	}

	@PostMapping("/board/write")
	public String write(BoardDTO board, HttpSession session) throws IllegalStateException, IOException {
		System.out.println("boardwrite.boarddto : " + board);
		// 1. MultipartFiles 정보를 추출
		List<MultipartFile> files = board.getFiles();
		// 2. 업로드될 서버의 경로 추출
		// - 실제 서버의 경로를 추출하기 위해서 Context객체의 정보를 담고 있는 ServletContext객체를 추출
		// - ServletContext가 우리가 웹에서 운영할 프로젝트에 대한 정보를 담고 있는 객체
		// 실제 경로를 구할 수 있는 메소드가 있음
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");
		System.out.println("path : " + path);
		// 3. 업로드 로직을 구현해서 업로드 되도록 처리
		List<BoardFileDTO> boardfiledtolist = fileuploadservice.uploadFiles(files, path);
		service.insert(board, boardfiledtolist);
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
			view = "redirect:" + referer;
		} else {
			view = "redirect:/emp/login.do";

		}
		return view;
	}

}
