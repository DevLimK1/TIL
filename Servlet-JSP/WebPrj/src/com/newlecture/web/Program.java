package com.newlecture.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Program {
	public static void main(String[] args) {
		Set set =new HashSet();
		List list=new ArrayList();
		Map map= new HashMap();
		
		set.add(3); //숫자를 넣으면서 박싱이 어뤄짐
		set.add(4);
		set.add(3);
		set.add(4);
		
	/*	Iterator iterator=set.iterator(); //set 안에 있는 요소 get하려면 iteraotr 객체 생성해야함, 열거하기위한 인덱스를 지칭하는 것
		while(iterator.hasNext())
			System.out.println(iterator.next()); //결과 : 3(\n) 4
		*/
		System.out.println("----------------------------");
		
		for(Object n : set)
			System.out.println(n); // 결과 : 3(\n) 4
		
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
