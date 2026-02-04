package com.sist.web.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sist.web.entity.RecipeDetailEntity;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.vo.RecipeListVO;

import java.util.*;
public interface RecipeRepository extends JpaRepository<RecipeEntity, Integer> {
	// public List<RecipeListVO> findAll(Pageable pg);
	// count / delete / save(insert) / save(update)
	/*@Override
	default Page<RecipeEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}*/
}