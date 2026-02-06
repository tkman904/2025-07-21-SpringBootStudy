package com.sist.web.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.*;

import com.sist.web.entity.*;
import com.sist.web.repository.*;
import com.sist.web.vo.*;
/*
 *	JPA
 *	  1. Query => SQL, JPQL
 *    2. 메소드 규칙
 *    3. 자체 내장 => count / sum / save
 *                               ----- update / insert
 *                                     |        | no가 없는 경우
 *                                     | no가 있는 경우
 *    4. JOIN / SUBQUERY
 *    => 복잡한 SQL : MyBatis
 *    => 단순한 SQL : JPA
 *    ----------------------- +
 */

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardRepository bRepo;

	@Override
	public List<BoardDTO> boardListData(int start) {
		// TODO Auto-generated method stub
		return bRepo.boardListData(start);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return (int)(Math.ceil(bRepo.count()/10.0));
	}

	@Override
	public void boardInsert(BoardEntity vo) {
		// TODO Auto-generated method stub
		bRepo.save(vo);
	}

	@Override
	public BoardEntity findByNo(int no) {
		// TODO Auto-generated method stub
		BoardEntity vo = bRepo.findByNo(no);
		vo.setHit(vo.getHit()+1);
		bRepo.save(vo);
		vo = bRepo.findByNo(no);
		return vo;
	}

	@Override
	public BoardEntity boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return bRepo.findByNo(no);
	}

	@Override
	public String boardUpdateOk(BoardEntity vo) {
		// TODO Auto-generated method stub
		BoardEntity pvo = bRepo.findByNo(vo.getNo());
		String res = "no";
		if(pvo.getPwd().equals(vo.getPwd())) {
			res = "yes";
			bRepo.save(vo);
		}
		
		return res;
	}

	@Override
	public String boardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		BoardEntity pvo = bRepo.findByNo(no);
		String res = "no";
		if(pvo.getPwd().equals(pwd)) {
			res = "yes";
			bRepo.delete(pvo);
		}
		
		return res;
	}
}
