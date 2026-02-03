package com.sist.web.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.sist.web.repository.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService {
	private final EmpRepository eRepo;

	@Override
	public List<Emp> findByDeptDeptno() {
		// TODO Auto-generated method stub
		return eRepo.findByDeptDeptno();
	}

	@Override
	public List<EmpDeptVO> findEmpDeptVO() {
		// TODO Auto-generated method stub
		return eRepo.findEmpDeptVO();
	}
}
