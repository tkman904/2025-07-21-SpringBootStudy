package com.sist.web.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// @RestController는 처리 할 수 없다
@ControllerAdvice
public class ControllerException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("====== Controller에서 예외 발생 ======");
		ex.printStackTrace();
		System.out.println("==================================");
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable ex) {
		System.out.println("====== Controller에서 에러 발생 ======");
		ex.printStackTrace();
		System.out.println("==================================");
	}
}
