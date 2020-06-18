package com.newlecture.web.controller.admin.board;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Controller("adminNoticeController")
@RequestMapping("admin/board/notice/")
public class NoticeController {

	@Autowired // 알아서 해당 클래스객체를 연결시켜준다.
	private NoticeDao noticeDao;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "f", defaultValue = "title") String field,
			Model model) throws ClassNotFoundException, SQLException {
		System.out.println("Get");
		System.out.println("page:"+page);
		System.out.println("query:"+query);
		System.out.println("field:"+field);
		
		
		List<NoticeView> list =noticeDao.getList(page, query, field);
		model.addAttribute("list",list);
		
	
		return "admin/board/notice/list"; // view ->application.properties에 prefix,suffix 참고
	}
	
	@GetMapping("detail")
	public String detail(int id,Model model) throws ClassNotFoundException, SQLException {
		
		Notice notice =noticeDao.get(id);
		model.addAttribute("n",notice);
		
	
		return "admin/board/notice/list"; // view ->application.properties에 prefix,suffix 참고
	}

//	@RequestMapping(value = "reg",method = RequestMethod.GET)
	@GetMapping("reg")
	public String reg() {
		System.out.println("Get");
		return "admin/board/notice/reg"; // view ->application.properties에 prefix,suffix 참고
	}

//	@RequestMapping(value = "reg",method = RequestMethod.POST)
	@PostMapping("reg")
	public String reg(Notice notice) {
		// public String reg(String title,String content) {
		System.out.println("post");
		System.out.println(notice);

		// return "list"; //view ->application.properties에 prefix,suffix 참고

		return "redirect:list"; // -> 리다이렉트
	}


}
