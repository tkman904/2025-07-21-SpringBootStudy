package com.sist.web.mapper;

import java.util.*;

import com.sist.web.vo.*;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

// XML = Mapper => Service

@Mapper
@Repository
public interface FoodMapper {
	/*
      <select id="foodListData" resultType="com.sist.web.vo.FoodVO" parameterType="hashmap">
	    SELECT fno, name, poster, num
	    FROM (SELECT fno, name, poster, ROWNUM AS num 
	    FROM (SELECT fno, name, poster
	    FROM menupan_food ORDER BY fno ASC))
	    WHERE num BETWEEN #{start} AND #{end}
	  </select>
	  
	  <select id="foodTotalPage" resultType="int">
	    SELECT CEIL(COUNT(*)/12.0) FROM menupan_food
	  </select>
	 */
	public List<FoodVO> foodListData(Map map);
	public int foodTotalPage();
	
	/*
      <update id="foodHitIncrement" parameterType="int">
	    UPDATE menupan_food SET
	    hit = hit+1
	    WHERE fno = #{fno}
	  </update>
	  
	  <select id="foodDetailData" resultType="com.sist.web.vo.FoodVO" parameterType="int">
	    SELECT fno, name, poster, time, address, phone, theme, parking, score, content, price, type
	    FROM menupan_food
	    WHERE fno = #{fno}
	  </select>
	 */
	public void foodHitIncrement(int fno);
	public FoodVO foodDetailData(int fno);
	
	/*
      <select id="foodTop10" resultType="com.sist.web.vo.FoodVO">
	    SELECT fno, poster, name, address, phone, ROWNUM
	    FROM (SELECT fno, poster, name, address, phone
	    FROM menupan_food ORDER BY hit DESC)
	    WHERE ROWNUM&lt;=10
	  </select>
	 */
	public List<FoodVO> foodTop10();
}
