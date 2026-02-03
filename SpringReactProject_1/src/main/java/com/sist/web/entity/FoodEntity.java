package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/*
 *   JJIMCOUNT     NUMBER(38)     
     LIKECOUNT     NUMBER(38)     
     REPLYCOUNT    NUMBER(38) 
 */
// 테이블 연결 
@Entity(name = "menupan_food")
@Data
public class FoodEntity {
	@Id
	private int fno;

	private String name, type, phone, address, theme, price, time, parking, poster, images, content;
	private double score;
	private int hit, jjimcount, likecount, replycount;

}