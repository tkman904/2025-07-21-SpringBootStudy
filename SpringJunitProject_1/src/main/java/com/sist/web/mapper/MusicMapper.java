package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface MusicMapper {
	/*
     	<select id="musicListData" resultType="com.sist.web.vo.MusicVO">
			SELECT no, cno, title, singer, album, poster, state, idcrement 
			FROM genie_music
			ORDER BY no ASC
			LIMIT #{start}, 20
		</select>
	 */
	public List<MusicVO> musicListData(int start);
	// interface는 Only public
	
	/*
		<select id="musicTotalPage" resultType="int">
			SELECT CEIL(COUNT(*)/20.0) FROM genie_music
		</select>
	 */
	public int musicTotalPage();
	
	public String musicGetTitle(int no);
}
