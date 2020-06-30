package com.newlecture.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

//@Component //IoC에 담을 때 사용
public class NewlectureAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("로그인 성공 후에 뭘할까?");
		
		HttpSession session=request.getSession();
		//로그인에 성공한 후에 뭘 해야 하나?
		
		
		//원하는 곳으로 보내는 루틴
		SavedRequest savedRequest=(SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST"); //return URL과 같은 역할
		//있으면 그대로 가게하고, 없으면 기본페이지로 가게한다.
		
		if(savedRequest!=null) { //가려던 길로 보낸다
			String returnURL=savedRequest.getRedirectUrl();
			response.sendRedirect(returnURL);
		}else { //기본페이지로 보낸다.
			response.sendRedirect("/index");
		}
		
	}
	
}
