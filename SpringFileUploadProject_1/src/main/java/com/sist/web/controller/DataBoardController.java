package com.sist.web.controller;

import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sist.web.service.*;
import com.sist.web.vo.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("databoard/")
@RequiredArgsConstructor
public class DataBoardController {
	private final DataBoardService dService;
	
	@GetMapping("list")
	public String databoard_list(@RequestParam(name = "page", required = false) String page, Model model) {
		if(page == null) {
			page = "1";
		}
		
		int curpage = Integer.parseInt(page);
		List<DataBoardVO> list = dService.databoardListData((curpage-1)*10);
		int totalpage = dService.databoardTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "databoard/list";
	}
	
	// insert => 업로드
	@GetMapping("insert")
	public String databoard_insert() {
		return "databoard/insert";
	}
	
	@PostMapping("insert_ok")
	public String  databoard_insert_ok(@ModelAttribute DataBoardVO vo, HttpServletRequest request) throws Exception {
		String uploadDir = request.getServletContext().getRealPath("/upload");
		File dir = new File(uploadDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		
		List<MultipartFile> files = vo.getFiles();
		String filename = "";
		String filesize = "";
		boolean bCheck = false;
		for(MultipartFile file : files) {
			if(file.isEmpty()) {
				bCheck = false;
			} else {
				String oname = file.getOriginalFilename();
				File f = new File(uploadDir+"/"+oname);
				
				// 중복 확인
				if(f.exists()) {
					String name = oname.substring(0, oname.lastIndexOf("."));
					String ext = oname.substring(oname.lastIndexOf("."));
					int count = 1;
					while(f.exists()) {
						String newName = name + "(" + count + ")" + ext;
						f = new File(uploadDir+"/"+newName);
						count++;
					}
				}
				filename+=f.getName()+",";
				filesize+=f.length()+",";
				bCheck = true;
				
				// 업로드
				Path path = Paths.get(uploadDir, f.getName());
				Files.copy(file.getInputStream(), path);
			}
		}
		
		if(bCheck == true) {
			filename = filename.substring(0, filename.lastIndexOf(","));
			filesize = filesize.substring(0, filesize.lastIndexOf(","));
			
			vo.setFilename(filename);
			vo.setFilesize(filesize);
			vo.setFilecount(files.size());
		} else {
			vo.setFilecount(0);
			vo.setFilename("");
			vo.setFilesize("");
		}
		
		dService.databoardInsert(vo);
		
		return "redirect:/databoard/list";
	}
	
	@GetMapping("detail")
	public String databoard_detail(@RequestParam("no") int no, Model model) {
		DataBoardVO vo = dService.databoardDetailData(no);
		List<String> fList = new ArrayList<String>();
		List<String> sList = new ArrayList<String>();
		String f = vo.getFilename();
		String s = vo.getFilesize();
		
		if(vo.getFilecount() > 0) {
			StringTokenizer st = new StringTokenizer(f, ",");
			while(st.hasMoreTokens()) {
				fList.add(st.nextToken());
			}
			
			st = new StringTokenizer(s, ",");
			while(st.hasMoreTokens()) {
				sList.add(st.nextToken());
			}
			
			model.addAttribute("fList", fList);
			model.addAttribute("sList", sList);
		}
		
		model.addAttribute("vo", vo);
		
		return "databoard/detail";
	}
	
	@GetMapping("download")
	public void databoard_download(@RequestParam("fn") String fn, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String downloadDir = request.getServletContext().getRealPath("/upload");
		
		// Header : 파일명 / 파일크기
		File file = new File(downloadDir + "/" + fn);
		response.setHeader("Content-Disposition", "attchement;filename="+URLEncoder.encode(fn, "UTF-8"));
		response.setContentLength((int)file.length());
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		
		// 서버에서 파일 읽기
		BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
		int i = 0; // 읽은 바이트 수
		byte[] buffer = new byte[1024];
		while((i=bis.read(buffer, 0, 1024)) != -1) {
			bos.write(buffer, 0, i);
		}
		bis.close();
		bos.close();
	}
	
	@GetMapping("delete")
	public String databoard_delete(@RequestParam("no") int no, Model model) {
		model.addAttribute("no", no);
		
		return "databoard/delete";
	}
}
