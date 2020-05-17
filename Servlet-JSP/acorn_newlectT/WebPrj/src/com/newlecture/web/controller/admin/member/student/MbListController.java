package com.newlecture.web.controller.admin.member.student;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.Member;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.MemberService;
import com.newlecture.web.service.NoticeService;

/**
 * Servlet implementation class MbListController
 */
@WebServlet("/admin/member/student/list")
public class MbListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Member> list=null;
		MemberService service =new MemberService();
		
		try {
			list=service.getMemberList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("admin.member.student.list", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
