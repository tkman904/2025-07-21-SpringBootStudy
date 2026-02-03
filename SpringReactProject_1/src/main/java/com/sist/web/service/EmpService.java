package com.sist.web.service;

import java.util.*;

import com.sist.web.entity.*;
import com.sist.web.vo.*;

public interface EmpService {
	public List<Emp> findByDeptDeptno();
	public List<EmpDeptVO> findEmpDeptVO();
}
