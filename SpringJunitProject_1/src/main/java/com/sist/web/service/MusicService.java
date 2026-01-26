package com.sist.web.service;

import java.util.*;

import com.sist.web.vo.*;

public interface MusicService {
	public List<MusicVO> musicListData(int start);
	public int musicTotalPage();
	public String musicGetTitle(int no);
}
