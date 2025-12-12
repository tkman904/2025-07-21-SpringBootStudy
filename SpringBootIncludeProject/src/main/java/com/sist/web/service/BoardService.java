package com.sist.web.service;

import java.util.List;

import com.sist.web.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(int start);
	public int boardTotalPage();
}
