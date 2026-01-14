package com.sist.main;
/*
 *   람다식
 *     1. 람다식 = 익명의 함수
 *     2. 메소드를 값처럼 전달 => 매개변수
 *     3. 코드 간결하다
 *     -----------------
 *   기본 문법
 *     1. (매개변수) -> {실행문}
 *     타입생략 (int a) -> (a)
 *     매개변수 1개 (a)-> a
 *               (a, b)-> a+b   (a, b) -> {a+b}
 *     2. 메소드가 한개를 가지고 있는 경우 사용이 가능
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
//			Runnable r = new Runnable() {
//				
//				@Override
//				public void run() {
//					System.out.println("쓰레드 실행!!");
//				}
//			};
			Runnable r = ()->System.out.println("쓰레드 실행2 !!");
			new Thread(r).start();
		} catch(Exception ex) {}
	}

}
