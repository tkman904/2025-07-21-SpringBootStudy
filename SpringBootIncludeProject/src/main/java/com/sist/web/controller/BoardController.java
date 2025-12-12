package com.sist.web.controller;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sist.web.vo.*;
import com.sist.web.service.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService bService;
	/*
	 *   Spring 5.xx
	 *   	=> 보안 (HttpServletRequest => 사용하지 않는다 (권장))
	 *   			| 요청값, 결과값 전송
	 *   				|		|
	 *   			  매개변수   Model => 전송 객체
	 *   Spring 6.xx : 도메인 방식
	 *   ----------------------
	 *   				| MVC단점 : DispatcherServlet이 한개
	 *   								| 집중이 된다
	 *   								| 분산해서 사용 => MSA
	 *   Spring 7 => web 3.0 => 블록체인
	 *   			| 스타벅스 : 오딧세이
	 */
	@GetMapping("/board/list")
	public String board_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page == null) {
			page = "1";
		}
		
		int curpage = Integer.parseInt(page);
		List<BoardVO> list = bService.boardListData((curpage*10)-10);
		int totalpage = bService.boardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		model.addAttribute("main_html", "board/list");
		
		return "main/main";
	}
}
