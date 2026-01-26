package com.sist.web.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.lang.Math.random;

@SpringBootTest
public class MemberServiceTest {
	@Autowired
	MemberService mService;
	
	@Test
	void helloTest() {
		int a = (int)((random()*10)+1);
		System.out.println(a);
		String result = mService.hello("홍길동");
		assertEquals("Hello 홍길동", result);
	}
}