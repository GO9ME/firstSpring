package main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("/index.html")
	public String index() {
		return "main/index";
	}
	@RequestMapping("/index.do")
	public String tiles_index() {
		System.out.println("tiles를 활용한 뷰를 forward하는 컨트롤러");
		return "index"; //컨트롤러에서 리턴하는 뷰이름은 tiles설정파일에 등록한 defintion 엘리먼트의 name속성에 정의한 이름 
	}
}
