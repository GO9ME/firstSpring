package kr.multi.erp.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	@RequestMapping("/view/register")
	public ModelAndView showPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/register");
		
		return mav;
	}
	@RequestMapping("/view/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav .setViewName("member/login");
		return mav;
	}
}
