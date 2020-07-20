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
// 아래에서 반복문으로 돌릴 수 있겠다.
	private static final String[] interceptURLs= {"/admin/","/member/","/user/profile"};

	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("hello");
		// doFilter에서의 request는 ServletRequest 인터페이스이다.
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();
		StringBuffer url = httpRequest.getRequestURL();

		System.out.printf("uri:%s,url:%s\n", uri, url.toString());

		HttpSession session = httpRequest.getSession();// 세션으로 했으면 세션으로, 쿠리로했으면 쿠키로

		Object uid = session.getAttribute("uid"); // uid가 null이면 문자열 null이 아닌 null 그 자체로 값을 받기위해

		// /admin/* 일경우만 인증과 권한 검사가 필요하다.
		if (uri.startsWith("/admin/")) {

			if (uid == null) // 인증 방식이 안되었음 -> 로그인
				httpResponse.sendRedirect("/member/login?returnURL="+uri); // returnURL은 절대경로로 써야한다.
			else {

				String role = String.valueOf(session.getAttribute("role"));
				System.out.printf("role:%s",role);
				if (role != null && !role.equals("admin")) // 관리자가 아니면
					httpResponse.sendRedirect("../error/403");
			}
		}

		chain.doFilter(request, response);

	}

}
