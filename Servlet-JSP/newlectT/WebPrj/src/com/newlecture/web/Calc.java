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
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		int x=0;
		int y=0;
		int sum=0;
		String xString=req.getParameter("x");
		String yString=req.getParameter("y");
		
		if(xString!=null&& !xString.equals("")) {
			x=Integer.parseInt(xString);
			sum+=x;
		}
		if(yString!=null&& !yString.equals("")) {
			y=Integer.parseInt(yString);
			sum+=y;
		}
	
		PrintWriter out = resp.getWriter();
		out.println("sum : "+sum);
		
		//out.println("<a href=\"calc.html\">요청페이지</a>");
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("	<form action=\"calc\" method=\"post\">");
		out.write("	  <fieldset>");
		out.write("		<legend>덧셈을 위한 입력</legend>");
		out.write("		<label>x</label>" );
		out.write("		<input type=\"text\" name=\"x\">"); 
		out.write("		<label>y</label>");
		out.write("		<input type=\"text\" name=\"y\">");
		out.write("		<input type=\"submit\" value=\"덧셈\">");
		out.write("	  </fieldset>");
		out.write("	</form>");
		out.write("</body>");
		out.write("</html>");
		
		
	}
}
