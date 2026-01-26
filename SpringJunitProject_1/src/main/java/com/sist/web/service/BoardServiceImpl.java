package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;
import com.sist.web.mapper.*;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;

	@Override
	public List<BoardVO> boardListData(int start) {
		// TODO Auto-generated method stub
		return mapper.boardListData(start);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return mapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}
}
