package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface EmpMapper {
	@Select("SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'YYYY-MM-DD') AS dbday "
			+ "FROM emp ORDER BY empno ASC")
	public List<EmpVO> empListData();
	// JOIN / SubQuery / 동적쿼리이용 => XML
}
