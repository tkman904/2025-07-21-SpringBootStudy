package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;

public interface DataBoardService {
	public List<DataBoardVO> databoardListData(int start);
	public int databoardTotalPage();
	public void databoardInsert(DataBoardVO vo);
	public DataBoardVO databoardDetailData(int no);
	public String databoardDelete(int no, String pwd);
	public DataBoardVO databoardFileInfo(int no);
}
