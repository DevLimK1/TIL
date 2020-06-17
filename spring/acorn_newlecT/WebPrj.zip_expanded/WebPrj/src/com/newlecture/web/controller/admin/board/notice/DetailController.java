package com.newlecture.web.controller.admin.board.notice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@WebServlet("/admin/board/notice/detail")
public class DetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. ����� �Է�
		int id = Integer.parseInt(request.getParameter("id"));		
		//2. �����ͺ��̽����� ����
		NoticeService service = new NoticeService();
		Notice notice = null;
		try {
			notice = service.getNotice(id);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		//3. View���� ����
		request.setAttribute("n", notice);
		
		TilesContainer container = TilesAccess.getContainer(
		        request.getSession().getServletContext());
		container.render("admin.board.notice.detail", request, response);
	}
}



