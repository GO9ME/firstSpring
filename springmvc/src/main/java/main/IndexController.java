package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping("/index.html")
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("msg","스프링에서 공유되는 데이터");
		mav.setViewName("main/index");
		return mav;
	}
}
