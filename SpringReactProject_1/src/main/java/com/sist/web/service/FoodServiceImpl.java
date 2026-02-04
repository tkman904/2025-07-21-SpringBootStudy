package com.sist.web.service;

import org.springframework.stereotype.Service;
import java.util.*;

import com.sist.web.entity.FoodEntity;
import com.sist.web.repository.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService{
	private final FoodRepository foodRepo;

	@Override
	public List<FoodListVO> foodListData(int start) {
		// TODO Auto-generated method stub
		return foodRepo.foodListData(start);
	}

	@Override
	public int foodTotalPage() {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(foodRepo.count()/12.0));
	}

	@Override
	public FoodEntity findByFno(int fno) {
		// TODO Auto-generated method stub
		return foodRepo.findByFno(fno);
	}
}