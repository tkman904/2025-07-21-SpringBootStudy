package com.sist.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.*;

import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BoardRestController {
	private final BoardService bService;
	
	@GetMapping("/board/list_react/{page}")
	public ResponseEntity<Map> board_list_react(@PathVariable("page") int page) {
		Map map = new HashMap();
		
		try {
			List<BoardDTO> list = bService.boardListData((page-1)*10);
			int totalpage = bService.boardTotalPage();
			
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PostMapping("/board/insert_react")
	public ResponseEntity<String> board_insert_react(@RequestBody BoardEntity vo) {
		String result = "";
		
		try {
			bService.boardInsert(vo);
			result = "yes";
		} catch(Exception ex) {
			result = "no";
			ex.printStackTrace();
			return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("/board/detail_react/{no}")
	public ResponseEntity<BoardEntity> board_detail_react(@PathVariable("no") int no) {
		BoardEntity vo = new BoardEntity();
		
		try {
			vo = bService.findByNo(no);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@GetMapping("/board/update_react/{no}")
	public ResponseEntity<BoardEntity> board_update_react(@PathVariable("no") int no) {
		BoardEntity vo = new BoardEntity();
		try {
			vo = bService.boardUpdateData(no);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(vo, HttpStatus.OK);
	}
	
	@PutMapping("/board/update_react_ok")
	public ResponseEntity<String> board_update_ok(@RequestBody BoardEntity vo) {
		String res = "";
		
		try {
			res = bService.boardUpdateOk(vo);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
	
	@DeleteMapping("/board/delete_react/{no}/{pwd}")
	public ResponseEntity<String> board_delete(@PathVariable("no") int no, @PathVariable("pwd") String pwd) {
		String res = "";
		
		try {
			res = bService.boardDelete(no, pwd);
		} catch(Exception ex) {
			ex.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
