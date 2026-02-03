package com.sist.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

/*
    NO                NUMBER         
	CONTENTID         NUMBER         
	EVENTSTARTDATE    VARCHAR2(1024) 
	EVENTENDDATE      VARCHAR2(1024) 
	AGELIMIT          VARCHAR2(1024) 
	PLAYTIME          VARCHAR2(1024) 
	EVENTPLACE        VARCHAR2(1024) 
	EVENTHOMEPAGE     VARCHAR2(1024) 
	USETIME           VARCHAR2(1024) 
	SPENDTIME         VARCHAR2(1024) 
	MSG               CLOB
 */

@Entity(name = "festival")
@Data
public class Festival {
	@Id
	private int no;
	
//	private int contentid;
	private String eventstartdate, eventenddate, agelimit, playtime, eventplace, eventhomepage, usetime, spendtime, msg;
	
	@ManyToOne
	@JoinColumn(name = "contentid")
	private SeoulTravel SeoulTravel;
}
