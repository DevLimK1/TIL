package com.newlecture.web.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.service.MemberService;

@RestController("apiMemberController")
@RequestMapping("/api/member/")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("validate")
	public Map<String, Boolean> validate(String uid, String pwd) {
		boolean result=memberService.validate(uid,pwd);
		Map<String, Boolean> model=new HashMap<>();
		model.put("result", result);
		
		return model;
	}
	
//	@CrossOrigin(origins = "http://localhost:3000")
//	@GetMapping("list")
//	public List<NoticeView> list(@RequestParam(name="p",defaultValue = "1")int page,
//			@RequestParam(name="f",defaultValue = "title")String field,
//			@RequestParam(name="q",defaultValue = "")String query) {
//		
//		List<NoticeView> list = null ;
//		try {
//			list = noticeService.getList(page, query, field);
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return list;
//	}
}
