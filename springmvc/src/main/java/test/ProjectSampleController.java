package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProjectSampleController {
	// 서비스단의 메소드 호출
	@Autowired
	ProjectSampleService service;

	@RequestMapping("/pro.do")
	public String sampletest() {
		System.out.println("나는 컨트롤러");
		return "main/index";
	}

	@RequestMapping(value = "/mvc/insert.do", method = RequestMethod.POST)
	public String sampletest(EmpDTO user) {
		service.servicetest(user);
		return "main/index";
	}

	@RequestMapping("/mvc/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("member/list");
		List<EmpDTO> userlist = service.selectList();
		mav.addObject("userlist",userlist);
		return mav;
	}

	@RequestMapping("/mvc/read.do")
	public ModelAndView read(String id, String state) {
		ModelAndView mav = new ModelAndView();
		EmpDTO userdata = service.selectDetail(id);
		String view = "";
		if(state.equals("READ")) {
			view = "member/emp_read";
		} else {
			view = "member/emp_update";
			
		}
		mav.setViewName(view);
		mav.addObject("userdata",userdata);
		return mav;
	}
	
	@RequestMapping("/mvc/update.do")
	public String update(EmpDTO user) {
		int result = service.update(user);
		return "redirect:/mvc/list.do";
	}
	

}
