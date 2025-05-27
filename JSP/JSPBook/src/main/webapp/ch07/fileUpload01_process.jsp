<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.oreilly.servlet.*" %>
<%@ page import = "com.oreilly.servlet.multipart.*" %>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name1");
		String subject = (String)request.getAttribute("subject1");	
		String image1 = (String)request.getAttribute("image1");	
	%>

	<h3><%= name %></h3>
	<h3><%= subject %></h3>
	<!-- 상대경로는 현재 URL의 영향을 받음 -->
	<img src = "resources/images/<%= image1 %>">
	
</body>
</html>