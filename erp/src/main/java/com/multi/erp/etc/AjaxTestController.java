package com.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.multi.erp.board.BoardDTO;
import com.multi.erp.board.BoardService;

@Controller
@RequestMapping("/ajax")
public class AjaxTestController {

	BoardService service;

	public AjaxTestController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public AjaxTestController(BoardService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/noajax")
	public String noajax(String id, Model model) {
		String msg = "";
		if (id.equals("jang")) {
			msg = "사용불가능 아이디";
		} else {
			msg = "사용가능 아이디";
		}
		model.addAttribute("msg", msg);
		return "etcview/ajax";
	}

	@RequestMapping(value = "/ajaxtest01", produces = "application/text;charset=utf-8 ")
	@ResponseBody
	public String ajaxtest(String id) {

		String msg = "";
		if (id.equals("jang")) {
			msg = "사용불가능 아이디";
		} else {
			msg = "사용가능 아이디";
		}

		return msg;
	}

	@RequestMapping(value = "/gugu", produces = "application/text;charset=utf-8 ")
	@ResponseBody
	public String getgugu(String dan) {
		String msg = "";
		for (int i = 1; i < 10; i++) {
			msg += dan + " x " + i + " = " + (Integer.parseInt(dan) * i) + "\t";
			msg += "\n";
		}

		return msg;
	}

	@RequestMapping(value = "/exam01", produces = "application/json;charset=utf-8")
	@ResponseBody
	public BoardDTO responseObj(String boardno) {
		return service.getBoardInfo(boardno);
	}

	@RequestMapping(value = "/exam02/getjsondata", produces = "application/json;charset=utf-8")
	@ResponseBody
	public List<BoardDTO> responseJsonArr() {
		return service.boardList();
	}
}
