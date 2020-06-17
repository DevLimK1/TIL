package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeDao {//데이터를 가져오는 클래스 , 스프링에서는 repository 라고도 한다.
	List<NoticeView> getList() throws ClassNotFoundException, SQLException;
	Notice get(int id);
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
}
