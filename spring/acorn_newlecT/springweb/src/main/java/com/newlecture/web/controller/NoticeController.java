package com.newlecture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired //알아서 해당 클래스객체를 연결시켜준다.
	private NoticeDao noticeDao;
	
	@GetMapping("list")
	public String list(@RequestParam(name="p", defaultValue ="1") Integer page) {
		
//		String p=request.getParameter("p"); //1번째 방법
		int size=page*10;
		System.out.println(page);
		
		//1번째 방법(무식)
//		JdbcNoticeDao noticeDao=new JdbcNoticeDao();
		
		//2번째 방법(무식)
//		NoticeDao noticeDao=new JdbcNoticeDao();
		
		/*
		List<NoticeView> list=null;
		try {
			 list=noticeDao.getList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//@Autowired를 안쓰면 NullPointer발생
		*/
		return "notice/list"; //view ->application.properties에 prefix,suffix 참고
	}
	
	
	/////////////////////////////////////
	
//	3번째 방법(무식)
//	private NoticeDao noticeDao=new JdbcNoticeDao();
	
	//바람직한 마지막 방법
//	private NoticeDao noticeDao=new ???NoticeDao();

	
	/* ResponseBody 사용
	@ResponseBody // -> return 하는게 view가 아니다.
	@GetMapping("list")
	public List<NoticeView> list() {
		
		//1번째 방법(무식)
//		JdbcNoticeDao noticeDao=new JdbcNoticeDao();
		
		//2번째 방법(무식)
//		NoticeDao noticeDao=new JdbcNoticeDao();
		
		List<NoticeView> list=null;
		try {
			 list=noticeDao.getList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//@Autowired를 안쓰면 NullPointer발생
		
		return list; //view ->application.properties에 prefix,suffix 참고
	}
	*////////////////////////////////////


	
	
	
	@GetMapping("detail")
	public String detail() {
		
		return "notice.detail"; //view
	}
	

	@PostMapping("reg")
	public String reg(String title,String content) {
		System.out.printf("title:%s,content:%s\n",title,content);
		return "notice.detail"; //view
	}	
	
	
}
