package com.newlecture.web.controller.admin.board.notice;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 100 * 1024 * 1024, maxRequestSize = 300 * 1024 * 1024)
@WebServlet("/admin/board/notice/reg")
public class RegController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/admin/board/notice/reg.jsp").forward(request, response);
		/*
		 * TilesContainer container =
		 * TilesAccess.getContainer(request.getSession().getServletContext());
		 * container.render("admin.board.notice.reg", request, response);
		 */
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("UTF-8");

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fileNames="";
		
		Collection<Part> parts = request.getParts(); // 2개 이상의 첨부파일을 받을 때 사용하기 위함

		for (Part part : parts) {
			
			String a1=part.getContentType();
			String name=part.getName();
			
			System.out.printf("type:%s ,name:%s\n",a1,name);
			
			if(!name.equals("file")) continue;
			
			String fileName = "";

			// 업로드한 파일 저장하기
//			Part part = request.getPart("file");
			fileName = part.getSubmittedFileName(); // 전송된 파일명
//		fileName = request.getPart("file").getSubmittedFileName();
			
//		String path="/upload"; //상대경로 -> , 원래는 진짜 물리경로를 알아야한다.
			String path = request.getServletContext().getRealPath("/upload3");// 상대경로->시스템(물리)경로로 바꿔줌
//		path=path+"\\"+fileName; --> 역슬래쉬는 윈도우에서만..
			path += File.separator + fileName;
			System.out.println(path);
			part.write(path);
			fileNames+=fileName;
			fileNames+=",";
		}
		
		fileNames=fileNames.substring(0, fileNames.length()-1); //뒤에 꼬랑지 빼는 방법
		

//		part.getInputStream();
//		part.write(path+fileName); //c:\temp aa.png

		// 데이터 등록

		Notice notice = new Notice();
		notice.setTitle(title);
		notice.setWriterId("devilmilk");
		notice.setContent(content);
		notice.setFiles(fileNames);

		NoticeService service = new NoticeService();
		try {
			service.insertNotice(notice);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 새로 요청하는거임
		response.sendRedirect("list");
	}

}
