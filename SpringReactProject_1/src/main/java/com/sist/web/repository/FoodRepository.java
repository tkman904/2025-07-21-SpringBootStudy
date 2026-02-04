package com.sist.web.repository;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sist.web.entity.FoodEntity;
import com.sist.web.vo.*;
@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
	@Query(value = "SELECT fno, name, poster "
			+"FROM menupan_food "
			+"ORDER BY fno ASC "
			+"OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY", nativeQuery = true)
	public List<FoodListVO> foodListData(@Param("start") int start);
	// findAll()
	// count()
	
	public FoodEntity findByFno(int fno);
	// SELECT * FROM menupan_food WHERE fno = 10
	// WHERE ORDER BY
	// count() save() delete()
	/*
	 * 	[리턴형] findBy[조건][연산자][정렬]
	 * 	findBy컬럼명(값) ===> 컬럼명 = 값
	 * 	findByAddressContaining ===> address LIKE '%값%'
	 *  
	 *  = Is, Equals
	 * 	!= Not
	 *  > GraterThan ===> findByHitGraterThan(int hit)
	 *  < LessThan
	 *  BETWEEN Between ===> findByFnoBetween(int a, int b)
	 *  IN In ===> findByAddressIn(List<String> addr)
	 *  LIKE Like
	 *    => %% Containing(변수)
	 *    => A% StartsWith
	 *    => %A EndsWith
	 *  findByCommIsNull()
	 *  findByCommIsNotNull()
	 *  
	 *  findByNameAndAddress()
	 *  
	 *  findByFnoOrderByASC
	 *  
	 *  중복없는 데이터
	 *  findDistinctByAddress
	 *      --------  -------
	 *      |		  | WHERE
	 *      | SELECT
	 */
}