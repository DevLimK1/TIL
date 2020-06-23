package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




//@RestController //사용자에게 바로 출력하려면
@Controller //view가 따로 존재하면
public class HomeController {
	
	
	//@RestController 일 때
//	@GetMapping("/index")
//	public String askldfjasldkfjasldfj() {
//		
//		return "hello Spring Boot!!"; // browser에 바로 문자열이 보이게 출력된다.  
//	}
	
	//@Controller일 때
	@GetMapping("/index")
	public String index() {
		
		return "root.index";  //"Hello" 이름의 파일을 찾아본다. ->  경로는 
	}
	
}
