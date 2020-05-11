
<%@page import="com.newlecture.web.entity.Notice"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.entity.NoticeView"%>
<%@page import="java.text.NumberFormat.Style"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <%
	NoticeService service =new NoticeService();
	List<NoticeView> list =service.getNoticeList();
%>
 --%>
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

	<jsp:include page="../inc/header.jsp" />


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



			<main class="main">
				<h2 class="main title">공지사항</h2>

				<div class="breadcrumb">
					<h3 class="hidden">경로</h3>
					<ul>
						<li>home</li>
						<li>고객센터</li>
						<li>공지사항</li>
					</ul>
				</div>

				<div class="search-form margin-top first align-right">
					<h3 class="hidden">공지사항 검색폼</h3>
					<form class="table-form">
						<fieldset>
							<legend class="hidden">공지사항 검색 필드</legend>
							<label class="hidden">검색분류</label> <select name="f">
								<option value="title">제목</option>
								<option value="writerId">작성자</option>
							</select> <label class="hidden">검색어</label> <input type="text" name="q"
								value="" /> <input class="btn btn-search" type="submit"
								value="검색" />
						</fieldset>
					</form>
				</div>

				<div class="notice margin-top">
					<h3 class="hidden">공지사항 목록</h3>
					<table class="table">
						<thead>
							<tr>
								<th class="w60">번호</th>
								<th class="expand">제목</th>
								<th class="w100">작성자</th>
								<th class="w100">작성일</th>
								<th class="w60">조회수</th>
							</tr>
						</thead>

						<tbody>


							<c:forEach var="n" items="${list }" varStatus="st">
								<%-- <%
							지역변수 n으로 사용하고 싶으면
								NoticeView n=(NoticeView)pageContext.getAttribute("n");
								n.getTitle();
							%> --%>
								<tr>
									<td>${n.id }</td>
									<td class="title indent text-align-left"><a
										href="detail?id=${n.id}">${n.title }</a></td>
									<td>${n.writerId }</td>
									<td>${n.regdate }</td>
									<td>${n.hit }</td>

								</tr>
							</c:forEach>


							<%-- 	<%
							List<NoticeView> list=(List<NoticeView>)request.getAttribute("list");
							for(NoticeView n : list){
							%>
							<tr >
								<td><%=n.getId() %></td>
								<td class="title indent text-align-left"><a
									href="detail?id=<%=n.getId()%>"><%=n.getTitle() %></a></td>
								<td><%=n.getWriterId()%></td>
								<td><%=n.getRegdate() %></td>
								<td><%=n.getHit() %></td>

							</tr>
							<%
								}
							%> --%>
						</tbody>
					</table>
				</div>

				<div class="indexer margin-top align-right">
					<h3 class="hidden">현재 페이지</h3>
					<div>
						<span class="text-orange text-strong">1</span> / 1 pages
					</div>
				</div>

				<div class="margin-top align-center pager">

					<div>


						<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>

					</div>
					<ul class="-list- center">
						<c:forEach var="i" begin="1" end="5">
							<c:set var="orange" />
							<c:if test="${i==1 }">
								<c:set var="orange" value="-text- orange bold"></c:set>
							</c:if>

							<li><a class="${orange }" href="?p=1&t=&q=">${i}</a></li>
						</c:forEach>
					</ul>
					<%-- 	<ul class="-list- center">
						<c:forEach var="i" begin="1" end="5">

							<c:if test="${i==1 }">
								<li><a class="-text- orange bold" href="?p=1&t=&q=">${i}</a></li>
							</c:if>
							<c:if test="${i!=1 }">
								<li><a class="" href="?p=1&t=&q=">${i}</a></li>
							</c:if>
							
						</c:forEach>
					</ul> --%>
					<div>


						<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>

					</div>

				</div>
			</main>


		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->

	<jsp:include page="../inc/footer.jsp"></jsp:include>



</body>

</html>