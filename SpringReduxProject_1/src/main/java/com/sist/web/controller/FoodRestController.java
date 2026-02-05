package com.sist.web.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.sist.web.service.*;
import com.sist.web.vo.*;
import com.sist.web.entity.*;

@RestController // 자동으로 JSON변경 => Jackson
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class FoodRestController {
	private final FoodService fService;
	
	// /food/list_react/1
	@GetMapping("/food/list_react/{page}")
	public ResponseEntity<Map> food_list(@PathVariable("page") int page) {
		Map map = new HashMap();
		
		try {
			List<FoodDTO> list = fService.foodListData((page-1)*12);
			
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
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	// 상세보기
	@GetMapping("/food/detail_react/{fno}")
	public ResponseEntity<FoodEntity> food_detail_react(@PathVariable("fno") int fno) {
		FoodEntity vo = new FoodEntity();
		
		try {
			vo = fService.findByFno(fno);
		} catch (Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
}
