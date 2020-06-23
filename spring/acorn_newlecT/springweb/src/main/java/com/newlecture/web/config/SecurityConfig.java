package com.newlecture.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception { //url 적어서 url 인증이 필요합니다.
		http.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")//ADMIN만 접근 가능
		.antMatchers("/teacher/**").hasRole("TEACHER") //TEACHER만 접근 가능
		.antMatchers("/student/**").hasRole("STUDENT") //STUDENT만 접근 가능
		.antMatchers("/member/home").authenticated()//인증 된 사람이면 아무나 다
		.and()
		.formLogin()
			.loginPage("/member/login") //GET 요청(URL)
			.loginProcessingUrl("/member/login") //POST 요청 (URL)
			.defaultSuccessUrl("/index")
		.and()
		.csrf() //사이트간 요청 위조
			.disable();
			
		//  /* :하위바로 아래 디렉토리  /** : 하위디렉토리 모두
		
//		super.configure(http); //이미 스프링에서 구현된 로그인페이지가 보인다
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication(); //DB를 쓰지않고 메모리상에서 
		//auth.jdbcAuthentication(); //DB를 인증도구로 사용하겠다.
		//auth.ldapAuthentication(); //도메인 컨트롤러 -> 회사에서 사용할듯
		
		
//		auth.inMemoryAuthentication()
//		.withUser("newlec")
//			/*.password("111")*/ //->암호화되어 저장되기 때문에 로그인되지 않음. 
//			.password("{noop}111") // -> {noop}을 써서 111 그대로 비교하게 설정
//			.roles("ADMIN") 
//		.and()
//		.withUser("dragon")
//			.password("111")
//			.roles("TEACHER");
		
		auth
			.jdbcAuthentication()
				.dataSource(dataSource)
				.usersByUsernameQuery("select uid id, pwd password, 1 enabled from member where uid=?");
		//우리가 사용하고 있는 칼럼 테이블 uid를 id라는 별칭으로 바꾼다. pwd -> password , 1(존재하지 않은 것을 상수화)을 enabled라는 별칭을 준다.
			
	}
}
