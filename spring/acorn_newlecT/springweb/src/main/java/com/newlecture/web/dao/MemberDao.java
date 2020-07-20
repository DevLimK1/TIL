package com.newlecture.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Member;

@Mapper
public interface MemberDao {

	@Insert("INSERT INTO Member(uid,pwd,name) values(#{uid},#{pwd},#{name})")
	int insert(Member member);
	
	@Select("select * from Member where uid=#{uid}")
	Member get(@Param("uid") String uid); //일반 변수로 쿼리에 매칭 할 때 @Param으로 하지 않으면 오류가 발생할 수 있다.

}
