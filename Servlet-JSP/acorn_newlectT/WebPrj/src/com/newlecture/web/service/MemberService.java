package com.newlecture.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Member;

public class MemberService {
	
	public List<Member> getMemberList() throws SQLException, ClassNotFoundException {

		List<Member> list = new ArrayList<>();

		String sql = "SELECT * FROM Member ORDER BY regDate DESC"; 

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		// st.setString(1, id);

		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			Member member= new Member(
					rs.getInt("id"),rs.getString("uid"),rs.getString("name"),
					rs.getString("pwd"),rs.getDate("regDate"),rs.getString("gender"),
					rs.getString("birthday"),rs.getString("phone"),rs.getString("email"),
					rs.getInt("age")
					);

			list.add(member);
		}

		rs.close();
		st.close();
		con.close();

		return list;
	}
	
	
	//등록
	public int insertNotice(Member member) throws SQLException, ClassNotFoundException {

		int result = 0;

		String sql = "INSERT INTO Member(uid,pwd,name,gender,birthday,phone,email) VALUES(?,?,?,?,?,?,?);";
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);
		System.out.println(member.getUid());
		st.setString(1, member.getUid());
		st.setString(2, member.getPwd());
		st.setString(3, member.getName());
		st.setString(4, member.getGender());
		st.setString(5, member.getBirthday());
		st.setString(6, member.getPhone());
		st.setString(7, member.getEmail());

		result = st.executeUpdate();

		return result;
	}


	public boolean isValid(String uid, String pwd) throws SQLException, ClassNotFoundException {
		Member member =null;

		String sql = "SELECT * FROM Member WHERE uid=?";
		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Class.forName("com.mysql.cj.jdbc.Driver"); // 최신버전의 드라이버명이다. 하위버전의 mysql에서는 드라이버 클래스가 달라져야함
		Connection con = DriverManager.getConnection(url, "newlecture", "111");
		PreparedStatement st = con.prepareStatement(sql);

		st.setString(1, uid);

		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			member= new Member();
			member.setId(rs.getInt("id"));
			member.setUid(rs.getString("uid"));
			member.setPwd(rs.getString("pwd"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		if(member==null) //회원이 없음
			return false;
		else if(!member.getPwd().equals(pwd)) //비번 체크!
			return false;

		return true;
	}
	
	
}
