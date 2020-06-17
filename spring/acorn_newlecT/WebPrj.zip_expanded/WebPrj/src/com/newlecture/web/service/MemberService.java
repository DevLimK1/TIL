package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.web.entity.Member;

public class MemberService {

	public boolean isValid(String uid, String pwd) throws ClassNotFoundException, SQLException {
		
		Member member = null;
		
		String sql = "SELECT * FROM Member WHERE uid=?";		
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, uid);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			member = new Member();
			member.setId(rs.getInt("id"));
			member.setUid(rs.getString("uid"));
			member.setPwd(rs.getString("pwd"));
		}

		rs.close();
		st.close();
		con.close();
			
		if(member == null)
			return false;
		else if(!member.getPwd().equals(pwd))
			return false;
		
		return true;
	}

	public String getRoleByUserId(String uid) throws ClassNotFoundException, SQLException {

		String roleName = null;
		
		String sql = "SELECT type FROM Member WHERE uid = ?";		
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, "newlecture", "111");		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, uid);
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next())
			roleName = rs.getString("type");
		
		rs.close();
		st.close();
		con.close();
		
		return roleName;
	}
	
}
