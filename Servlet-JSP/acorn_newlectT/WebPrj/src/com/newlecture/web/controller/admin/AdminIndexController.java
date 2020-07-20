package com.newlecture.web.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

@WebServlet("/admin/index")
public class AdminIndexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
/*	AuthenticationFilter.java로 옮김	
	HttpSession session = request.getSession();// 세션으로 했으면 세션으로, 쿠리로했으면 쿠키로


	Object uid=session.getAttribute("uid"); //uid가 null이면 문자열 null이 아닌 null 그 자체로 값을 받기위해
		
	if (uid == null) // 인증 방식이 안되었음 -> 로그인
			response.sendRedirect("../member/login?returnURL=/admin/index"); // returnURL은 절대경로로 써야한다.
	else {

			
			String role = String.valueOf(session.getAttribute("role"));
			if (role!=null && !role.equals("admin")) //관리자가 아니면
				response.sendRedirect("../error/403");
			
			//1번째 방법
			try {
			MemberService service = new MemberService();
				String userName = String.valueOf(uid);
				String role = service.getRoleByUserId(userName);
				if (role!=null && !role.equals("admin")) //관리자가 아니면
					response.sendRedirect("../error/403");
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
*/
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("admin.index", request, response);
	}
}
