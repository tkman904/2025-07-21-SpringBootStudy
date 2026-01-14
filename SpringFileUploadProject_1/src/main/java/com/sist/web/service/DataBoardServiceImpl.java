package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
import com.sist.web.vo.DataBoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataBoardServiceImpl implements DataBoardService{
	private final DataBoardMapper mapper;

	@Override
	public List<DataBoardVO> databoardListData(int start) {
		// TODO Auto-generated method stub
		return mapper.databoardListData(start);
	}

	@Override
	public int databoardTotalPage() {
		// TODO Auto-generated method stub
		return mapper.databoardTotalPage();
	}

	@Override
	public void databoardInsert(DataBoardVO vo) {
		// TODO Auto-generated method stub
		mapper.databoardInsert(vo);
	}

	@Override
	public DataBoardVO databoardDetailData(int no) {
		// TODO Auto-generated method stub
		mapper.hitIncrement(no);
		return mapper.databoardDetailData(no);
	}

	@Override
	public String databoardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		String res = "no";
		String db_pwd = mapper.databoardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			res = "yes";
			mapper.databoardDelete(no);
		}
		
		return res;
	}

	@Override
	public DataBoardVO databoardFileInfo(int no) {
		// TODO Auto-generated method stub
		return mapper.databoardFileInfo(no);
	}
}
