package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public class NoticeService {

	public Notice getNotice(int id) throws ClassNotFoundException, SQLException {
		
		Notice notice  = null;

		String sql = "SELECT * FROM NOTICE WHERE ID=?"; 

		String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "LEC", "111");
		PreparedStatement st = con.prepareStatement(sql);
		 st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			notice= new Notice(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("WRITER_ID"),
					 rs.getString("CONTENT"),
					rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),rs.getBoolean("PUB")
			);
		}

		rs.close();
		st.close();
		con.close();

		return notice;

	}

	public List<NoticeView> getNoticeViewList() throws SQLException, ClassNotFoundException {

//		NoticeView[] list = new NoticeView[10];
		List<NoticeView> list = new ArrayList<>();

		String sql = "SELECT * FROM NOTICE_VIEW WHERE NUM BETWEEN 1 AND 10"; // Notice_VIEW에 정렬이 되어있음

		String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "LEC", "111");
		PreparedStatement st = con.prepareStatement(sql);
		// st.setString(1, id);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			NoticeView noticeView = new NoticeView(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("WRITER_ID"),
					// rs.getString("CONTENT"),
					rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),rs.getBoolean("PUB"), rs.getString("WRITER_NAME"),
					rs.getInt("CMT_COUNT")

			);
			list.add(noticeView);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}
	
//	public List<Notice> getNoticeList() throws SQLException, ClassNotFoundException {
//
////		NoticeView[] list = new NoticeView[10];
//		List<Notice> list = new ArrayList<>();
//
//		String sql = "SELECT * FROM NOTICE "; // Notice_VIEW에 정렬이 되어있음
//
//		String url = "jdbc:oracle:thin:@192.168.0.79:1521/xepdb1";
//
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection con = DriverManager.getConnection(url, "LEC", "111");
//		PreparedStatement st = con.prepareStatement(sql);
//		// st.setString(1, id);
//
//		ResultSet rs = st.executeQuery();
//
//		while (rs.next()) {
//			Notice notice = new Notice(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("WRITER_ID"),
//					 rs.getString("CONTENT"),
//					rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES")
//
//			);
//			list.add(notice);
//		}
//
//		rs.close();
//		st.close();
//		con.close();
//
//		return list;
//	}
}
