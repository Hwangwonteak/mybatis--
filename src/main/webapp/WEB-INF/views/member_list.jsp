<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>
</head>
<body>
	<h2>회원 리스트 보기</h2>
	<hr>
	
	<table width="500" border="1" cellspacing="0" cellpadding="0">
		<tr>
			<th width="100">아이디</th>
			<td>${minfo.mid}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td>${minfo.mpw}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${minfo.mname}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${minfo.memail}</td>
		</tr>
		<tr>
			<th>가입일자</th>
			<td>${minfo.mdate}</td>
		</tr>
		
		

		<tr>
			<td colspan="2" align="right">
				<input type="button" value="정보수정" onclick="javascript:window.location='member_view?mid=${minfo.mid}'">
				<input type="button" value="회원탈퇴" onclick="javascript:window.location='delete?mid=${minfo.mid}'">
				<input type="button" value="목록" onclick="javascript:window.location='member_list'">
			</td>
		</tr>
	</table>
	</body>
</html>