package com.sist.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.FoodDTO;
import com.sist.web.entity.FoodEntity;

public interface FoodRepository extends JpaRepository<FoodEntity, Integer> {
	@Query(value = "SELECT fno,name as title,poster " + "FROM menupan_food " + "ORDER BY fno ASC "
			+ "OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY", nativeQuery = true) // JPQL로 변경 => 오류를 발생
	// JPQL을 사용하려면 => Entity명을 => 테이블명과 동일
	public List<FoodDTO> foodListData(@Param("start") int start);
	// count()

	public FoodEntity findByFno(int fno);
}