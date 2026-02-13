package com.sist.web.controller;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ChatController {
	private final ChatModel chatModel;
	
	@GetMapping("/ai/generate")
	public Map<String, String> generate(@RequestParam(value = "message", defaultValue = "점심 메뉴") String message) {
		
		return Map.of("generate", this.chatModel.call(message));
	}
}
