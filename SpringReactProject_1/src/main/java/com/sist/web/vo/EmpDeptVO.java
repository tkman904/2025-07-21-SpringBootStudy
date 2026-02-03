package com.sist.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 데이터수정(X) => readonly => 데이터값 읽기, Spring AI
// getter만 존재
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDeptVO {
	private int empno;
	private int sal;
	private String ename;
	private String job;
	private String dname;
	private String loc;
}