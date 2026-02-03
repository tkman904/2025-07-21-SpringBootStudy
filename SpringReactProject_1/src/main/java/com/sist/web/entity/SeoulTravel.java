package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

/*
    NO          NOT NULL NUMBER         
	TITLE                VARCHAR2(1024) 
	IMAGE1               VARCHAR2(1024) 
	IMAGE2               VARCHAR2(1024) 
	X                    NUMBER(20,12)  
	Y                    NUMBER(20,12)  
	CONTENTID            NUMBER         
	ADDRESS              VARCHAR2(300)  
	CONTENTTYPE          NUMBER(2)      
	HIT                  NUMBER
 */

@Entity(name = "seoultravel")
@Data
public class SeoulTravel {
	@Id
	private int no;
	
	private int contentid, contenttype, hit;
	private String title, image1, image2, address;
	private double x, y;
}
