//package com.newlecture.web.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@Configuration //설정을 담고 있는 어노테이션 -> 이 클래스가 설정 파일입니다.
//public class NewlectureMvcConfiguration extends WebMvcConfigurerAdapter{
//	//설정방법 
//	//1.어노테이션
//	//2.XML
//	//3.java
//	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//
//		//resolver: view 찾아주는 녀석
//		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/view/");
//		resolver.setSuffix(".jsp");
//		resolver.setViewClass(JstlView.class); //view에 대한 기술을 앞에 붙임,클래스 정보를 넘겨주기 위해 사용
//		registry.viewResolver(resolver);
//	
//	}
//	
//}
