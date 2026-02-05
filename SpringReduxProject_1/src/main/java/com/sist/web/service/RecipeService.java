package com.sist.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sist.web.entity.*;

public interface RecipeService {
	public Page<RecipeEntity> findAll(Pageable pageable);
	public int recipeTotalPage();
	public RecipeDetailEntity findByNo(int no);
}
