package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface EmpMapper {
	/*
      <select id="empListData" resultType="com.sist.web.vo.EmpVO">
	    SELECT empno, ename, job, TO_CHAR(hiredate, 'YYYY-MM-DD') AS dbday, sal
	    FROM emp
	    ORDER BY empno ASC
	  </select>
	 */
	public List<EmpVO> empListData();
}
