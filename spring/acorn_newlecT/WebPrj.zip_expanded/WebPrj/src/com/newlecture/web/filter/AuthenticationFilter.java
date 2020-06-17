package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private static final String[] interceptURLs = {"/admin/", "/member/", "/user/profile"};
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		String uri = httpRequest.getRequestURI();
		StringBuffer url = httpRequest.getRequestURL();
		
		System.out.printf("uri:%s, url:%s\n", uri, url.toString());	
		HttpSession session = httpRequest.getSession();		
		
		// /admin/ 일 경우만 인증과 권한 검사가 필요하다.
		// /admin/index, /admin/notice/list, /admin/notice/reg, ...
		if(uri.startsWith("/admin/")) {
			Object uid = session.getAttribute("uid");
			if(uid == null) // 인증 방식이 안되었어? 그럼 로그인하고 와
				httpResponse.sendRedirect("/member/login?returnURL="+uri);
			else {
				String role = String.valueOf(session.getAttribute("role"));
				//String role = service.getRoleByUserId(userName);
				System.out.printf("role:%s\n", role);
				if(role != null && !role.equals("admin"))
					httpResponse.sendRedirect("../error/403");
			}
		}
		
		chain.doFilter(request, response);
	}

}
