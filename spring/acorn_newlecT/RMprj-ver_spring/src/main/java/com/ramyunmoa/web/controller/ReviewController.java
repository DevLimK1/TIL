package com.ramyunmoa.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ramyunmoa.web.dao.ReviewDao;
import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.entity.review.MfcProductView;
import com.ramyunmoa.web.entity.review.ReviewCmt;
import com.ramyunmoa.web.entity.review.ReviewDetailView;
import com.ramyunmoa.web.entity.review.ReviewListView;

@Controller
@RequestMapping("/review/")
public class ReviewController {
	@Autowired // 알아서 해당 클래스객체를 연결시켜준다.
	private ReviewDao reviewDao;

	@GetMapping("list")
	public String list(@RequestParam(name = "p", defaultValue = "1") Integer page,
			@RequestParam(name = "q", defaultValue = "") String query,
			@RequestParam(name = "f", defaultValue = "title") String field, Model model) {

		System.out.println("getMapping list");
		int count = 0;

		List<ReviewListView> list = reviewDao.getReviewListView(field, query, page);
		count = reviewDao.getReviewCount(field, query);

		model.addAttribute("list", list);
		model.addAttribute("count", count);

		return "board.review.list";
	}

	@GetMapping("detail")
	public String detail(int id, Model model) {

		ReviewDetailView rdv = reviewDao.getReviewDetailView(id);
		List<ReviewCmt> cmt = reviewDao.getReviewCmt(id);

		model.addAttribute("cmt", cmt);
		model.addAttribute("r", rdv);

		return "board.review.detail";
	}

	@GetMapping("reg")
	public String reg(Model model) {
		List<MfcProductView> mpv = new ArrayList<MfcProductView>();
		List<Grade> grade = new ArrayList<Grade>();
		Member member = new Member();

//		HttpSession session = request.getSession();

//		String uid=(String)session.getAttribute("uid");
		String uid = "kyewnon";

		mpv = reviewDao.getMfcProductViewList();
		grade = reviewDao.getGrade();
		member = reviewDao.getMember(uid);

		System.out.println(member);

		model.addAttribute("mpv", mpv);
		model.addAttribute("grade", grade);
		model.addAttribute("member", member);

//		RequestDispatcher dispatcher = model.getRequestDispatcher("/WEB-INF/view/board/review/reg.jsp");
//		dispatcher.forward(request, response);

//		TilesContainer container = TilesAccess.getContainer(request.getSession().getServletContext());
//		container.render("review.reg", request, response);
		return "board.review.reg";
	}

}
