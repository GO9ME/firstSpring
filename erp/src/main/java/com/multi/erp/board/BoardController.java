package com.multi.erp.board;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;
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
		List<BoardFileDTO> boardfilelist = service.getFileList(board_no);
		System.out.println("boardfilelist" + boardfilelist);
		String view = "";

		if (state.equals("READ")) {
			view = "board/read";
		} else {
			view = "board/update";
		}
		model.addAttribute("board", board);
		model.addAttribute("boardfilelist", boardfilelist);
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

	@RequestMapping("/board/download/{id}/{board_no}/{boardFileno}")
	public ResponseEntity<UrlResource> downloadFile(@PathVariable String id, @PathVariable String board_no,
			@PathVariable String boardFileno, HttpSession session) throws MalformedURLException, FileNotFoundException {
		// 1. 파일을 다운로드 하기 위해 디비에 저장된 파일의 정보를 가져오기 - 다운로드를 요청한 파일을 response
		BoardFileDTO selectfileInfo = service.getFile(new BoardFileDTO(board_no, "", "", boardFileno));

		// 2. BoardFileDTO객체에서 다운로드할 파일을 실제 객체로 변환하는 작업
		// UrlResoucre resource = new UrlResource("file:"+파일의 full path) <- 실제 파일 위치

		// 미리 업로드된 파일을 다운로드 해야 하므로 업로드된 파일이 저장된 위치와 실제 저장된 파일명을 연결해서 경로를 만들어줘야함
		UrlResource resource = new UrlResource("file:" + WebUtils.getRealPath(session.getServletContext(),
				"/WEB-INF/upload/" + selectfileInfo.getStoreFilename()));

		// 3. 파일명에 한글이 있는 경우 오류가 발생하지 않도록 처리 - 다운로드되는 파일명
		String encodedFilename = UriUtils.encode(selectfileInfo.getOriginalFilename(), "UTF-8");

		// 4. 파일을 다운로드 형식으로 응답하기 위해서 응답헤더에 세팅 attachment; filename="a.jpg"
		String mycontenttype = "attachment; filename=\"" + encodedFilename + "\"";
		/*
		 * BodyBuilder builder = ResponseEntity.ok(); ResponseEntity<UrlResource>
		 * response = builder.body(resource); return response;
		 */
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, mycontenttype)
				.body(resource);
	}
	
	@RequestMapping(value="/board/ajax/list.do", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<BoardDTO> ajaxlist(String category){
		return service.findByCategory(category);
	}

}
