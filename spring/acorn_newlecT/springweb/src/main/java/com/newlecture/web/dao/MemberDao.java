package com.newlecture.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.newlecture.web.entity.Member;

@Mapper
public interface MemberDao {

	@Insert("INSERT INTO Member(uid,pwd,name) values(#{uid},#{pwd},#{name})")
	int insert(Member member);

}
