package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface BoardMapper {
	public List<BoardVO> boardListData(int start);
	public int boardTotalPage();
	public void boardInsert(BoardVO vo);
	public void boardHitIncrement(int no);
	public BoardVO boardDetailData(int no);
}
