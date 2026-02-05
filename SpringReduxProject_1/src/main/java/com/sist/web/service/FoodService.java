package com.sist.web.service;

import java.util.*;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

public interface FoodService {
	// 리스트
	public List<FoodDTO> foodListData(int start);
	
	// 총 페이지
	public int foodTotalPage();
	
	// 상세보기
	public FoodEntity findByFno(int fno);
}
