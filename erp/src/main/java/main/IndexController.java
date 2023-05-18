package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
public class IndexController {
	BoardService service;

	public IndexController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public IndexController(BoardService service) {
		super();
		this.service = service;
	}
	

	@RequestMapping("/index.do")
	public String tiles_index(Model model) {
		List<BoardDTO> boardlist = service.findByCategory("게시판");
		model.addAttribute("boardlist",boardlist); 
		return "index";
	}

//	@RequestMapping("/emp/login.do")
//	public String getLoginVeiw() {
//		return "login";  
//	}
//	
	@RequestMapping("/menu/board.do")
	public String getBoardView() {
		return "menu/board";
	}
	

}
