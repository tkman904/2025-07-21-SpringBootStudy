package com.sist.web.service;

import java.util.*;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.web.vo.*;

public interface RecipeService {
	/*
	   	@Select("SELECT no, title, poster, chef "
				+ "FROM recipe "
				+ "WHERE no IN(SELECT no FROM recipe INTERSECT "
				+ "SELECT no FROM recipedetail) "
				+ "ORDER BY no ASC "
				+ "OFFSET #{start} ROWS FETCH NEXT 12 ROWS ONLY")
		public List<RecipeVO> recipeListData(int start);
	 */
	public List<RecipeVO> recipeListData(int start);
	
	/*
		@Select("SELECT CEIL(COUNT(*)/12.0) FROM recipe "
				+ "WHERE no IN(SELECT no FROM recipe INTERSECT "
				+ "SELECT no FROM recipedetail)")
		public int recipeTotalPage();
	 */
	public int recipeTotalPage();
	
	/*
	   	@Update("UPDATE recipe SET "
				+ "hit = hit+1 "
				+ "WHERE no = #{no}")
		public void recipeHitIncrement(int no);
		
		@Select("SELECT no, poster, title, chef, chef_poster, chef_profile, info1, info2, info3, content, foodmake "
				+ "FROM recipeDetail "
				+ "WHERE no = #{no}")
		public RecipeDetailVO recipeDetailData(int no);
	 */
	public RecipeDetailVO recipeDetailData(int no);
}
