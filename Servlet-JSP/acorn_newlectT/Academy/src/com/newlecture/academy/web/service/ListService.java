package com.newlecture.academy.web.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.newlecture.academy.web.entity.List;

public class ListService {

	public List insertList(List list) throws SQLException, ClassNotFoundException {

		int result = 0;
		List li = null;

		String sql = "INSERT INTO List(title, regMemberId) VALUES(?,?)";
		String sql2 = "SELECT * FROM List WHERE regMemberId=? ORDER BY REGDATE DESC LIMIT 1"; // 최근 데이터 하나만 추출

		String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";

		Connection con = null;
		PreparedStatement st = null;
		PreparedStatement st2 = null;
		ResultSet rs2 = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, "newlecture", "111");
			con.setAutoCommit(false);
			st = con.prepareStatement(sql);
			st.setString(1, list.getTitle());
			st.setString(2, list.getRegMemberId());

			result = st.executeUpdate(); // AutoCommit

			st2 = con.prepareStatement(sql2);
			st2.setString(1, list.getRegMemberId());

			rs2 = st2.executeQuery(); // AutoCommit
			if (rs2.next()) {
				li = new List();
				li.setId(rs2.getInt("id"));
				li.setTitle(rs2.getString("title"));
				li.setRegDate(rs2.getDate("regDate"));
				li.setRegMemberId(rs2.getString("regMemberId"));
			}

			con.commit(); // 수동적인(manual) commit

			st.close();
			rs2.close();
			st2.close();
//			con.close();
		} // ~try
		catch (SQLException e) { // 쿼리 실행하다 오류

			try {
				if (con != null)
					con.rollback();
				
				if (st != null)
					st.close();
			
				rs2.close(); // commit이 제대로 되지 않았을 때도 닫아줘야함
				st2.close();
//				con.close();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new SQLException(); //UI가 처리하라는 예외메시지를 던진다.

		} catch (Exception e) {
			throw new ClassNotFoundException(); //UI가 처리하라는 예외메시지를 던진다.
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return li;

	}
}


//강사님 코드
//package com.newlecture.academy.web.service;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.newlecture.academy.web.entity.List;
//
//public class ListService { 
//   
//   public List insertList(List list) throws SQLException, ClassNotFoundException{
//      
//      int result = 0;
//      List li = null;
//      
//      String sql = "INSERT INTO List(title, regMemberId) VALUES(?,?)";
//      String sql1 = "SELECT * FROM List WHERE regMemberId=? ORDER BY REGDATE DESC LIMIT 1";
//      
//      String url = "jdbc:mysql://dev.notepubs.com:9898/newlecture?useSSL=false&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC";
//
//      Connection con = null;
//      PreparedStatement st = null;
//      PreparedStatement st1 = null;
//      ResultSet rs1 = null;
//      try {
//         Class.forName("com.mysql.cj.jdbc.Driver");
//         con = DriverManager.getConnection(url, "newlecture", "111");
//         con.setAutoCommit(false);
//         st = con.prepareStatement(sql);
//         st.setString(1, list.getTitle());
//         st.setString(2, "newlec");
//         
//         result = st.executeUpdate(); //AutoCommit
//         
//         st1 = con.prepareStatement(sql1);      
//         st1.setString(1, "newlec");
//         
//         rs1 = st1.executeQuery(); //AutoCommit
//         if(rs1.next()) {
//            li = new List();
//            li.setId(rs1.getInt("id"));
//            li.setTitle(rs1.getString("title"));
//            li.setRegDate(rs1.getDate("regDate"));
//            li.setRegMemberId(rs1.getString("regMemberId"));
//         }
//         
//         con.commit();      
//         
//         st.close();
//         rs1.close();
//         st1.close();
//         con.close();
//      }
//      catch(SQLException e) {
//         
//         try {
//            if(con != null)
//            con.rollback();
//            
//         } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//         }
//         throw e;
//      }
//      catch(Exception e) {
//         throw new ClassNotFoundException();
//      }
//      finally {
//         try {
//            
//            if(st != null)
//               st.close();
//            
//            rs1.close();
//            st1.close();
//            con.close();            
//         } catch (SQLException e1) {
//            // TODO Auto-generated catch block
//            e1.printStackTrace();
//         }
//      }
//      
//      return li;
//      
//   }
//}

