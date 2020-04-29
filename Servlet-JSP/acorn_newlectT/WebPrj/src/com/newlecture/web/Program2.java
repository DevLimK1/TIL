package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program2 {
	public static void main(String[] args) {
		Set<Exam> set =new HashSet<>(); //HashSet<Exam> 생략가능
		List list=new ArrayList();
		Map map= new HashMap();
		
		set.add(new Exam());
		set.add(new Exam(20,30,40));   
//		set.add("hello");
		//set.add(234.55);
		
	
		for(Exam exam : set) {
//			Exam exam=(Exam)n;
			System.out.println(exam.total()); // 
		}
		
		System.out.println("----------------------------");
		Iterator iterator=set.iterator();
		while(iterator.hasNext())
			System.out.println(iterator.next()); //결과 : (내용출력 없음)
		
		System.out.println("----------------------------");
		
		iterator=set.iterator(); //열거할 인덱스를 초기화된 새로운 값을 부여받은것!
		while(iterator.hasNext())
			System.out.println(iterator.next()); //결과 : 3(\n) 4
		
		System.out.println("----------------------------");
		//set.get(0);
		
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(4);
		
		list.get(0);

		System.out.println(list.get(0));
		
		System.out.println("----------------------------");
		map.put("id", 1);
		map.put("title","hello");
		map.put("hit",0);
		
		
	}
}
