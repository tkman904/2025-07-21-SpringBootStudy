package com.sist.web.service;

import org.springframework.stereotype.Service;

import java.util.*;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

/*
 *   VO => Mapper(SQL) => Service => Controller 
 *                           |           |
 *                        ServiceImpl    |
 *                                   Vue로 값을 전송
 *                                   | 목록 = Map
 *                                   | 상세보기 = VO
 */

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService {
	private final RecipeMapper mapper;

	@Override
	public List<RecipeVO> recipeListData(int start) {
		// TODO Auto-generated method stub
		return mapper.recipeListData(start);
	}

	@Override
	public int recipeTotalPage() {
		// TODO Auto-generated method stub
		return mapper.recipeTotalPage();
	}

	@Override
	public RecipeDetailVO recipeDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.recipeHitIncrement(no);
		return mapper.recipeDetailData(no);
	}
}
