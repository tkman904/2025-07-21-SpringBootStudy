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

import lombok.RequiredArgsConstructor;

import com.sist.web.entity.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class RecipeRestController {
	private final RecipeService rService;

	@GetMapping("/recipe/list_react/{page}")
	public ResponseEntity<Map> recipe_list(@PathVariable("page") int page) {
		Map map = new HashMap();

		try {
			final int ROWSIZE = 12;
			// OFFSET :start ROWS FETCH NEXT 12 ROWS ONLY
			Pageable pg = PageRequest.of(page - 1, ROWSIZE, Sort.by(Sort.Direction.ASC, "no"));
			// ORDER BY no ASC
			Page<RecipeEntity> pList = rService.findAll(pg);
			List<RecipeEntity> list = new ArrayList<RecipeEntity>();
			if (pList != null && pList.hasContent()) {
				list = pList.getContent(); // Page => List변경
			}
			int totalpage = rService.recipeTotalPage();

			final int BLOCK = 10;
			int startPage = ((page - 1) / BLOCK * BLOCK) + 1;
			int endPage = ((page - 1) / BLOCK * BLOCK) + BLOCK;

			if (endPage > totalpage) {
				endPage = totalpage;
			}

			// Map에 묶어서 React 전송
			map.put("list", list);
			map.put("totalpage", totalpage);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("curpage", page);
		} catch (Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}