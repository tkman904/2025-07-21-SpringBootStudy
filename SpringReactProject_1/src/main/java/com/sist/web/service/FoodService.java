package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.FoodListVO;

public interface FoodService {
	public List<FoodListVO> foodListData(int start);
	public int foodTotalPage();
}