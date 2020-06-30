package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newlecture.web.entity.Notice;




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
	
//	@GetMapping("/data")
//	@ResponseBody
//	public String data() {
//		return "hello";
//	}
	
//	@GetMapping("/data")
//	@ResponseBody
//	public Notice data() {
//		Notice notice =new Notice();
//		notice.setId(1);
//		notice.setTitle("hello");
//		notice.setWriterId("kyenwon");
//		notice.setHit(10);
//		return notice;
//	}
	
	@GetMapping("/data")
	@ResponseBody
	public String data() {
		return "alert('hello');"; //jquery.js 에서 $.getScript()사용하면 alert가 바로 실행됨.
	}
}
