package com.sist.web.vo;

import lombok.Data;

/*
    NO int 
	CNO int 
	RANK int 
	TITLE text 
	SINGER text 
	ALBUM text 
	POSTER text 
	STATE text 
	IDCREMENT int 
	KEY text 
	HIT int 
	LIKECOUNT int
 */

@Data
public class MusicVO {
	private int no, cno, rank, idcrement, hit, likecount;
	private String title, singer, album, poster, state, key;
}
