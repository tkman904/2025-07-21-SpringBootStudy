package com.sist.web.service;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sist.web.vo.*;
import com.sist.web.mapper.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
	private final UserMapper mapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UsersVO user = mapper.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Username을 찾을 수 없습니다");
		}
		
		List<String> roles = mapper.findRolesByUserId(user.getId());
		
		// 권한 관련
		Set<GrantedAuthority> author = new HashSet<GrantedAuthority>();
		for(String role : roles) {
			author.add(new SimpleGrantedAuthority(role));
		}
		
		// 사용자의 모든 정보 저장 => session에 저장
		return new User(user.getUsername(), user.getPassword(), user.getEnabled() == 0 ? false : true, true, true, true, author);
	}
}
