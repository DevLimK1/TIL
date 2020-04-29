package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class Index extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int count =10;
		
		String count_=req.getParameter("c");
		if(count_!=null&& !count_.equals(""))
			count=Integer.parseInt(count_);
		
		resp.setCharacterEncoding("UTF-8"); //브라우저한테 UTF-8로 보낸거야.
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		for(int i=0;i<count;i++) 
			out.println("안녕 World!<br>");
		
		out.println("<a href=\"index.html\">요청페이지</a>");
		
		
	}
}
