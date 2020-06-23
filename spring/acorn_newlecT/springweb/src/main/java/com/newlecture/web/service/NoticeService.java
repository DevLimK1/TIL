package com.newlecture.web.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Service //IoC에 담아두는 작업 (@Autowired쓰기 위해)
public class NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
//	private CommentDao commentDao;

	public List<NoticeView> getList(Integer page, String query, String field) throws ClassNotFoundException, SQLException {

		return noticeDao.getList(page, query, field);
	}

	public Notice get(int id) {
		
		return noticeDao.get(id);
	}

	/*
	public List<NoticeView> getListWithComments(Integer page, String query, String field) {

		List<NoticeView> list=getList(page, query, field);
		for(NoticeView n : list) {
			List<Comment> cmts=commentDao.getListTop(n.getId());
			n.setComments(cmts);
		}
		
		return list;
	}
	*/

}
