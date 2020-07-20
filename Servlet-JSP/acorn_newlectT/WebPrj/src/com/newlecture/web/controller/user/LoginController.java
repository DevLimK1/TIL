package com.newlecture.web.controller.user;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.service.MemberService;

@WebServlet("/member/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("member.login", request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String uid=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		MemberService memberService=new MemberService();
		
		
		
		try {
			if(!memberService.isValid(uid,pwd)) {
				String msg="<script>"
						+ "alert('아이디 또는 비밀번호가 올바르지 않습니다.');"
						+ "window.location.href='login';" //login 페이지로 이동(클라이언트에서 redirect시킴)
						+ "</script>";
				//response.sendRedirect("login?e=1"); //에러표시,서버에서 redirect 
				response.getWriter().println(msg);
			}
			else {
				//인증처리하기
				//request.getServletContext();//application 객체
				HttpSession session=request.getSession(); //session 객체
				session.setAttribute("uid", uid);
				
				MemberService service = new MemberService();
				String role = service.getRoleByUserId(uid);
				session.setAttribute("role", role); //로그인할 때 한번 사용, 역할도 세션에 추가해서 계속 사용한다. 필요할 때마다 불러오는게 아니라.
				
				String returnURL = request.getParameter("returnURL");
				System.out.println("returnURL:"+returnURL);
				//만약에 returnURL이 있다면
				if(returnURL!=null && !returnURL.equals(""))
					response.sendRedirect(returnURL); 
				else
					response.sendRedirect("../index");
				
				//그렇지 않다면
				
				//마이홈으로 경로 이동하거나 / index로 이동하거나
//				response.sendRedirect("../index");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	
}
