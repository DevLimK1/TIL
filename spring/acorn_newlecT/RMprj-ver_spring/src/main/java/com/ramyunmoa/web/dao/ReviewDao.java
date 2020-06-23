package com.ramyunmoa.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.ramyunmoa.web.entity.member.Member;
import com.ramyunmoa.web.entity.review.Grade;
import com.ramyunmoa.web.entity.review.MfcProductView;
import com.ramyunmoa.web.entity.review.ReviewCmt;
import com.ramyunmoa.web.entity.review.ReviewDetailView;
import com.ramyunmoa.web.entity.review.ReviewListView;

@Mapper
public interface ReviewDao {
	
	// 리뷰 목록 검색
	@Select("SELECT * FROM ReviewListView WHERE ${field} LIKE '%${query}%' ORDER BY regdate DESC LIMIT 10")
	List<ReviewListView> getReviewListView(String field, String query, int page);
	
	// 리뷰 게시판 글 갯수
	@Select("SELECT COUNT(ID) COUNT FROM ReviewListView WHERE ${field} LIKE '%${query}%' ORDER BY regdate DESC")
	int getReviewCount(String field, String query);

	// 자세한 페이지 조회
	@Select("SELECT * FROM ReviewDetailView WHERE id=${id}")
	ReviewDetailView getReviewDetailView(int id);

	// 자세한페이지 댓글 목록
	@Select("SELECT * FROM ReviewCmt WHERE reviewId=${id} and bossId IS NULL")
	List<ReviewCmt> getReviewCmt(int id);

	// 제조사-라면 목록
	@Select("SELECT * FROM MfcProductView ORDER BY id")
	List<MfcProductView> getMfcProductViewList();

	//회원 정보 가져오기
	@Select("SELECT * FROM Member WHERE uid=#{uid}")
	Member getMember(String uid);

	//평점 목록 조회
	@Select("SELECT * FROM Grade")
	List<Grade> getGrade();
	
	
	
	
	
	
}
