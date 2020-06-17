package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.newlecture.web.entity.Notice;

public class Program {

	public static void main(String[] args) {
		// 콜렉션 (Collection) : 라이브러리
		// (고정)배열 <-> 가변배열
		// 가변배열의 종류 (Set, List, Map)
		// 종류별 차이점은 식별자의 차이
		// Set의 식별자는? (X) 값==식별자
		// => 중복제거용으로 많이 사용
		// List의 식별자는? index 
		// => 배열의 대체제로 많이 사용
		// Map의 식별자는? 내가 정해준 컬럼 값
		// => 객체형식을 대체하는 임시 객체로 많이 사용
		
		// 식별자와 상관없이 데이터를 순회하는 방법의 필요성
		// Iterable 인터페이스(iterator(){return new Iterator();})
		// "index", hasNext(), next(); => index를 개별화
		// 스레드에 안전한 열거를 위해서 
		// => iterator()를 통해서 열거를 위한 index를 개별화
		
		// 열거하는 데이터가 객체일 경우에 .. 그 기능을 사용하는 방법에서
		// 형식을 변환해야만 하는 불편함이 있다. 또한 형식 변환에서 치명적인 오류가 발생한다.
		
		//Generic
		//Generic을 직접 구현해보고 탐구하는 것은 일단 뒤로 미루어도 완전 무방함.
				
		Set<Exam> set = new HashSet<>();
		List list = new ArrayList();
		Map map = new HashMap();
				
		set.add(new Exam());
		set.add(new Exam(20,30,40));	
		//set.add("hello");
		//set.add(234.55);
		
		for(Exam exam : set) {
			//Exam exam = (Exam)n;
			System.out.println(exam.total());
		}
		
		
		System.out.println("------------------");
		
//		it = set.iterator();
//		while(it.hasNext())
//			System.out.println(it.next());
		
		System.out.println("------------------");
		
		//set.get(0);		
		list.add(3);
		list.add(4);
		list.add(3);
		list.add(4);
		
		map.put("id", 1);
		map.put("title", "hello");
		map.put("hit", 0);
		
		System.out.println(list.get(0));
		
		Notice notice = new Notice();
		Notice notice1 = new Notice();
		
		System.out.println(notice);
		System.out.println(notice1);
		
		String a = "hello" + notice;
		
		System.out.println(a);
	}

}
