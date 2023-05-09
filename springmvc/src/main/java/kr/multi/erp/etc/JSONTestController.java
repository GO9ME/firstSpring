package kr.multi.erp.etc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.multi.erp.dept.DeptDTO;
import kr.multi.erp.dept.DeptService;

@Controller
public class JSONTestController {
	@Autowired
	DeptService service;

	@RequestMapping("/json/view")
	public String showPage() {
		return "etcview/json";
	}

	@RequestMapping("/json/getString")
	@ResponseBody
	// => 더이상 view를 응답하지 않는다.
	public String responseString() {
		return "json";
	}

	@RequestMapping("/json/getJsonObj")
	@ResponseBody
	// => 더이상 view를 응답하지 않는다.
	public DeptDTO responseObj() {
		return service.read("d001");
	}

	@RequestMapping("/json/getJsonArr")
	@ResponseBody
	// => 더이상 view를 응답하지 않는다.
	public List<DeptDTO> responseJsonArr() {
		return service.select();
	}

	@RequestMapping("/ajax/exam")
	public String showExamPage() {
		return "etcview/ajaxexam";
	}

	@RequestMapping(value = "/ajax/getJsonData", produces = "application/json;charset=utf-8")
	@ResponseBody
	public DeptDTO ajax_json_exam(String deptno) {
		return service.read(deptno);
	}
}
