package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

@Controller
@RequestMapping("/member/")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public String login() {
		
		return "member.login";
	}
	
	@GetMapping("join")
	public String join() {
		
		return "member.join";
	}
	
	@PostMapping("join")
	public String join(Member member) {
		
		memberService.insert(member);
		
		return "redirect:/index";
	}
	
}
