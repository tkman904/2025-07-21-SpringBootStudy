package com.sist.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *   Spring Security
 *   ---------------
 *     | 보안을 담당하는 프레임워크
 *       ---
 *       | 인증 / 인가
 *       | ---   ---
 *       | |     | Authentication : 인증된 사용자가 자원에 접근이 가능한지 권한 확인
 *       | |                                   ---- 메뉴
 *       | | Authorization : 사용자가 누구인지 확인하는 절차 => 로그인
 *       |
 *       | 저장 (인증 => 권한 => 저장 => Session기반)
 *                                 --------
 *                                 | 서버가 종료가 되면 메모리에 해제
 *                                 | 보안 => Cookie 기반 : JWT
 *       1 인증(누구) => 회원가입된 자 / 게스트 / 관리자
 *            | => DispatcherServlet => HandlerMapping
 *              => 인터셉트
 *       2 Authentication Filter 
 *                | 책임전가
 *       3 Authentication Manager
 *                | 인증방법
 *         Authentiaction Provider
 *          (DataBase연결 => 데이터)  ====> 5 UserDetailService : 결과값 return
 *                                  ===> 4 User 비교 / 암호
 *                                       | PasswordEncoder
 *      ------------------------------- 재정의
 *      
 *      /login ========= security filter ==== DispatcherServlet
 *                                                |
 *      user(client)                           HandlerMapping
 *                                                |
 *                                              ViewResolver
 *                                                | => FilterChain
 *                                               JSP
 *      /login => permitAll (누구나 접근이 가능)
 *      /admin => hasRole('ROLE_ADMIN')
 *      /user  => hasRole('ROLE_USER')
 *      /board => ROLE_WRITE, ROLE_READ, ROLE_DELETE
 */
@Controller
public class MemberController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/user")
	public String user() {
		return "user";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
