package com.newlecture.web.controller.admin.board.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;



@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
		container.render("admin.board.notice.reg", request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");
		
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		Notice notice=new Notice();
		notice.setTitle(title);
		notice.setWriterId("devilmilk");
		notice.setContent(content);
		
		NoticeService service=new NoticeService();
		try {
			service.insertNotice(notice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		
		//		새로 요청하는거임
		response.sendRedirect("list");
	}


}
