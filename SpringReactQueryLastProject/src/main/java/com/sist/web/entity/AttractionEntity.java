package com.sist.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "attraction")
@Data
public class AttractionEntity {
	private int no;
	
	@Id
	@Column(name = "contentid")
	private int contentid;
	
	private String infocenter, restdate, usetime, parking;
	
	@Lob
	@Column(name = "msg")
	private String msg;
}
