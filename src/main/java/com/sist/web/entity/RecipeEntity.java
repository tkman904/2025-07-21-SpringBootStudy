package com.sist.web.entity;
// column = proerty가 일치 

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
 *   NO         NOT NULL NUMBER(38)     
TITLE               VARCHAR2(4000) 
POSTER              VARCHAR2(4000) 
CHEF                VARCHAR2(4000) 
LINK                VARCHAR2(26)   
HIT                 NUMBER(38)     
LIKECOUNT           NUMBER(38)     
JJIMCOUNT           NUMBER(38)     
REPLYCOUNT          NUMBER(38)    
 */
@Entity(name = "recipe2") // class Recipe2
@Data
public class RecipeEntity {
	@Id
	private int no;
	
	private int hit, likecount, jjimcount, replycount;
	private String title, poster, chef, link;
}