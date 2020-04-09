package ex01.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws SQLException {
		// 회원 이름을 입력창이 뜨고 회원 이름이 입력된게 뜨게 한다.
		Scanner scanner = new Scanner(System.in);
		String id = scanner.nextLine();

		String url = "jdbc:oracle:thin:@192.168.0.19:1521/xepdb1";
		String sql = "SELECT * FROM MEMBER WHERE ID='" + id + "'";

//		Class.forName("oracle.jdbc.driver.OracleDriver"); //jdk 1.8버전부터 알아서 탐색해줘서 생략해도 됨
		// 밑에 계속 복붙해서 씀
		Connection connection = DriverManager.getConnection(url, "lec", "111");
		Statement statement = connection.createStatement(); // 실행 문장이라고 생각하면 된다.
		ResultSet resultSet = statement.executeQuery(sql); // 정상적으로 실행될 때 빈그릇이 생성된거임

		String idString = "";
		String nameString = "";
		String genderString = "";
		String pwdString = "";

		int i = 0;

		while (resultSet.next()) {
			i++;
			idString = resultSet.getString("ID");
			pwdString = resultSet.getString("PWD");
			nameString = resultSet.getString("NAME");
			genderString = resultSet.getString("GENDER");
			System.out.printf("%d->ID:%s PWD:%s NAME: %s GENDER:%s\n", i, idString, pwdString, nameString,
					genderString);
		}

	}

}