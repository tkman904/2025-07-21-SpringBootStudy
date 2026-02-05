package com.sist.web.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.web.entity.RecipeDetailEntity;
import com.sist.web.entity.RecipeEntity;
import com.sist.web.repository.RecipeDetailRepository;
import com.sist.web.repository.RecipeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeSerivceImpl implements RecipeService {
	private final RecipeRepository recipeRepo;
	private final RecipeDetailRepository detailRepo;

	@Override
	public Page<RecipeEntity> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return recipeRepo.findAll(pageable);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(recipeRepo.count()/12.0));
	}

	@Override
	public RecipeDetailEntity findByNo(int no) {
		// TODO Auto-generated method stub
		return detailRepo.findByNo(no);
	}
}
