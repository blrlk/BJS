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
		String id = (String)request.getAttribute("id");
		String pwd = (String)request.getAttribute("pwd");
	%>
	<p>입력된 id 값: <%= id %>
	<p>입력된 password 값: <%= pwd %>
	
</body>
</html>