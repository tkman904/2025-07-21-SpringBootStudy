package com.sist.web.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleChatController {
	private final ChatClient chatClient;
	
	public SimpleChatController(ChatClient.Builder chatBuilder) {
		this.chatClient = chatBuilder.build();
	}
	
	@GetMapping("/ai2")
	public String ai2_page(@RequestParam(value = "message", defaultValue = "뒷골 땡겨") String message) {
		
		return chatClient.prompt(message).options(ChatOptions.builder().temperature(1.0).build()).call().content();
	}
}
