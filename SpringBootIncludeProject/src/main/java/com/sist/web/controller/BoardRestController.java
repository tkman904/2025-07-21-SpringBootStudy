package com.sist.web.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.vo.*;
import com.sist.web.service.*;

import lombok.RequiredArgsConstructor;
/*
 * 		1. @
 * 		2. @RequiredArgsConstructor
 * 			생성자에서 @Autowired
 * 		3. @CrossOrigin(origins = "*") : port가 다른 경우
 * 			port허용
 * 		4. @RequestParam => 한개의 요청값
 * 		   @ModelAttribute => VO단위로 값을 받는 경우
 * 		   @RequestBody => JSON으로 받는 경우 = 객체 변환
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardRestController {
	private final BoardService bService;
	
	@GetMapping("/board/list_vue/")
	public ResponseEntity<Map> board_list_vue(@RequestParam("page") int page) {
		Map map = new HashMap();
		try {
			List<BoardVO> list = bService.boardListData((page*10)-10);
			int totalpage = bService.boardTotalPage();
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/board/detail_vue/")
	public ResponseEntity<BoardVO> board_detail_vue(@RequestParam("no") int no) {
		BoardVO vo = new BoardVO();
		try {
			vo = bService.boardDetail(no);
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	// 글쓰기 vuex => pinia(개인 프로젝트)
	@PostMapping("/board/insert_vue/")
	public ResponseEntity<Map> board_insert_vue(@RequestBody BoardVO vo) {
		Map map = new HashMap();
		
		try {
			bService.boardInsert(vo);
			map.put("msg", "yes");
		} catch(Exception ex) {
			map.put("msg", "no");
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK); 
	}
	
	@PostMapping("/board/update_vue/")
	public ResponseEntity<Map> board_update_vue(@RequestBody BoardVO vo) {
		Map map = new HashMap();
		
		try {
			boolean bCheck = bService.boardUpdate(vo);
			if(bCheck == true) {
				map.put("msg", "yes");
			} else {
				map.put("msg", "no");
			}
		} catch(Exception ex) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
