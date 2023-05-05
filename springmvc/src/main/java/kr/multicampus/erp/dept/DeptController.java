package kr.multicampus.erp.dept;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

@Controller
public class DeptController {
	@Autowired
	DeptService service;
	@Autowired
	FileUploadLogic fileuploadService;
	
	@RequestMapping("/dept/register")
	public String showPage() {
		return "dept/dept_register";
	}
	//view 에 입력한 데이터를 db에 insert 하기 위한 메소드
	//사용자가 입력한 데이터를 추출
	
	@RequestMapping("/dept/insert.do")
	public String insert(DeptDTO dept, HttpSession session) throws IllegalStateException, IOException{
		
		System.out.println(dept);
		List<MultipartFile> files = dept.getFiles();
//		service.insert(dept);
		String path = WebUtils.getRealPath(session.getServletContext(), "/WEB-INF/upload");
		List<DeptFileDTO> deptfiledtodlist = fileuploadService.uploadFiles(files, path);
		int count = 1;
		for (DeptFileDTO deptfiledto : deptfiledtodlist) {
			deptfiledto.setDeptImageFileno(count+"");
			count++;
		}
		service.insert(dept,deptfiledtodlist);
		
		
		return "redirect:/dept/list.do";
	}
	//조회한 리스트를 공유하고 view 에서 정보를 출력하도록 한다.
	@RequestMapping("/dept/list.do")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView("dept/deptlist");
		//서비스의 메소드 호출
		List<DeptDTO> deptlist =  service.select();
		//결과공유
		mav.addObject("deptlist",deptlist);
		return mav;
	}
	@RequestMapping("/dept/read.do")
	public ModelAndView read(String deptno, String state) {
		ModelAndView mav = new ModelAndView();
		DeptDTO dept = service.read(deptno);
		//서비스메소드 호출
		//데이터 공유
		//뷰정보셋팅
		String view  ="";
		if(state.equals("READ")) {
			view="dept/dept_read";
		}else {
			view="dept/dept_update";
		}
		mav.addObject("dept", dept);
		mav.setViewName(view);
		return mav;
	}
	@RequestMapping("/dept/delete.do")
	public String delete(String deptno) {
		service.delete(deptno);
		return "redirect:/dept/list.do";
	}
	@RequestMapping("/dept/update.do")
	public String update(DeptDTO dept) {
		System.out.println(dept.getDeptno());
		System.out.println(dept.getMgr_id());
		service.update(dept);
		return "redirect:/dept/update.do";
	}
		
}
