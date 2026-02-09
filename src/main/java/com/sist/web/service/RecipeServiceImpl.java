package com.sist.web.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.web.entity.*;
import com.sist.web.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	private final RecipeRepository recipeRepo;

	@Override
	public Page<RecipeEntity> findAll(Pageable pg) {
		// TODO Auto-generated method stub
		return recipeRepo.findAll(pg);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return (int) (Math.ceil(recipeRepo.count() / 12.0));
	}

}