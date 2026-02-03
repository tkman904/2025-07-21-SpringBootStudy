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

}