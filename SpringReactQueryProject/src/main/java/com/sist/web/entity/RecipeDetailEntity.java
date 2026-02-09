package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/*
    NO              NUMBER         
	POSTER          VARCHAR2(500)  
	TITLE           VARCHAR2(1000) 
	CHEF            VARCHAR2(300)  
	CHEF_POSTER     VARCHAR2(500)  
	CHEF_PROFILE    VARCHAR2(500)  
	INFO1           VARCHAR2(100)  
	INFO2           VARCHAR2(100)  
	INFO3           VARCHAR2(100)  
	CONTENT         CLOB           
	FOODMAKE        CLOB      
 */
@Entity
@Table(name = "recipedetail")
@Data
public class RecipeDetailEntity {
	@Id
	private int no;

	private String poster, title, chef, chef_poster, chef_profile, info1, info2, info3, content, foodmake;

}