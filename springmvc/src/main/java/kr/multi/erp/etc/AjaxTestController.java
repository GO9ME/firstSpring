package kr.multi.erp.etc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AjaxTestController {
	@RequestMapping("/ajax/view")
	public String showPage() {
		return "etcview/ajax";
	}
	@RequestMapping("/ajax/noajax")
	public ModelAndView noAjax(String id) {
		ModelAndView mav = new ModelAndView("etcview/ajax");
		String msg = "";
		if (id.equals("jang")) {
			msg = "사용불가능 아이디";
		} else {
			msg = "사용 가능 아이디";
		}
		mav.addObject("msg",msg);
		return mav;
	}
	// 처리가 완료되면 Response body에 처리결과를 문자열로 보내기
	// responsebody어노테이션을 사용하면 응답데이터로 인식
	@RequestMapping(value = "/ajax/ajaxtest01", produces="application/text;charset=utf-8")
	@ResponseBody
	public String ajax(String id) {
		String msg = "";
		if (id.equals("jang")) {
			msg = "사용불가능 아이디";
		} else {
			msg = "사용 가능 아이디";
		}
		return msg;
	}
}
