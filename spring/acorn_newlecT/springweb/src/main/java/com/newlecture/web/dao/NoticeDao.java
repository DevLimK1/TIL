package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Mapper //mybatis가 ioc에 담겨지게 해줄 annotation이다.
public interface NoticeDao {//데이터를 가져오는 클래스 , 스프링에서는 repository 라고도 한다.
	
	@Select("SELECT * FROM Notice ORDER BY regdate DESC LIMIT 10")
	List<NoticeView> getList() throws ClassNotFoundException, SQLException;
	
	Notice get(int id);
	int insert(Notice notice);
	int update(Notice notice);
	int delete(int id);
}
