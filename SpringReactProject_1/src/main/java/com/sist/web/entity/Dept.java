package com.sist.web.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

/*
 *  JPA / React / 일반 SQL => NodeJS 
 * 	1. JPA 메소드 규칙
 *  2. JPQL => SQL문장이 아니다 객체 처리
 *  3. JOIN
 *  4. 서브쿼리 => 일부만 지원
 *     inlineview는 지원하지 않는다
 */
@Entity
@Table(name = "dept")
@Data
public class Dept {
	@Id
	private int deptno;
	
	private String dname;
	private String loc;
	
	@OneToMany(mappedBy = "dept")
	private List<Emp> empList = new ArrayList<>();
}
