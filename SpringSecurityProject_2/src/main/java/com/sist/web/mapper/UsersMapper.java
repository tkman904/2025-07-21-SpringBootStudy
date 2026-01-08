package com.sist.web.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.sist.web.vo.*;

/*
 *		user / admin
 *		|	   | ROLE_ADMIN, ROLE_USER
 *		| ROLE_USER 
 */

@Mapper
@Repository
public interface UsersMapper {
	@Insert("INSERT INTO users_1(username, password) VALUES(#{username}, #{password})")
	public void usersInsert(UsersVO vo);
	
	@Select("SELECT * FROM users_1 WHERE username = #{username}")
	public UsersVO findByUsername(String username);
	
	@Select("SELECT role_name FROM user_role WHERE user_id = #{userId}")
	public List<String> findRolesByUserId(int userId);
	
	// 로그인 ...
}
