package com.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;

@RestController
//@Controller
//@ResponseBody
@RequestMapping("/json")
public class JSONTestController {
	
	BoardService service;
	
	public JSONTestController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public JSONTestController(BoardService service) {
		super();
		this.service = service;
	}
	@RequestMapping("/getString")
	public String responseString() {
		return "test data";
		
	}
	
	@RequestMapping("/getJsonObj")
	public BoardDTO responseObj() {
		return service.getBoardInfo("15");
		
	}
	
	@RequestMapping("/getJsonArr")
	public List<BoardDTO> responseJsonArr() {
		return service.boardList();
		
	}
	
	
}
