package com.sist.web.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService bService;
	
	@GetMapping("/board/list")
	public String board_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page == null) {
			page = "1";
		}
		
		int curpage = Integer.parseInt(page);
		List<BoardVO> list = bService.boardListData((curpage-1)*10);
		int totalpage = bService.boardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "board/list";
	}
	
	@GetMapping("/board/insert")
	public String board_insert() {
		return "board/insert";
	}
	
	@PostMapping("/board/insert_ok")
	public String board_insert_ok(@ModelAttribute BoardVO vo) {
		bService.boardInsert(vo);
		
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/detail")
	public String board_detail(@RequestParam("no") int no, Model model) {
		BoardVO vo = bService.boardDetailData(no);

		model.addAttribute("vo", vo);
		
		return "board/detail";
	}
}
