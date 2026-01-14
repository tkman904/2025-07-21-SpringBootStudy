package com.sist.main;

import java.util.*;

public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> names = new ArrayList<String>();
//		names.add("서동현");
//		names.add("김민식");
//		names.add("이수현");
//		names.add("이철우");
//		names.add("지은표");
//		
//		for(String name : names) {
//			System.out.println(name);
//		}
//		
//		System.out.println("===============");
//		names.forEach(name->System.out.println(name));
		List<String> colors = List.of("red", "blue", "black", "green", "purple");
		colors.stream()
				.filter(c->c.startsWith("b"))
				.map(String::toUpperCase)
				/*.forEach(System.out::println);*/
				.forEach(c->System.out.println(c));
		// 검색 / 정렬 / 출력 / null 체크
	}

}
