package com.newlecture.web.controller.admin.member.student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.Member;
import com.newlecture.web.service.MemberService;

/**
 * Servlet implementation class MbRegController
 */
@WebServlet("/admin/member/student/reg")
public class MbRegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("admin.member.student.reg", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		String uid=request.getParameter("uid");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String birthday=request.getParameter("birthday");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		

		
		//데이터 등록
		
		
		Member member=new Member();
		member.setUid(uid);
		member.setPwd(pwd);
		member.setName(name);
		member.setGender(gender);
		member.setBirthday(birthday);
		member.setPhone(phone);
		member.setEmail(email);
//		notice.setTitle(title);
//		notice.setWriterId("devilmilk");
//		notice.setContent(content);
//		notice.setFiles(fileName);
		
		MemberService service=new MemberService();
		try {
			service.insertNotice(member);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		//		새로 요청하는거임
		response.sendRedirect("list");
	}


}
