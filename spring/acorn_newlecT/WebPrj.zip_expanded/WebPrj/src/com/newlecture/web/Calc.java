package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int x = 0;
		int y = 0;
		
		String x_ = req.getParameter("x");
		if(x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);
		
		String y_ = req.getParameter("y");
		if(y_ != null && !y_.equals(""))
			y = Integer.parseInt(y_);
				
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out =resp.getWriter();
		
		out.println(x+y);
		
		//out.println("<a href=\"calc.html\">¿‘∑¬∆‰¿Ã¡ˆ</a>");
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"calc\" method=\"post\">");
		out.write("		<fieldset>");
		out.write("			<legend>µ°º¿¿ª ¿ß«— ¿‘∑¬</legend>");
		out.write("			<label>x</label>");
		out.write("			<input type=\"text\" name=\"x\">");
		out.write("			<label>y</label>");
		out.write("			<input type=\"text\" name=\"y\">");
		out.write("			<input type=\"submit\" value=\"µ°º¿\">");
		out.write("		</fieldset>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
		
	}
}
