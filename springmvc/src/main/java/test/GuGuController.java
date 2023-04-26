package test;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuGuController {
	
	@RequestMapping("/gugu.do")
	public ModelAndView printgugu() {
		ModelAndView mav = new ModelAndView();
		//공유 데이터 저장하기
		//request.getAttribue("name",공유객체);
		ArrayList<String> danSeven = new ArrayList<String>();
		for ( int i = 1; i < 10 ; i ++ ) {
			String str = "7 * " + i + " = " + (7*i);  
			System.out.println(str);
			danSeven.add(str);
		}
		mav.addObject("gugu",danSeven);
		// 뷰의 이름을 세팅 = 요청 재지정할 뷰의 이름을 세팅
		mav.setViewName("gugu/gugu");
		
		return mav;
	}
	
}
