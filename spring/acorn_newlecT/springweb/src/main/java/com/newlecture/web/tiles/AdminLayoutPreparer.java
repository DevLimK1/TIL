package com.newlecture.web.tiles;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tiles.AttributeContext;
import org.apache.tiles.preparer.ViewPreparer;
import org.apache.tiles.request.Request;
import org.springframework.beans.factory.annotation.Autowired;

import com.newlecture.web.service.NoticeService;

//Spring이 인지하지 못하는 클래스이다. ->tiles는 Spring 영역이 아님
public class AdminLayoutPreparer implements ViewPreparer {

	@Autowired
	private NoticeService categoryService; 
	//@Autowired쓰면 NullPointer가 발생한다. -> TilesConfig에서 설정을 따로 해줘야한다.
	
	@Override
	public void execute(Request tilesContext, AttributeContext attributeContext) {
		
		Map<String, Object> model= tilesContext.getContext("request");
		
//		Map<String, String> cate1=new HashMap<>();
//		cate1.put("title", "수업노트");
//		
//		Map<String, String> cate2= new HashMap<>();
//		cate2.put("title","코드예제");
//		
//		List<Map<String, String>> categories= new ArrayList<>();
//		categories.add(cate1);
//		categories.add(cate2);
		
		try {
			model.put("categories",categoryService.getList(1,"","title"));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
