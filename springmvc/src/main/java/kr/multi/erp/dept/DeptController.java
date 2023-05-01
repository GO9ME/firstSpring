package kr.multi.erp.dept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 클라이언트에게 보여줄 뷰를 요청하기 위한 메소드
// 디비연동이나 비지니스 로직을 처리할 메소드
@Controller
public class DeptController {
	
	@Autowired
	DeptService service;
	// insert를 하기 위한 view를 볼 수 있는 메소드
	
	@RequestMapping("/dept/register")
	public String showPage() {
		return "dept/dept_register";
	}
	
	// view 에 입력한 데이터를 db에 insert하기 위한 메소드
	// 사용자가 입력한 데이터를 추출
	@RequestMapping("/dept/insert.do")
	public String insert(DeptDTO dept) {
		System.out.println(dept);
		service.insert(dept);
		return "main/index";
	}
	
	@RequestMapping("/dept/list.do")
	public ModelAndView select() {
		ModelAndView mav = new ModelAndView();
		List<DeptDTO> userlist =  service.select();
		mav.addObject("userlist", userlist);
		mav.setViewName("dept/deptlist");
		
		return mav;
	}
	
	@RequestMapping("/dept/delete.do")
	public String delete(String deptno) {
		int result = service.delete(deptno);
		return "redirect:/dept/list.do";
	}
	
	@RequestMapping("/dept/read.do")
	public ModelAndView read(String deptno) {
		ModelAndView mav = new ModelAndView("dept/dept_read");
		DeptDTO user = service.read(deptno);
		mav.addObject("user", user);
		
		return mav;
	}
}
