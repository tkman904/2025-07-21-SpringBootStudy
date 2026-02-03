package com.sist.web.vo;
// column에서 일부만 가지고 오는 방법 => SQL문장이 있는 경우 
public interface RecipeListVO {
	public int getNo();
	public String getTitle();
	public String getChef();
	public String getPoster();
}