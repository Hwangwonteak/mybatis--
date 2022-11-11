<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	<table width="500" border="1" cellspacing="0" cellpadding="0">
		<form action="modify">
		<input type="hidden" value="${fbdto.fnum }" name="fnum">
		<tr>
			<th width="100">글번호</th>
			<td>${fbdto.fnum}</td>
		</tr>
		<tr>
			<th>글쓴이</th>
			<td>${fbdto.fname }</td>
		</tr>
		<tr>
			<th>글제목</th>
			<td><input type="text" value="${fbdto.ftitle }" size="60" name="ftitle"></td>
		</tr>
		
		<tr>
			<th valign="top">글 내 용</th>
			<td height="100" valign="top"><input type="text" value="${fbdto.fcontent }" size="60" name="fcontent"></td>
		</tr>

		<tr>
			<td colspan="2" align="right">
				<input type="submit" value="완료">
				<input type="reset" value="취소">
				<input type="button" value="목록" onclick="javascript:window.location='list'">
			</td>
		</tr>
		</form>
	</table>
</body>
</html>