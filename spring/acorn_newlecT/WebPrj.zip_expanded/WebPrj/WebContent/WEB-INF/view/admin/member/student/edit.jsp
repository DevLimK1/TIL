<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
	<section class="main-section margin-top first">
		<h1 class="main title">회원정보</h1>
		<form action="edit" method="post">
		<table class="table margin-top">
			<tbody>
				<tr>
					<th>아이디</th>
					<td>大食</td>
					<th>가입일</th>
					<td>2020-05-08</td>
				</tr>
				<tr>
					<th>이름</th>
					<td>머식</td>
					<th>비밀번호</th>
					<td><input type="text" name="phone" value="1234" ></td>
				</tr>
				
				<tr>
					<th>핸드폰번호</th>
					<td><input type="text" name="phone" value="" ></td>
					<th>이메일</th>
					<td>websong44@hotmail.com</td>
				</tr>
				<tr>
					<th>성별</th>
					<td></td>
					<th>생년월일</th>
					<td></td>
				</tr>
			</tbody>
		</table>
		<div class="margin-top text-align-center">
				<input type="hidden" name="id" value="1" />				
				<input class="btn-text btn-default" type="submit" value="저장" />
				<a class="btn-text btn-cancel" href="detail?id=1">취소</a>	
		</div>
		</form>
	</section>
</main>