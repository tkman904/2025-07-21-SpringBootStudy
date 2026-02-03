package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;

import com.sist.web.service.*;
import com.sist.web.entity.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class EmpController {
	private final EmpService eService;

	@GetMapping("/emp/list")
	public String emp_list(Model model) {
		List<Emp> list = eService.findByDeptDeptno();

		model.addAttribute("list", list);

		return "emp/list";
	}
	
	@GetMapping("/emp/list2")
	public String emp_list2(Model model) {
		List<EmpDeptVO> list = eService.findEmpDeptVO();
		
		model.addAttribute("list", list);
		
		return "emp/list2";
	}
}