package com.sist.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	// FilterChain
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 인증 => 권한 부여
		http
		.csrf(csrf -> csrf.disable())
		.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/login").permitAll() // 모든 접속자 허용
				.requestMatchers("/user").authenticated() // 로그인이 된 상태
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().permitAll())
		.formLogin(form -> form
				.loginPage("/login")
				.loginProcessingUrl("/login")
				.defaultSuccessUrl("/", true)
				.failureUrl("/login?error").permitAll())
		.logout(logout -> logout
				.logoutSuccessUrl("/"));
		
		return http.build();
	}
	
	// UserDetailsService
	@Bean
	public UserDetailsService userDetailService() {
		UserDetails user = User.builder()
				.username("user")
				.password("{noop}1234")
				.roles("USER")
				.build();
		
		UserDetails admin = User.builder()
				.username("admin")
				.password("{noop}1234")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	// PasswordEncoder
}
