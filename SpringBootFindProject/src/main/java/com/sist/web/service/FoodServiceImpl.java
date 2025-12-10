package com.sist.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
/*
 *   Spring + XML
 *            ---
 *            => 불편 => 순수하게 자바로만 코딩
 *                      -----------------
 *                      | => Spring-Boot
 *            | Mybatis => XML/Annotation => 4.0 (Annotation)
 *   => XML : properties / yml
 *       | => Annotatation 
 */
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
	private final FoodMapper mapper;
	
//	@RequiredArgsConstructor
//	      ||
//	@Autowired
//	public FoodServiceImpl(FoodMapper mapper) {
//		this.mapper = mapper;
//	}
	
	@Override
	public List<FoodVO> foodListData(Map map) {
		// TODO Auto-generated method stub
		return mapper.foodListData(map);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int fno) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(fno);
		return mapper.foodDetailData(fno);
	}
}
