package com.newlecture.web.controller.admin.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.dao.NoticeDao;

@Controller("adminNoticeController")
@RequestMapping("admin/board/notice/")
public class NoticeController {
	
	
	@Autowired //알아서 해당 클래스객체를 연결시켜준다.
	private NoticeDao noticeDao;
	


	@RequestMapping("reg")
	public String reg() {
		
		
		
		return "admin/board/notice/reg"; //view ->application.properties에 prefix,suffix 참고
	}
	
	
	@GetMapping("detail")
	public String detail() {
		
		return "admin/board/notice/detail"; //view
	}
	
	
}
