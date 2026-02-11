package com.sist.web.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sist.web.dto.*;
import com.sist.web.entity.*;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
	@Query(value = "SELECT no, cno, id, name, msg, TO_CHAR(regdate, 'YYYY-MM-DD HH24:MI:SS') AS dbday "
			+ "FROM comment_1 "
			+ "WHERE cno = :contentid "
			+ "ORDER BY no DESC", nativeQuery = true)
	public List<CommentDTO> commentListData(@Param("contentid") int contentid);
	
	@Query(value = "SELECT NVL(MAX(no)+1, 1) FROM comment_1", nativeQuery = true)
	public int maxNo();
	
	public CommentEntity findByNo(int no); // update
}
