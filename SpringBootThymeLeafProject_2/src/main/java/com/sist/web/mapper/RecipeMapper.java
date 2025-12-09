package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface RecipeMapper {
	/*
      <select id="recipeListData" resultType="com.sist.web.vo.RecipeVO" parameterType="hashmap">
	    SELECT no, title, chef, poster, num
	    FROM (SELECT no, title, chef, poster, ROWNUM AS num
	    FROM (SELECT no, title, chef, poster
	    FROM recipe
	    WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)
	    ORDER BY no ASC))
	    WHERE num BETWEEN #{start} AND #{end}
	  </select>
	 */
	public List<RecipeVO> recipeListData(Map map);
	
	/*
	  <select id="recipeTotalPage" resultType="int">
	    SELECT CEIL(COUNT(*)/12.0) FROM recipe
	    WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)
	  </select>
	 */
	public int recipeTotalPage();
	
	/*
	  <select id="recipeTop10" resultType="com.sist.web.vo.RecipeVO" parameterType="hashmap">
	    SELECT no, title, chef, poster, num
	    FROM (SELECT no, title, chef, poster, ROWNUM AS num
	    FROM (SELECT no, title, chef, poster
	    FROM recipe
	    WHERE no IN(SELECT no FROM recipe INTERSECT SELECT no FROM recipedetail)
	    ORDER BY hit DESC))
	    WHERE num&lt;=10
	  </select>
	 */
	public List<RecipeVO> recipeTop10(); // AOP
}
