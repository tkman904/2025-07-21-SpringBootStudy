package com.sist.web.controller;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 리액트:3000 / Vue:8080 
public class FoodRestController {
	private final FoodService fService;

	@GetMapping("/food/list_react/{page}")
	public ResponseEntity<Map> food_list_react(@PathVariable("page") int page) {
		Map map = new HashMap();
		
		try
		{
			List<FoodListVO> list = fService.foodListData((page-1)*12);
			int totalpage = fService.foodTotalPage();

			final int BLOCK = 10;
			int startPage = ((page-1)/BLOCK*BLOCK)+1;
			int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;

			if(endPage > totalpage) {
				endPage = totalpage;
			}
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
		}catch(Exception ex) {
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}

}