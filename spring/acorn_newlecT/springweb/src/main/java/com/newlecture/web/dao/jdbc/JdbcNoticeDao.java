package com.newlecture.web.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

//@Repository를 주석처리하면 ioc에 담지 않게 된다.
//@Repository //Dao라서 @Repository 이도 저도 아니면 @Component로한다.->컨테이너에 담긴다.
public class JdbcNoticeDao implements NoticeDao {

	@Override
	public List<NoticeView> getList() throws ClassNotFoundException, SQLException {
		int page=1;
		List<NoticeView> list = new ArrayList<>();
		int index = 0;
		
		String sql = "SELECT * FROM Notice ORDER BY regdate DESC LIMIT 10 OFFSET ?";// WHERE NUM BETWEEN 1 AND 10";
		
		//String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		//Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");			
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, (page-1)*10); // 1->0,2->10,3->20,30,40,...
		
		ResultSet rs = st.executeQuery();
				
		   while (rs.next()) {
		         NoticeView noticeView = new NoticeView();
		         noticeView.setId(rs.getInt("ID"));
		         noticeView.setTitle(rs.getString("TITLE"));
		         noticeView.setWriterId(rs.getString("writerId"));
		         noticeView.setRegdate(rs.getDate("REGDATE"));
		         noticeView.setHit(rs.getInt("HIT"));
		         noticeView.setFiles(rs.getString("FILES"));
		         noticeView.setPub(rs.getBoolean("PUB"));
		         
		         list.add(noticeView);      
		      }


		rs.close();
		st.close();
		con.close();
		
		
		return list;
	}

	@Override
	public Notice get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Notice notice) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
