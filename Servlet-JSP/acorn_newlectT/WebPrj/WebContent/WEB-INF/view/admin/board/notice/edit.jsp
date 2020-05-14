<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main>
	<h2 class="main title">공지사항 수정</h2>

	<div class="breadcrumb">
		<h3 class="hidden">breadlet</h3>
		<ul>
			<li>home</li>
			<li>게시글 관리</li>
			<li>공지사항</li>
		</ul>
	</div>

	<form action="edit" method="post" >
		<div class="margin-top first">
			<h3 class="hidden">공지사항 수정</h3>
			<table class="table">
				<tbody>
					<tr>
						<th>제목</th>
						<td class="text-align-left text-indent text-strong text-orange"
							colspan="3"><input type="text" name="title"
							value="${n.title}" /></td>
					</tr>
					<tr>
						<th>작성일</th>
						<td class="text-align-left text-indent" colspan="3">${n.regdate}
						</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${n.writerId }</td>
						<th>조회수</th>
						<td>${n.hit}</td>
					</tr>
					<!-- <tr>
                     <th>첨부파일</th>
                     <td colspan="3"><input type="file" name="file" /> </td>
                  </tr> -->
					<tr class="content">
						<td colspan="4"><textarea class="content" name="content">
						${n.content }
						</textarea></td>
					</tr>
				</tbody>
			</table>
		</div>

		<div class="margin-top text-align-center">
			<input type="hidden" name="id" value="${n.id }" /> <input
				class="btn-text btn-default" type="submit" value="저장" /> <a
				class="btn-text btn-cancel" href="../../notice/12">취소</a>
		</div>
	</form>


</main>