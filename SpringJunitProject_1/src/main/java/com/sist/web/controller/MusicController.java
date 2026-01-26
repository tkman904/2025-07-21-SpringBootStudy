package com.sist.web.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

import com.sist.web.vo.*;
import com.sist.web.service.*;

/*
 * [{"snippet":{"publishTime":"2021-12-15T14:21:44Z",
 * 	"publishedAt":"2021-12-15T14:21:44Z",
 *  "description":"Title\u201D by Meghan Trainor Listen to Meghan Trainor: https:\/\/MeghanTrainor.lnk.to\/listenYD Watch more Meghan Trainor videos: ...",
 *  "title":"Meghan Trainor - Title (Official Music Video)",
 *  "thumbnails":{"default":{"width":120,"url":"https:\/\/i.ytimg.com\/vi\/fD7LIqkKisc\/default.jpg","height":90},
 *  "high":{"width":480,"url":"https:\/\/i.ytimg.com\/vi\/fD7LIqkKisc\/hqdefault.jpg","height":360},
 *  "medium":{"width":320,"url":"https:\/\/i.ytimg.com\/vi\/fD7LIqkKisc\/mqdefault.jpg","height":180}},
 *  "channelId":"UCf3cbfAXgPFL6OywH7JwOzA","channelTitle":"MeghanTrainorVEVO","liveBroadcastContent":"none"},
 *  "kind":"youtube#searchResult",
 *  "etag":"0MecTDDyb4grJJbu-L-kJ-0kLpk",
 *  "id":{"kind":"youtube#video","videoId":"fD7LIqkKisc"}}]
 */
@Controller
@RequiredArgsConstructor
public class MusicController {
	private final MusicService mService;
	
	@GetMapping("/")
	public String music_list(@RequestParam(name = "page", required = false) String page, Model model) {
		/*
		 *   1. 사용자가 보내준 데이터 받기 => 매개변수로 처리
		 *   2. 데이터베이스 연동 / 크롤링 / Spring AI
		 *   	=> 요청처리에 필요한 데이터 읽기
		 *   3. 데이터를 브라우저로 전송
		 *   4. 어떤 JSP로 전송할지 설정
		 */
		if(page == null) {
			page = "1";
		}
		int curpage = Integer.parseInt(page);
		List<MusicVO> list = mService.musicListData((curpage-1)*20);
		int totalpage = mService.musicTotalPage();
		
		model.addAttribute("list", list);
		model.addAttribute("curpage", curpage);
		model.addAttribute("totalpage", totalpage);
		
		return "list";
	}
	
	@GetMapping("/detail")
	public String music_detail(@RequestParam("no") int no, Model model) throws Exception {
		String title = mService.musicGetTitle(no);
		System.out.println("title= "+title);
		
		URL url = new URL("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q="+URLEncoder.encode(title,"UTF-8")+"&type=video&key=AIzaSyBFlPklmlcHlaL1-zXzJ4qS7aWohGCeHAs");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		StringBuffer sb = new StringBuffer();
		if(conn != null) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			while(true) {
				String json = in.readLine();
				if(json == null) {
					break;
				}
				sb.append(json);
		//System.out.println(json);                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                	
			}
			conn.disconnect();
			in.close();
		}
		//System.out.println(sb.toString());
		//Document doc = Jsoup.connect("https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=28&q="+title+"&type=video&key=AIzaSyBFlPklmlcHlaL1-zXzJ4qS7aWohGCeHAs").get();
		JSONParser jp = new JSONParser();
		JSONObject root = (JSONObject)jp.parse(sb.toString());
		//System.out.println(root.toJSONString());
		JSONArray arr = (JSONArray)root.get("items");
		
		List<MovieVO> list = new ArrayList<MovieVO>();
		for(int i=0;i<arr.size();i++) {
			JSONObject obj = (JSONObject)arr.get(i);
			JSONObject snippet = (JSONObject)obj.get("snippet");
			String name = (String)snippet.get("title");
			//System.out.println(name);
			JSONObject id = (JSONObject)obj.get("id");
			String key = (String)id.get("videoId");
			
			MovieVO vo = new MovieVO();
			vo.setTitle(name);
			vo.setKey(key);
			list.add(vo);
		}
		
		model.addAttribute("list", list);
		//System.out.println(arr.toJSONString());
		
		return "detail";
	}
}
