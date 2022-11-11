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
			<td>${fbdto.ftitle }</td>
		</tr>
		
		<tr>
			<th valign="top">글 내 용</th>
			<td height="100" valign="top">${fbdto.fcontent }</td>
		</tr>
		<%
		int idflag = Integer.parseInt(request.getAttribute("idflag").toString());
		if (idflag == 1){
			
		
		%>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="javascript:window.location='modify_view?fnum=${fbdto.fnum }'">
				<input type="button" value="삭제" onclick="javascript:window.location='delete?fnum=${fbdto.fnum }'">
		<% 
			}
		%>		
				<input type="button" value="목록" onclick="javascript:window.location='list'">
			</td>
		</tr>
	</table>
</body>
</html>