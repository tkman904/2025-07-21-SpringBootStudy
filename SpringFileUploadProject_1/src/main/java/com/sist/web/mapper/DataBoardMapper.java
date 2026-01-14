package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface DataBoardMapper {
	@Select("SELECT no, name, subject, TO_CHAR(regdate, 'YYYY-MM-DD') AS dbday, hit, filecount "
			+ "FROM springdataboard "
			+ "ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	public List<DataBoardVO> databoardListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springdataboard")
	public int databoardTotalPage();
	
	@SelectKey(keyProperty = "no", resultType = int.class, before = true, statement = "SELECT NVL(MAX(no)+1, 1) AS no FROM springdataboard")
	@Insert("INSERT INTO springdataboard "
			+ "VALUES(#{no}, #{name}, #{subject}, #{content}, #{pwd}, SYSDATE, 0, #{filename}, #{filesize}, #{filecount})")
	public void databoardInsert(DataBoardVO vo);
	
	// 상세보기, 다운로드
	@Update("UPDATE springdataboard SET "
			+ "hit = hit+1 "
			+ "WHERE no = #{no}")
	public void hitIncrement(int no);
	
	@Select("SELECT no, name, subject, content, hit, filename, filesize, filecount, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') AS dbday "
			+ "FROM springdataboard "
			+ "WHERE no = #{no}")
	public DataBoardVO databoardDetailData(int no);
	
	// 수정 =>
	// 삭제 => 파일 삭제
	@Select("SELECT pwd FROM springdataboard "
			+ "WHERE no = #{no}")
	public String databoardGetPassword(int no);
	
	@Delete("DELETE FROM springdataboard "
			+ "WHERE no = #{no}")
	public void databoardDelete(int no);
	
	@Select("SELECT filename, filesize, filecount "
			+ "FROM springdataboard "
			+ "WHERE no = #{no}")
	public DataBoardVO databoardFileInfo(int no);
}
