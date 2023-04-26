package com.mutli.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	@RequestMapping("/test.do")
	public String Test() {
		return "main/test";
	}
	
	@RequestMapping("/datatest")
	public ModelAndView getData() {
		ModelAndView mav = new ModelAndView();
		//공유 데이터 저장하기
		//request.getAttribue("name",공유객체);
		mav.addObject("msg","스프링에서 공유되는 데이터");
		// 뷰의 이름을 세팅 = 요청 재지정할 뷰의 이름을 세팅
		mav.setViewName("main/result");
		
		return mav;
		
	}
	
	
	
}
