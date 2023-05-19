package com.multi.erp.member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import kr.multi.erp.dept.DeptDTO;
import kr.multi.erp.dept.DeptService;

//@SessionAttributes("user")user라는 것은 세션에 저장하는 attribute

@Controller
@RequestMapping("/emp")
@SessionAttributes("user")
public class MemberController {
	MemberService service;

	DeptService deptService;

	public MemberController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public MemberController(MemberService service, DeptService deptService) {
		super();
		this.service = service;
		this.deptService = deptService;
	}

	@RequestMapping("/insert")
	public String insertPage() {
		System.out.println("insertpage");
		String view = "member/register";
		return view;
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

	// 스프링에서 제공되는 기능을 이용한 로그인
	@RequestMapping("/spring/login")
	public String springlogin(MemberDTO loginUserInfo, Model model) {
		System.out.println("스프링이 제공하는 @session attribute 이용해서 세션처리");
		MemberDTO user = service.login(loginUserInfo);
		String view = "";
		if (user != null) {
			// 로그인 성공
			// 세션에 데이터 공유하기
			model.addAttribute("user", user);
			// 서비스에서 가공한 뷰의 이름 - 로그인한 사용자가 어떤 job이냐에 따라 작업할 수 있는 메뉴가 달라질 수 있도록
			view = user.getMenupath();
		} else {
			view = "redirect:/emp/login.do";
		}

		return view;
	}

	// 스프링에서 제공되는 기능을 이용한 로그아웃
	@RequestMapping("/spring/logout")
	public String springlogout(SessionStatus status) {
		System.out.println("SessionStatus 이용해서 로그아웃");
		status.setComplete();
		return "redirect:/index.do";
	}

	@RequestMapping("/mypage")
	public String mypage(HttpSession session) {
		MemberDTO user = (MemberDTO) session.getAttribute("user");
		return user.getMenupath();
	}

	@RequestMapping("/selectCode")
	@ResponseBody
	public List<DeptDTO> selectCode() {
		List<DeptDTO> deptlist = deptService.select();
		return deptlist;
	}

	@RequestMapping(value = "/checkId", produces = "application/text; charset=UTF-8")
	@ResponseBody
	public String checkId(String id) {
		String msg = "";
		boolean flag = service.idCheck(id);
		System.out.println("flag : " + flag);
		if (flag) {
			msg = "사용불가능아이디";
		} else {
			msg = "사용가능아이디";
		}
		return msg;
	}

	@PostMapping("/insert.do")
	public String write(MemberDTO member, HttpSession session) throws IllegalStateException, IOException {
		System.out.println("member : " + member);
		MultipartFile file = member.getUserImage();
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");

		service.insert(member, file, path, file.getOriginalFilename());
		return "redirect:/index.do"; // 컨트롤러 요청 재지정
	}

	@RequestMapping("/dept/tree.do")
	public String deptView() {
		return "dept/tree";
	}

	@RequestMapping(value = "/selectTree", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<TreeDTO> selectTree() {

		List<TreeDTO> tree = service.selectTree();
		return tree;
	}

}
