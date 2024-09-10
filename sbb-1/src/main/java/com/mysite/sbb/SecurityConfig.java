package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
// PasswordEncoder 빈을 만들기 위해
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// 스프링의 환경 설정 파일임을 의미하는 애너테이션 
@Configuration
// 모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션 
@EnableWebSecurity
public class SecurityConfig {
	// 스프링 시큐리티의 세부 설정은 @Bean 애너테이션을 통해 SecurityFilterChain빈을 생성하여 설정할 수 있음 
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 인증되지 않은 모든 페이지의 요청을 허락한다는 의미 -> 로그인 하지 않아도 모든 페이지에 접근 할 수 있음 
		http .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests .requestMatchers(new AntPathRequestMatcher("/**")).permitAll())
		// H2-console 오류 수정 (404 Forbidden/ CSRF)
		.csrf((csrf) -> csrf .ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**")))
		// H2 콘솔 화면 적용? 
		.headers((headers) -> headers .addHeaderWriter(new XFrameOptionsHeaderWriter(XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
		;
		return http.build();
		
	}
		
		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		
	}
	

}
