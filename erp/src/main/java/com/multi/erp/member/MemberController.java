package com.multi.erp.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emp")
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

	@RequestMapping("/login.do")
	public String getLoginVeiw() {
		return "login";
	}

	@PostMapping("/login.do")
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
			// 서비스에서 가공한 뷰의 이름 - 로그인한 사용자가 어떤 job이냐에 따라 작업할 수 있는 메뉴가 달라질 수 있도록
			view = user.getMenupath();
		} else {
			view = "redirect:/emp/login.do";
		}
		return view;
	}

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		if (session != null) {
			// 사용하던 세션을 메모리에서 ㅔ거하기
			session.invalidate();
		}
		return "redirect:/index.do";
	}
	
	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		return user.getMenupath();
	}

	

}
