<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String userid = (String)request.getAttribute("userid");
		String userpw = (String)request.getAttribute("userpw");
		
		if(userid.equals("admin") && userpw.equals("1234")){
	%>
	<p>쿠키 생성 성공<br><%= userid %>님 환영합니다.
	<%
		} else{
	%>
	<p>쿠키 생성 실패
	<%
	}
	%>
	
	14:30
	
</body>
</html>