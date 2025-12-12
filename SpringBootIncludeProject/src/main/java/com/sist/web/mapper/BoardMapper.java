package com.sist.web.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface BoardMapper {
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') AS dbday, hit "
			+ "FROM springboard "
			+ "ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	public List<BoardVO> boardListData(int start);
	
	@Select("SELECT CEIL(COUNT(*)/10.0) FROM springboard")
	public int boardTotalPage();
	
	// 상세보기 => @GetMapping
	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'YYYY-MM-DD') AS dbday, content, hit "
			+ "FROM springboard "
			+ "WHERE no = #{no}")
	public BoardVO boardDetail(int no);
	
	@Update("UPDATE springboard SET "
			+ "hit = hit+1 "
			+ "WHERE no = #{no}")
	public void hitIncrement(int no);
	
	// 글쓰기 => @PostMapping
	@Insert("INSERT INTO springboard "
			+ "VALUES(sb_no_seq.nextval, #{name}, #{subject}, #{content}, #{pwd}, SYSDATE, 0)")
	public void boardInsert(BoardVO vo);
	
	// 수정 => @PutMapping
	// 삭제 => @DeleteMapping
	// -------------------------- RestFul
	// 게시판 / 댓글
}
