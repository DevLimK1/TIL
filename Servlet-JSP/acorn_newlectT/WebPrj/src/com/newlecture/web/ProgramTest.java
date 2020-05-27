package com.newlecture.web;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

public class ProgramTest {
	private int id;
	private String title;
	private String content;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	
	public static void main(String[] args) {
		Notice notice=new Notice();
		
		
		NoticeService service=new NoticeService();
		try {
			notice=service.getNotice(920322);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(notice.getId());
		System.out.println(notice.getTitle());
		System.out.println(notice.getWriterId());
	}
	

	public Notice getNotice(int id) throws ClassNotFoundException, SQLException {

		Notice notice = null;

		String sql = "SELECT * FROM Notice WHERE ID=?";

//		String url = "jdbc:oracle:thin:@112.223.37.243:1521/xepdb1";
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

//		Class.forName("oracle.jdbc.driver.OracleDriver");
		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		System.out.println("hello");
		ResultSet rs = st.executeQuery();

		if (rs.next()) {
			notice = new Notice(rs.getInt("ID"), rs.getString("TITLE"), rs.getString("WRITERID"),
					rs.getString("CONTENT"), rs.getDate("REGDATE"), rs.getInt("HIT"), rs.getString("FILES"),
					rs.getBoolean("PUB"));
		}
		
		System.out.println(rs.getInt("id"));
		System.out.println(rs.getString("title"));
		System.out.println(rs.getString("writerId"));

		rs.close();
		st.close();
		con.close();

		return notice;

	}
	
	public int updateNotice(Notice notice) throws SQLException, ClassNotFoundException {
		int result = 0;

		String sql = "UPDATE Notice SET title=?, content=? WHERE id=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3, notice.getId());

		result = st.executeUpdate();

		return result;
	}
}
