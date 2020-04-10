package ex01.basic.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ex01.basic.entity.Member;

public class MemberService {

	public Member getMemberById(String id) throws SQLException {
		
		Member member = null;

		// ojdbc8.jar 라이브러리에 add 필요!
		String url = "jdbc:oracle:thin:@192.168.0.19:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE ID=?"; // ? 문법 사용

		// String.format 사용방법
		// String sqlString=String.format("SELECT * FROM MEMBER WHERE NAME='%s'", name);

		Connection connection = DriverManager.getConnection(url, "lec", "111");
		// Statement statement=connection.createStatement(); //실행 문장이라고 생각하면 된다.
		PreparedStatement statement = connection.prepareStatement(sql); // 위에 sql ?를 채워주는 statement 확장
		statement.setString(1, id); // ? 표가 1번째 2번째 3번째.... --> 첫번째 물음표에 name값을 할당하겠다.

		//		ResultSet resultSet=statement.executeQuery(sql); //정상적으로 실행될 때 빈그릇이 생성된거임, PreparedStatement 사용하면 sql을 인자값으로 넘겨주지 않아도 됨
		ResultSet resultSet = statement.executeQuery();
		

		while(resultSet.next()) {
			member=new Member();
			member.setId(resultSet.getString("ID"));
			member.setPwd(resultSet.getString("PWD"));
			member.setName(resultSet.getString("NAME"));
			member.setGender(resultSet.getString("GENDER"));
			member.setBirthday(resultSet.getString("BIRTHDAY"));
			member.setEmail(resultSet.getString("EMAIL"));
			member.setPhone(resultSet.getString("PHONE"));
			member.setRegdate(resultSet.getDate("REGDATE"));
		}
		
		
		resultSet.close();
		statement.close();
		connection.close();
		
		
		return member;
	}
	
}
