package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RecipeRestController {
	private final RecipeService rService;
	
	@GetMapping("/recipe/list_vue/")
	public ResponseEntity<Map> recipe_list_vue(@RequestParam(name = "page", required = false) int page) {
		Map map = new HashMap();
		try {
			int start = (page-1)*12;
			List<RecipeVO> list = rService.recipeListData(start);
			int totalpage = rService.recipeTotalPage();
			
			final int BLOCK = 10;
			int startPage = ((page-1)/BLOCK*BLOCK)+1;
			int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
			if(endPage>totalpage) {
				endPage = totalpage;
			}
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
			// 500에러에 대한 에러내용 전송
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/recipe/detail_vue/")
	public ResponseEntity<RecipeDetailVO> recipe_detail(@RequestParam("no") int no) {
		RecipeDetailVO vo = new RecipeDetailVO();
		try {
			vo = rService.recipeDetailData(no);
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
}
