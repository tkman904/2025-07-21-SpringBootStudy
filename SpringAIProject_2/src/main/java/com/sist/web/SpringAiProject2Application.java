package com.sist.web;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiProject2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiProject2Application.class, args);
	}
	
	@Bean
	public CommandLineRunner runner(ChatModel model) {
		return args-> {
			String response = model.call("홍대 점심 메뉴");
//			System.out.println("-".repeat(100));
//			System.out.println("[결과]: " + response);
		};
	}
}
