package com.multi.erp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	MemberService service;

	public MemberController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public MemberController(MemberService service) {
		super();
		this.service = service;
	}

	@RequestMapping("/index.do")
	public String tiles_index() {
		return "index";
	}

	@RequestMapping("/emp/login.do")
	public String getLoginVeiw() {
		return "login";
	}

	@PostMapping("/emp/login.do")
	public String login(String id, String pass, HttpServletRequest request) {
		System.out.println(id + " , " + pass);
		MemberDTO user = service.login(new MemberDTO(id, pass));
		System.out.println(user);
		String view = "";
		if (user != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			// 세션에 데이터 공유하기
			session.setAttribute("user", user);
			view = "redirect:/index.do";
		} else {
			view = "redirect://emp/login.do";
		}
		return view;
	}

	@RequestMapping("/emp/logout.do")
	public String logout(HttpSession session) {
		if (session != null) {
			// 사용하던 세션을 메모리에서 ㅔ거하기
			session.invalidate();
		}
		return "redirect:/index.do";
	}

	@RequestMapping("/menu/board.do")
	public String getBoardView() {
		return "menu/board";
	}
}
