package com.sist.web.controller;

import java.io.*;
import java.util.*;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.sist.web.vo.*;

import jakarta.servlet.http.HttpServletRequest;

import com.sist.web.service.*;

@RestController
@RequiredArgsConstructor
public class DataBoardRestController {
	private final DataBoardService dService;
	
	@DeleteMapping("/databoard/delete_ok/")
	public String databoard_delete_ok(@RequestParam("no") int no, @RequestParam("pwd") String pwd, HttpServletRequest request) {
		DataBoardVO vo = dService.databoardFileInfo(no);
		String res = dService.databoardDelete(no, pwd);
		
		// DB처리
		// 파일 처리
		if(res.equals("yes")) {
			try {
				if(vo.getFilecount() != 0) {
					String delDir = request.getServletContext().getRealPath("/upload");
					StringTokenizer st = new StringTokenizer(vo.getFilename(), ",");
					while(st.hasMoreTokens()) {
						File file = new File(delDir + "/" + st.nextToken());
						file.delete();
					}
				}
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return res;
	}
}
