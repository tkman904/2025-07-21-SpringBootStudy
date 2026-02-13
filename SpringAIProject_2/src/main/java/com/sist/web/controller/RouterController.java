package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {
	@GetMapping("/ai")
	public String ai_page() {
		return "ai";
	}
}
