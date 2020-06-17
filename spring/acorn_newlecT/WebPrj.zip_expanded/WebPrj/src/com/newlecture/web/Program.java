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
		// �ݷ��� (Collection) : ���̺귯��
		// (����)�迭 <-> �����迭
		// �����迭�� ���� (Set, List, Map)
		// ������ �������� �ĺ����� ����
		// Set�� �ĺ��ڴ�? (X) ��==�ĺ���
		// => �ߺ����ſ����� ���� ���
		// List�� �ĺ��ڴ�? index 
		// => �迭�� ��ü���� ���� ���
		// Map�� �ĺ��ڴ�? ���� ������ �÷� ��
		// => ��ü������ ��ü�ϴ� �ӽ� ��ü�� ���� ���
		
		// �ĺ��ڿ� ������� �����͸� ��ȸ�ϴ� ����� �ʿ伺
		// Iterable �������̽�(iterator(){return new Iterator();})
		// "index", hasNext(), next(); => index�� ����ȭ
		// �����忡 ������ ���Ÿ� ���ؼ� 
		// => iterator()�� ���ؼ� ���Ÿ� ���� index�� ����ȭ
		
		// �����ϴ� �����Ͱ� ��ü�� ��쿡 .. �� ����� ����ϴ� �������
		// ������ ��ȯ�ؾ߸� �ϴ� �������� �ִ�. ���� ���� ��ȯ���� ġ������ ������ �߻��Ѵ�.
		
		//Generic
		//Generic�� ���� �����غ��� Ž���ϴ� ���� �ϴ� �ڷ� �̷� ���� ������.
				
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
