package com.sist.web;

import java.util.Scanner;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.google.genai.GoogleGenAiChatModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringAiProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringAiProject1Application.class, args);
	}
	
	// LLM / LMM => Memory : 초기
	// web : Spring AI, 일반 : Python / C => 클래스를 추상화 => 라이브러리 연동
	// RAG => 핵심
	/*
	 *   생성형 AI
	 *      대규모 언어 모델 => 텍스트, 이미지 동영상
	 *      (LLM)
	 *       | => ChatGPT, Gemini, 엔트로픽
	 *       
	 *      동작
	 *            ChatModel
	 *       데이터   훈련   프롬프트
	 *         |     |      | 입력 ===> 새로운 내용 생성
	 *      => GPU => 자연어처리
	 *      => 글쓰기 (자기소개, 리포트 ...)
	 *      	=> 동영상 / 회의, 이미지, 코드
	 *      => 알고리즘을 이용해서 정보를 처리
	 *      
	 *      => call() => content()
	 *         call() => embed()
	 */
	
	@Bean
	public CommandLineRunner runner1(GoogleGenAiChatModel model) {
		System.out.println("ChatModel 생성: " + model);
		//Scanner scan = new Scanner(System.in);
		//System.out.print("검색어 입력");
		//String cmd = scan.next();
		
		return args-> {
			String response = model.call("굴포천역 인근 맛집 추천해줘. 혼밥하기 좋은곳이면 더 좋아");
			System.out.println("[결과]: " + response);
		};
	}
	
//	@Bean
//	public CommandLineRunner runner2(GoogleGenAiChatModel model) {
//		System.out.println("ChatModel 생성: " + model);
//		return args-> {
//			ChatResponse response = model.call(new Prompt("서울지역 여행 추천", ChatOptions.builder().model(null).build()));
//		};
//	}
}
