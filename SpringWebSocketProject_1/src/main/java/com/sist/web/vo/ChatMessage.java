package com.sist.web.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 매개변수가 있는 생성자
@NoArgsConstructor // 매개변수가 없는 생성자
public class ChatMessage {
	private String sender; // 보낸 사람
	private String message; // 메세지 내용
	private String time; // 시간
}
