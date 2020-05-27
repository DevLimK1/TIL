package com.newlecture.web.controller.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/notice/list-data") //Restful data-> xml,csv,"json"
public class ListRestController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int page=1;
		
		//사용자한테 넘어온 페이지 값
		String page_=request.getParameter("p");
		if(page_!=null && !page_.equals(""))
			page=Integer.parseInt(page_);
		
		List<NoticeView> list = null;
		NoticeService service = new NoticeService();

		
		
		try {
			list = service.getNoticeViewList(page);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		request.setAttribute("list", list);
		
//		Gson gson = new Gson();
//		String json= gson.toJson(list);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd")
				.create(); // 날짜 포맷 설정방법
		String json = gson.toJson(list);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PrintWriter out= response.getWriter();
		out.write(json);
		
//		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
//		container.render("notice.list", request, response);
	}
}
