package com.newlecture.web.controller;

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

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@MultipartConfig(
	fileSizeThreshold = 1024*1024,	
	maxFileSize = 1000*1024*1024,
	maxRequestSize = 3000*1024*1024
)
@WebServlet("/upload")
public class UploadController extends HttpServlet {
		
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileNames = "";
		Collection<Part> parts = request.getParts();
		
		for(Part part : parts)
		{
			String a1 = part.getContentType();
			String name = part.getName();
						
			System.out.printf("type:%s, name:%s", a1, name);
			
			if(!name.equals("file")) continue;
			
			String fileName = ""; 
			// 업로드한 파일 저장하기
			//Part part = request.getPart("file");
			fileName = part.getSubmittedFileName();
			
			// 상대경로->시스템(물리)경로
			String path = request.getServletContext()
								.getRealPath("/upload");
				    
			File file = new File(path);
			if(file.exists())
				file.mkdir();
			
			path += File.separator + fileName;
			System.out.println(path);
			part.write(path);
			fileNames += fileName;
			fileNames += ",";
		}
		fileNames = fileNames.substring(0, fileNames.length()-1);
		//part.getInputStream();
		//part.write(path + fileName);// c:\temp   aa.png
		
		response.getWriter().print(fileNames);
	}
}



