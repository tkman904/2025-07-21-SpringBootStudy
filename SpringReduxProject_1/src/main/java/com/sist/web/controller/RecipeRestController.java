package com.sist.web.controller;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.*;
import com.sist.web.entity.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecipeRestController {
	private final RecipeService rService;
	
	@GetMapping("/recipe/list_react/{page}")
	public ResponseEntity<Map> recipe_list_react(@PathVariable("page") int page) {
		Map map = new HashMap();
		
		try {
			final int ROWSIZE = 12;
			// SELECT * FROM recipe
			// ORDER BY no ASC
			// OFFSET page - 1 ROWS FETCH NEXT ROWSIZE ROWS ONLY
			Pageable pg = PageRequest.of(page-1, ROWSIZE, Sort.by(Sort.Direction.ASC, "no"));
			Page<RecipeEntity> pList = rService.findAll(pg);
			List<RecipeEntity> list = new ArrayList<RecipeEntity>();
			if(pList != null && pList.hasContent()) {
				list = pList.getContent(); // Page => List변경
			}
			
			int totalpage = rService.recipeTotalPage();
			
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
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/recipe/detail_react/{no}")
	public ResponseEntity<Map> recipe_detail_react(@PathVariable("no") int no) {
		Map map = new HashMap();
		
		try {
			RecipeDetailEntity vo = rService.findByNo(no);
			List<String> tList = new ArrayList<String>();
			List<String> iList = new ArrayList<String>();
			
			String[] datas = vo.getFoodmake().split("\n");
			for(String data : datas) {
				StringTokenizer st = new StringTokenizer(data, "^");
				tList.add(st.nextToken());
				iList.add(st.nextToken());
			}
			
			map.put("vo", vo);
			map.put("tList", tList);
			map.put("iList", iList);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
