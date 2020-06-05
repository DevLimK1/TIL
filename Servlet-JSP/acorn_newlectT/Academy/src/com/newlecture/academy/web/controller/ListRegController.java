package com.newlecture.academy.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newlecture.academy.web.entity.List;
import com.newlecture.academy.web.service.ListService;



@WebServlet("/reg")
public class ListRegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		//1번째 방법 때
//		String title_=request.getParameter("t");
//		System.out.println("title_ :"+title_);
		
//		request.setCharacterEncoding("UTF-8");
		
		//2번째 방법
		InputStream iStream =request.getInputStream(); //byte계열
		Scanner scan=new Scanner(iStream,"UTF-8"); //한글처리 해줘야함
		String lineString =scan.nextLine();
		System.out.println(lineString);
	
		
//		Gson gson= new Gson();
		Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
		List list =gson.fromJson(lineString, List.class);
		
		System.out.println(list);
		ListService service=new ListService();
		List result=null;
		
		try {
			result=service.insertList(list);
		} catch (ClassNotFoundException | SQLException e) {
			response.sendRedirect("/error?n=404"); //에러 controller
		}
		
		String resultJson =gson.toJson(result);

		response.getWriter().write(resultJson);
//		response.getWriter().write(result+"");
		
		System.out.println(result);

	}
}
