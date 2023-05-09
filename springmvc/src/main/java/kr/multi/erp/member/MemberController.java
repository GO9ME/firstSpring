package kr.multi.erp.member;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@Autowired
	EmpService service;
	@RequestMapping("/emp/insert")
	public String showPage() {
		System.out.println("테스트");
		return "member/register";
	}

	@RequestMapping("view/login")
	public String loginpage() {
		System.out.println("테스트");
		return "member/login";
	}
	
	@RequestMapping("/login.do")
	public ModelAndView login(String id, String pass, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView(); 
		EmpDTO user = service.login(id, pass);
		String view = "";
		if (user != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			// 세션에 데이터 공유하기
			session.setAttribute("loginUser", user);
			view = "main/index";
		} else {
			// 로그인 실패
			view = "redirect:/view/login";
		}
		mav.setViewName(view);
		return mav;
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		if (session != null) {
			//사용하던 세션을 메모리에서 ㅔ거하기
			session.invalidate();
		}
		return "redirect:/view/login";
	}
	@RequestMapping("/dbtest")
	public String test() {
		service.insert(null);
		return "main/index";
	}
	
	//register에서 사용자가 입력한 데이터를 db에 insert 하기 위한 컨트롤러 메소드
	// => 사용자가 입력한 요청정보를 어떻게 추출
	@RequestMapping(value="/emp/insert", method = RequestMethod.POST)
	public String insert(EmpDTO user) {
//		System.out.println(id + "," + pass);
		System.out.println(user);
		service.insert(user);
		return "main/index";
	}
	@RequestMapping("/emp/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("member/list");
		List<EmpDTO> userList = service.select();
		System.out.println(userList);
		mav.addObject("userList", userList);
		return mav;
	}
	@RequestMapping("/emp/read.do")
	public ModelAndView read(String id, String state) {
		ModelAndView mav = new ModelAndView();
		EmpDTO user = service.read(id);
		String view = "";
		if (state.equals("READ")) {
			view = "member/emp_read";
		} else {
			view = "member/emp_update";
		}
		System.out.println("view=>" + view);
		mav.setViewName(view);
		mav.addObject("user", user);
		return mav;
	}
	@RequestMapping("/emp/update.do")
	public String update(EmpDTO user) {
		System.out.println(user);
		service.update(user);
		return "redirect:/emp/list.do";
	}

}
