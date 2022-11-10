<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글목록보기</title>
</head>
<body>
	<h2>글목록</h2>
	<table border="1" cellspacing="0" cellpadding="0" width="1000">
		<tr bgcolor="pink" height="40">
			<th>번호</th>
			<th>아이디</th>
			<th>글쓴이</th>
			<th width="600">글제목</th>
			<th>죄회수</th>
			<th>등록일</th>
		</tr>
		
		<c:forEach items="${list }" var="fbdto">
		<tr>
			<td>${fbdto.fnum}</td>
			<td>${fbdto.fid}</td>
			<td>${fbdto.fname}</td>
			<td>${fbdto.ftitle}</td>
			<td>${fbdto.fhit}</td>
			<td>${fbdto.fdate}</td>
		</tr>
		</c:forEach>
		
		
		<tr>
			<td colspan = "6" align="right"><a href="writeForm">글쓰기</a></td>
		</tr>
	</table>
</body>
</html>