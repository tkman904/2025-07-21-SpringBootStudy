package com.sist.web.service;

import java.util.*;

import com.sist.web.dto.*;
import com.sist.web.entity.*;

public interface CommentService {
	public List<CommentDTO> commentListData(int contentid);
	public List<CommentDTO> commentInsert(CommentEntity vo);
	public List<CommentDTO> commentUpdate(int no, String msg);
	public List<CommentDTO> commentDelete(int no, int cno);
}
