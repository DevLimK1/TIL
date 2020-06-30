package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

//NoticeDao.xml 파일에 설정했다면 @Mapper를 주석처리해도 된다.
@Mapper //mybatis가 ioc에 담겨지게 해줄 annotation이다.
public interface NoticeDao {//데이터를 가져오는 클래스 , 스프링에서는 repository 라고도 한다.
	
	//String query="오";
	//SELECT * FROM Notice WHERE TITLE LIKE #{query}
	//-> SELECT * FROM Notice WHERE TITLE LIKE 5 -> query=5 처럼 숫자라면 ''로 감싸줘서 나오지 않음
	//-> SELECT * FROM Notice WHERE TITLE LIKE '%오%' ->#을 쓰면 자료형에 맞춰줌, ${}은 ''로 감싸지 않고 값이 변경됨
	
//	@Select("SELECT * FROM Notice WHERE TITLE LIKE '%오%' ORDER BY regdate DESC LIMIT 10")
//	@Select("SELECT * FROM Notice WHERE ${3} LIKE #{2} ORDER BY regdate DESC LIMIT 10") //아래와 같이 써도 됨
//	@Select("SELECT * FROM Notice WHERE ${param3} LIKE #{param2} ORDER BY regdate DESC LIMIT 10")
	@Select("SELECT * FROM Notice WHERE ${field} LIKE '%${query}%' ORDER BY regdate DESC LIMIT 10")// @Param을 사용해서 이름을 직접사용한다. ex..,@Param("field") String field 
	List<NoticeView> getList(int page,@Param("query") String query,@Param("field") String field) throws ClassNotFoundException, SQLException;
	
	
	@Select("SELECT * FROM Notice WHERE id=#{id}" )
	Notice get(int id);
	
	
	@Insert("INSERT INTO Notice(title,content) VALUES(#{title},#{content})")
	int insert(Notice notice);

	int update(Notice notice);
	int delete(int id);
}
