<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입완료</title>
</head>
<body>
	<%
		int checkId = Integer.parseInt(request.getAttribute("checkIdFlag").toString());
		if(checkId == 1 ){
			
	
	%>
		<script language="javascript">
			alert("입력하신 아이디는 이미사용중입니다.")
			history.go(-1);
			
		</script>
	<%
		}
	
	%>
	<h2>회원가입을 축하드립니다.</h2>
	<h2>${mname}님 회원가입을 축하드립니다.</h2>		
</body>
</html>