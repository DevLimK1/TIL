package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@Controller("adminNoticeController")
@RequestMapping("admin/board/notice/")
public class NoticeController {

	@Autowired // 알아서 해당 클래스객체를 연결시켜준다.
	private NoticeService noticeService;
	//	private NoticeDao noticeDao;
	

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "f", defaultValue = "title") String field, Model model)
			throws ClassNotFoundException, SQLException {
		System.out.println("Get");
		System.out.println("page:" + page);
		System.out.println("query:" + query);
		System.out.println("field:" + field);

		List<NoticeView> list = noticeService.getList(page, query, field);
		model.addAttribute("list", list);
	/*	
		Map<String, String> cate1=new HashMap<>();
		cate1.put("title", "수업노트");
		
		Map<String, String> cate2= new HashMap<>();
		cate2.put("title","코드예제");
		
		List<Map<String, String>> categories= new ArrayList<>();
		categories.add(cate1);
		categories.add(cate2);
		
		model.addAttribute("categories",categories);
	 */
		
//		return "admin/board/notice/list"; // view ->application.properties에 prefix,suffix 참고
		return "admin.board.notice.list";
	}

//	@GetMapping("detail")//notice/detail?id=1
//	public String detail(int id, Model model) throws ClassNotFoundException, SQLException {
	@GetMapping("{id}") // notice/1
	public String detail(@PathVariable("id") int id, Model model) throws ClassNotFoundException, SQLException {
		Notice notice = noticeService.get(id);
		model.addAttribute("n", notice);

		return "admin.board.notice.detail"; // view ->application.properties에 prefix,suffix 참고
	}

//	@RequestMapping(value = "reg",method = RequestMethod.GET)
	@GetMapping("reg")
	public String reg() {
		System.out.println("Get");
		return "admin.board.notice.reg"; // view ->application.properties에 prefix,suffix 참고
	}

	@PostMapping("reg-ajax")
	public String reg(@RequestBody Notice notice) { // ->Notice 클래스안에 setId, setTitle이 있어야 mapping가능!
		// {id=1, title="hello"} json 데이터 가정
		return "ok";
	}

//	@RequestMapping(value = "reg",method = RequestMethod.POST)
	@PostMapping("reg")
	public String reg(Notice notice, 
			MultipartFile[] file, 
			HttpServletRequest request,
			Principal principal) throws IOException {
		// file은 name 키값 으로 가지고오는거다	
		// Principal 인증된 사용자 정보를 담고있는 클래스
		
		
		String uid=principal.getName();
		System.out.println("uid:"+uid);
		
		notice.setWriterId(uid);
		
		
		// public String reg(String title,String content) {
		System.out.println("post");
//		System.out.println(notice);
//		System.out.println(file.getOriginalFilename());

//		System.out.println(file.getOriginalFilename()); // getName()은 input이 가지는 name이기 때문에 X

		for (MultipartFile f : file) {

			String path = request.getServletContext().getRealPath("/upload/"); // 절대 경로 얻음
			// ★중요★ /upload 만 쓰면 파일이 만들어지고 /upload/를 쓰면 경로가 만들어지는거다.

			File file1 = new File(path);

			System.out.println(file1);

			if (!file1.exists())
				file1.mkdir();

			path += File.separator + f.getOriginalFilename();
			System.out.println(path);

			FileOutputStream os = new FileOutputStream(path);

//		part.write(path);
//		fileNames += fileName;
//		fileNames += ",";

			InputStream is = f.getInputStream();
			byte[] buf = new byte[1024];
			int len = 1024;

			while ((len = is.read(buf)) != -1) // buf만큼 읽어온다.(1024)
				os.write(buf, 0, len); // 만약 782가 남았으면 782까지 읽고 -1이 된다.

			is.close();
			os.close();
		}

		// return "list"; //view ->application.properties에 prefix,suffix 참고
		return "redirect:list"; // -> 리다이렉트
	}

}
