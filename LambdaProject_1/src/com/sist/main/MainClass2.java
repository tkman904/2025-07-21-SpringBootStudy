package com.sist.main;
/*
 *   함수형 인터페이스
 *     1. 람다식은 함수형 인터페이스만 사용 가능
 *        => 조건 : 추상메소드(선언만 된 메소드 1개)
 *     2. 인터페이스 위에
 *        @FunctionalInterface => 람다 사용을 할 수 있는 인터페이스
 *         => 추상메소드가 1개
 *            구현이 안된 메소드
 *         => 구현된 메소드 : default / static
 */
@FunctionalInterface
interface Calc {
	// public abstract
	int sum(int a, int b);
	// 1.8이상
	
	//public
	default double div(int a, int b) {
		return a/b;
	}
	
	// public ==> 컴파일시 자동 추가 => interface : 변수/메소드가 public
	static void msg() {
		System.out.println("Hello");
	}
}
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스 생성 / 객체 생성 => 메모리 커짐 (속도가 느리다)
		//    X         O    => 메모리가 작다
//		Calc c = new Calc() {
//			
//			@Override
//			public int sum(int a, int b) {
//				// TODO Auto-generated method stub
//				return a+b;
//			}
//		};
		Calc c = (a, b)->a+b;
		System.out.println(c.sum(10, 20));
		System.out.println(c.div(10, 3));
		Calc.msg();
	}

}
