package com.sist.db;

import java.util.*;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmpDAO dao = new EmpDAO();
		List<EmpVO> list = dao.empAllData();
		
		// filter 사용
		List<EmpVO> sList = list.stream()
								.filter(e->e.getSal()>=3000)
								.toList();
		//System.out.println("연봉이 3000이상: "+sList);
		sList.forEach(vo->System.out.println(vo.getEmpno()+" "
											+vo.getEname()+" "
											+vo.getSal()+" "
											+vo.getJob()+" "
											+vo.getDbday()));
		System.out.println("====================");
		
		// sort사용
		List<EmpVO> mList = list.stream()
								.sorted(Comparator.comparing(EmpVO::getSal).reversed())
								.toList();
		mList.forEach(vo->System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+vo.getSal()+" "
				+vo.getJob()+" "
				+vo.getDbday()));
		System.out.println("====================");
		
		List<String> kList = List.of("java", "spring", "html", "css", "javascript", "java", "css", "html", "vuejs");
		kList.stream()
			 .sorted((a, b)->a.length()-b.length())
			 .forEach(System.out::println);
		System.out.println("====================");
		
		kList.stream()
			 .sorted((a, b)->a.length()-b.length())
			 .distinct()
			 .forEach(System.out::println);
		System.out.println("====================");
		
		int total = list.stream()
						.map(EmpVO::getSal)
						.reduce(0, Integer::sum);
		System.out.println(total);
		System.out.println("====================");
		
		double avg = list.stream()
						 .mapToInt(EmpVO::getSal)
						 .average()
						 .orElse(0);
		System.out.println(avg);
		System.out.println("====================");
		
		// distinct : 중복 제거
		// reduce : 총합
		// average : 평균
		// sorted : 정렬
		// groupingBy
		// filter
		// map
		Map<String, List<EmpVO>> user = list.stream()
											.collect(Collectors.groupingBy(EmpVO::getJob));
//		System.out.println(user);
//		List<EmpVO> oList = user.get("ANALYST");
//		for(EmpVO vo : oList) {
//			System.out.println(vo.getEmpno()+" "
//							+vo.getEname()+" "
//							+vo.getJob());
//		}
		Set<String> keys = user.keySet();
//		user.keySet().stream().forEach(System.out::println);
		
		for(String key : keys) {
			List<EmpVO> oList = user.get(key);
			for(EmpVO vo : oList) {
				System.out.println(vo.getEmpno()+" "
								+vo.getEname()+" "
								+vo.getJob());
			}
			System.out.println("====================");
		}
	}
}
