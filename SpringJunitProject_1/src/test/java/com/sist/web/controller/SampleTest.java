package com.sist.web.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
/*
 * 	JUnit 5
 *  Spring Test
 *  AssertJ
 *  
 *  assertEquals
 *  assertTrue
 *  assertNotNull
 */
public class SampleTest {
	@Test
	void testSum() {
		int result = 30;
		assertEquals(30, result);
	}
}
