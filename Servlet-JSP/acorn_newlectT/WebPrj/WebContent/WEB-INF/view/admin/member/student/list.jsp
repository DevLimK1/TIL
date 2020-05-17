<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<main class="main">
	<h2 class="main title">회원목록-[5]</h2>

	<div class="breadcrumb">
		<h3 class="hidden">breadlet</h3>
		<ul>
			<li>home</li>
			<li>회원관리</li>
			<li>학생회원</li>
		</ul>
	</div>

	<div class="search-form margin-top first align-right">
		<h3 class="hidden">회원 검색폼</h3>
		<form class="table-form">
			<fieldset>
				<legend class="hidden">회원 검색 필드</legend>
				<label class="hidden">검색분류</label> <select name="t">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="phone">연락처</option>
				</select> <label class="hidden">검색어</label> <input type="text" name="q" /> <input
					class="btn btn-search" type="submit" value="검색" />
			</fieldset>
		</form>
	</div>

	<div class="margin-top">
		<h3 class="hidden">회원 목록</h3>
		<table id="member-table" class="table table-list">
			<thead>
				<tr>
					<th class="w100">이름(아이디)</th>
					<th class="">가입일</th>
					<th class="w100">연락처</th>
					<th class="w60">성별</th>
					<th class="w60">나이</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.name }(<a href="detail?id=${list.id }">${list.uid }</a>)
						</td>
						<td>${list.regDate }</td>
						<td></td>
						<td></td>
						<td>${list.age }</td>
					</tr>

				</c:forEach>

			</tbody>
		</table>
	</div>

	<div class="indexer text-align-right margin-top">
		<h3 class="hidden">현재 페이지</h3>
		<div>
			<span class="text-strong color-notice">1</span> / 3 pages
		</div>
	</div>

	<div class="text-align-right margin-top">
		<a class="btn-text btn-default" href="reg">학생추가</a>
	</div>

	<div class="text-align-center margin-top">
		<div class="pager">
			<h3 class="hidden">페이저</h3>


			<div>


				<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>

			</div>
			<ul class="-list- center">



				<li><a class="-text- orange bold" href="?p=1&t=&q=">1</a></li>







				<li><a href="?p=2&t=&q=">2</a></li>






				<li><a href="?p=3&t=&q=">3</a></li>






				<li><a href="?p=4&t=&q=">4</a></li>






				<li><a href="?p=5&t=&q=">5</a></li>




			</ul>
			<div>

				<a class="btn btn-next" href="?p=6&t=&q=">다음</a>


			</div>

		</div>
	</div>
</main>