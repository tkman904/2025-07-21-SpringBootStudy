package com.sist.web.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
	private final FoodRepository foodRepo;

	@Override
	public List<FoodDTO> foodListData(int start) {
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
