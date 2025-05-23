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
		String id=(String)request.getAttribute("userID");
		String pw=(String)request.getAttribute("userPW");
	%>

	<p>아이디: <%= id %>
	<p>패스워드: <%= pw %>
	
</body>
</html>