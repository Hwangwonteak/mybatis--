<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
	<%
		int checkId = Integer.parseInt(request.getAttribute("checkIdFlag").toString());
		int checkPw = Integer.parseInt(request.getAttribute("checkPwFlag").toString());
		if(checkId == 0 ){
	
	
	%>
		<script language="javascript">
			alert("입력하신 아이디는 없는 아이디 입니다.")
			history.go(-1);
			
		</script>
	<%
		}else if(checkPw == 0) {
	
	%>
	<script language="javascript">
			alert("입력하신 비밀번호는 없는 비밀번호 입니다.")
			history.go(-1);
	</script>
	<%
	}
	%>
		<h2>로그인 완료.</h2>
		<h2>${mid}님 로그인.</h2>	
		<h2>회원이름: ${mname}님 </h2>
		<a href="writeForm">글쓰기</a><br><br>
		<a href="logout">로그아웃</a><br><br>
		<a href="member_list?mid=${mid }">멤버리스트</a>	
		
</body>
</html>
