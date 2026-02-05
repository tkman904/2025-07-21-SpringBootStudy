package com.sist.web.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
	@Query(value = 
			"""
			SELECT fno, poster, name
			FROM menupan_food
			ORDER BY fno ASC
			OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY
			""", nativeQuery = true)
	public List<FoodDTO> foodListData(@Param("start") int start);
	
	// 상세보기
	public FoodEntity findByFno(int fno);
	/*
	 * 	1. ***일반 SQL ==> nativeQuery
	 *  2. JPQL => 객체(Entity)를 이용하는 방식
	 *     - Java Persistence Query Language
	 *     - JPQL => SQL문장이 아니다
	 *       => 테이블 조회하는 언어가 아니다 => 엔티티 객체를 이용한 조회 방식
	 *       => Emp
	 *          SELECT e
	 *          FROM Emp e
	 *               --- 테이블 X => 객체명 ==> 반드시 별칭을 이용한다
	 *          SELECT e
	 *          FROM Emp e
	 *          WHERE e.empno = 7788
	 *          
	 *          SELECT e
	 *          FROM Emp e
	 *          WHERE e.empno=:empno => (@Param("empno") int empno)
	 *          => WHERE e.empno=?1
	 *          
	 *       => SELECT e, d
	 *          FROM Emp e
	 *          JOIN Dept d
	 *          ON e.deptn = d.deptno
	 *       
	 *       => 집계함수
	 *          SELECT COUNT(e)
	 *          FROM Emp e
	 *          => SUM / AVG / MAX / MIN
	 *       => ORDER BY
	 *          SELECT e
	 *          FROM Emp e
	 *          ORDER BY e.empno ASC
	 *                   e.sal DESC
	 *       
	 *       => SELECT new com.sist.web.vo.FoodDTO(
	 *       		f.fno,
	 *       		f.name,
	 *       		f.poster
	 *          )
	 *          FROM FoodEntity f
	 *          
	 *  3. ***메소드 규칙
	 *     => 메소드명 = Query => 자동으로 SQL생성 : Spring AI => SQL을 자동 생성
	 *     => [리턴형] findBy[조건][연산자][정렬]
	 *        예) findByName(String name)
	 *            WHERE name = 매개변수
	 *            findByNameContaining(String name)
	 *                      ----------
	 *            WHERE name LIKE '%값%'
	 *            findByNameStartsWith(String name)
	 *            WHERE name LIKE '값%'
	 *     => findBy ==> 일반화
	 *        getBy
	 *        readBy
	 *        queryBy
	 *        --------------- 조회 (SELECT) => WHERE
	 *        existsBy : 존재여부 ==> SubQuery
	 *        countBy : 몇개
	 *     
	 *     => WHERE 조건
	 *        =         Is, Equals  ==> 생략 findByName
	 *        
	 *        !=        Not         ==> findByNameNot
	 *        
	 *        >         GreaterThan ==> findByHitGreaterThan(int hit)
	 *        
	 *        <         LessThan
	 *        
	 *        BETWEEN   Between     ==> 매개변수 2개
	 *                  findBySalBetween(int a, int b)
	 *        
	 *        IN        In
	 *        
	 *        LIKE      => Containing
	 *                  => StartsWith / EndsWith
	 *        
	 *        NULL      => findByPosterIsNull()
	 *                     findByPosterIsNotNull()
	 *        
	 *        OR / AND  => findByEmpnoOrSal(int empno, int sal)
	 *        			   findByEmpnoANDSal(int empno, int sal)
	 *        
	 *        ORDER BY  => findBySalOrderBySalDESC()
	 *                     findBySalOrderBySalASC()
	 *        
	 *        DISTINCT  => findDistinctByDeptno
	 *        
	 *        DELETE    => deleteByEmpno(int empno)
	 *        ------------------------------------------------------- 7:3 => mybatis / jpa
	 * 
	 * 		  JOIN => 설정
	 * 
	 *        ------------------------------------------------------- 
	 *        
	 *        1. Spring-Boot / SpringFramework / NodeJS
	 *        2. Oracle / MySql / MariaDB
	 *        3. VueJS / ReactJS / TypeScript
	 *             |       |
	 *           NustJS  NextJS
	 *           Pinia   TanstackQuery
	 *        4. AWS / Docker => DevsOps
	 *        5. Spring-AI
	 */
}
