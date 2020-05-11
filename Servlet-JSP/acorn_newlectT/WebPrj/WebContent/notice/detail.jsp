<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.NoticeService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>

<head>
<title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
<meta charset="UTF-8">
<title>공지사항목록</title>

<link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
<style>
#visual .content-container {
	height: inherit;
	display: flex;
	align-items: center;
	background: url("../../images/customer/visual.png") no-repeat center;
}
</style>
</head>

<body>

	<!-- header 부분 -->

	<jsp:include page="../inc/header.jsp"/>

	<!-- --------------------------- <visual> --------------------------------------- -->
	<!-- visual 부분 -->

	<div id="visual">
		<div class="content-container"></div>
	</div>
	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside 부분 -->


			<aside class="aside">
				<h1>고객센터</h1>

				<nav class="menu text-menu first margin-top">
					<h1>고객센터메뉴</h1>
					<ul>
						<li><a class="current" href="/customer/notice">공지사항</a></li>
						<li><a class="" href="/customer/faq">자주하는 질문</a></li>
						<li><a class="" href="/customer/question">수강문의</a></li>
						<li><a class="" href="/customer/event">이벤트</a></li>

					</ul>
				</nav>


				<nav class="menu">
					<h1>협력업체</h1>
					<ul>
						<li><a target="_blank" href="http://www.notepubs.com"><img
								src="/images/notepubs.png" alt="노트펍스" /></a></li>
						<li><a target="_blank" href="http://www.namoolab.com"><img
								src="/images/namoolab.png" alt="나무랩연구소" /></a></li>

					</ul>
				</nav>

			</aside>
			<!-- --------------------------- main --------------------------------------- -->




			<main>
				<h2 class="main title">공지사항</h2>

				<div class="breadcrumb">
					<h3 class="hidden">breadlet</h3>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</div>

				<div class="margin-top first">
					<h3 class="hidden">공지사항 내용</h3>
					<table class="table">
						<tbody>
							<tr>
								<th>제목</th>
								<td class="text-align-left text-indent text-strong text-orange"
									colspan="3">${n["title"]}</td>
							</tr>
							<tr>
								<th>작성일</th>
								<td class="text-align-left text-indent" colspan="3">
								<fmt:formatDate
								pattern="yyyy-MM-dd HH:mm:ss초"
										value="${n.regdate }" /></td>
							</tr>
							<tr>
								<th>작성자</th>
								<td>${n.writerId }</td>
								<th>조회수</th>
								<td>
								<fmt:formatNumber
								type="currency"
								value="123456789"
								currencySymbol="$"
								>
								</fmt:formatNumber>
								원
								</td>
								<%-- ${n.hit } --%>
							</tr>
							<tr>
								<th>첨부파일</th>
								<td colspan="3"><c:forTokens var="fname"
										items="file1.zip,file2.gif" delims=",">
										<a href="">${ fname}</a>
									</c:forTokens> <%-- ${n.files } --%> <!-- file1.zip,file2.gif --> <!-- <a href="">file1.zip</a>
										<a href="">file2.gif</a> --></td>
							</tr>
							<tr class="content">
								<td colspan="4">${n.content }</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="margin-top text-align-center">
					<a class="btn btn-list" href="list.html">목록</a>
				</div>

				<div class="margin-top">
					<table class="table border-top-default">
						<tbody>

							<tr>
								<th>다음글</th>
								<td colspan="3" class="text-align-left text-indent">다음글이
									없습니다.</td>
							</tr>




							<tr>
								<th>이전글</th>
								<td colspan="3" class="text-align-left text-indent"><a
									class="text-blue text-strong" href="">스프링 DI 예제 코드</a></td>
							</tr>


						</tbody>
					</table>
				</div>

			</main>

		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->

	<jsp:include page="../inc/footer.jsp"/>

	
</body>

</html>