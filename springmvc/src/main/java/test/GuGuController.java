package test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuGuController {
	@RequestMapping("/gugu.do")
	public ModelAndView printgugu() {
		ModelAndView mav = new ModelAndView("gugu/gugu");
		// 뷰의 이름을 셋팅 - 요청재지정할 뷰의 이름을 셋팅
		String gugu = "";
		for (int i = 1; i <= 9; i++) {
			gugu += "7 * " + i + " = " + (7 * i);
			gugu += "<br />";
		}
		mav.addObject("gugudan",gugu);
		
		return mav;
	}
}