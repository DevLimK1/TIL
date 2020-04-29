package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.web.entity.NoticeView;

public class NoticeService2 {
	public NoticeView[] getNoticeList() throws SQLException, ClassNotFoundException {
		
		NoticeView[] list = new NoticeView[10];
//		List<NoticeView> list=new ArrayList<>();
	
		
		int index=0;
		
		String sql="SELECT * FROM NOTICE_VIEW WHERE NUM BETWEEN 1 AND 10"; //Notice_VIEW에 정렬이 되어있음
		
		String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";

		Class.forName("oracle.jdbc.driver.OracleDriver");
	    Connection con = DriverManager.getConnection(url, "LEC", "111");      
	    PreparedStatement st = con.prepareStatement(sql);
	    //  st.setString(1, id);
	      
	      ResultSet rs = st.executeQuery();
	      
	      while (rs.next()) {
	    	 NoticeView noticeView = new NoticeView(
	    			 rs.getInt("ID"),
	    			 rs.getString("TITLE"),
	    			 rs.getString("WRITER_ID"),
	    			// rs.getString("CONTENT"),
	    			 rs.getDate("REGDATE"),
	    			 rs.getInt("HIT"),
	    			 rs.getString("FILES"),
	    			 rs.getString("WRITER_NAME"),
	    			 rs.getInt("CMT_COUNT")
	    			 
	    			 );
	    	 list[index++] = noticeView;
	      }
	    	
	      rs.close();
	      st.close();
	      con.close();
		
		return list;
	}
}