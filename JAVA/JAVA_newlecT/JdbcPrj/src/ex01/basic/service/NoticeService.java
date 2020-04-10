package ex01.basic.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ex01.basic.entity.Notice;

public class NoticeService {

	public Notice[] getMemberById(String title) throws SQLException {
		
		int max=1; 
		
		Notice[] notice = new Notice[max];

		// ojdbc8.jar 라이브러리에 add 필요!
		String url = "jdbc:oracle:thin:@192.168.0.19:1521/xepdb1";
		String sql = "SELECT * FROM NOTICE WHERE TITLE LIKE '%" + title + "%'"; 

		Connection connection = DriverManager.getConnection(url, "lec", "111");
		Statement statement = connection.createStatement(); // 쿼리 실행 문장
		ResultSet resultSet = statement.executeQuery(sql);
		
//		Connection connection = DriverManager.getConnection(url, "lec", "111");
//		PreparedStatement statement = connection.prepareStatement(sql); // 위에 sql ?를 채워주는 statement 확장
//		statement.setString(1, title); // ? 표가 1번째 2번째 3번째.... --> 첫번째 물음표에 name값을 할당하겠다.
//			--> title값이 공지 라고 하면 '공지' 라고 자동으로 묶인다. %'공지'% 이렇게 됨..
		//		ResultSet resultSet = statement.executeQuery();
		
		int index = 0;
		
		while (resultSet.next()) {
			notice[index] = new Notice();
			notice[index].setId(resultSet.getInt("ID"));
			notice[index].setTitle(resultSet.getString("TITLE"));
			notice[index].setWriter_id(resultSet.getString("WRITER_ID"));
			notice[index].setHit(resultSet.getInt("HIT"));
			notice[index].setFile(resultSet.getString("FILES"));
			notice[index].setContent(resultSet.getString("CONTENT"));
			notice[index].setRegdate(resultSet.getDate("REGDATE"));
			index++;
			
			if(index>=max) { //인덱스가 배열 최대 개수보다 크면
				Notice[] temp = new Notice[max+3]; //원본배열보다 큰 임시배열 생성
				
				for (int j = 0; j < index; j++) //원본배열에 있는 값들을 임시배열에 값 저장
					temp[j] = notice[j];

				notice = temp; //임시배열을 원본배열 변수가 참조
				max += 3;
//				max=max+3;
			}
		
		}

		resultSet.close();
		statement.close();
		connection.close();

		return notice;
	}

}
