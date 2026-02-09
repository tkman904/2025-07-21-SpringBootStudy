package com.sist.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.*;

public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {
	// Page<RecipeEntity> findAll(Pageable pg)
	// RecipeEntity findByNo(int no)
	// long count

}