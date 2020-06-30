<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="aside">
	<h1>ADMIN PAGE</h1>



	<nav class="menu text-menu first margin-top">
		<h1>마이페이지</h1>
		<ul>
			<li><a href="/admin/index.html">관리자홈</a></li>
			<li><a href="/teacher/index.html">선생님페이지</a></li>
			<li><a href="/student/index.html">수강생페이지</a></li>
		</ul>
	</nav>

	<nav class="menu text-menu">
		<h1>카테고리</h1>
		<ul>
			<c:forEach var="c" items="${categories}">
				<li><a href="">${c.title }</a></li>
			</c:forEach>
		</ul>
	</nav>

	<nav class="menu text-menu">
		<h1>알림관리</h1>
		<ul>
			<li><a href="/admin/board/notice/list.html">공지사항</a></li>
		</ul>
	</nav>

</aside>