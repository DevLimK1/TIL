package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list")
public class ListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<NoticeView> list=null;
		NoticeService service =new NoticeService();
		
		try {
			list=service.getNoticeViewList();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("list.jsp").forward(request,response);
	}
}
