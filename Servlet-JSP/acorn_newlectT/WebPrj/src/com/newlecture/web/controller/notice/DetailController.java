package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

//jsp파일은 오직 컨트롤러에서 건들인다!
@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_=request.getParameter("id");
		int id =Integer.parseInt(id_);
		
		NoticeService service =new NoticeService();
		Notice notice=null; /* model : 출력할 데이터 */ 
		
		try {
			
			notice =service.getNotice(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("n", notice);
	
		//response.sendRedirect(""); -->리다이렉트
		request.getRequestDispatcher("detail.jsp").forward(request, response);
	
	}
}
