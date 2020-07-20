package com.newlecture.web.controller.api;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@RestController("apiNoticeController")
@RequestMapping("/api/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("{id}")
	public Notice detail(@PathVariable("id") int id) {
		
		List<NoticeView> list = null ;
		Notice notice =null;
		notice= noticeService.get(id);
		
		return notice;
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("list")
	public List<NoticeView> list(@RequestParam(name="p",defaultValue = "1")int page,
			@RequestParam(name="f",defaultValue = "title")String field,
			@RequestParam(name="q",defaultValue = "")String query) {
		
		List<NoticeView> list = null ;
		try {
			list = noticeService.getList(page, query, field);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
}
