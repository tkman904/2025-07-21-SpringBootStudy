package com.sist.web.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.vo.*;
import com.sist.web.mapper.*;

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
	public BoardVO boardDetail(int no) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(no);
		return mapper.boardDetail(no);
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		mapper.boardInsert(vo);
	}
}
