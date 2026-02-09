package com.sist.web.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sist.web.dto.FoodDTO;
import com.sist.web.entity.FoodEntity;

public interface FoodService {
	// @Query => 사용자 정의 => 메소드명도 자유
	public List<FoodDTO> foodListData(@Param("start") int start);

	public int foodTotalPage();

	// JPA 규칙에 맞게
	public FoodEntity findByFno(int fno);
}