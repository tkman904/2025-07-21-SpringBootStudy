package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.RecipeDetailEntity;

public interface RecipeDetailRepository extends JpaRepository<RecipeDetailEntity, Integer> {
	public RecipeDetailEntity findByNo(int no);
}
