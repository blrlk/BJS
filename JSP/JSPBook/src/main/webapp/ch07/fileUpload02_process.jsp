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
		String name1 = (String) request.getAttribute("name1");
		String subject1 = (String) request.getAttribute("subject1");
		String image1 = (String) request.getAttribute("image1");
		
		String name2 = (String) request.getAttribute("name2");
		String subject2 = (String) request.getAttribute("subject2");
		String image2 = (String) request.getAttribute("image2");
		
		String name3 = (String) request.getAttribute("name3");
		String subject3 = (String) request.getAttribute("subject3");
		String image3 = (String) request.getAttribute("image3");
	%>
	
	<div>
		<h2>name1: <%= name1 %></h2>
		<h2>subject1: <%= subject1 %></h2>
		<img src="resources/images/<%=image1 %>">
		<% System.out.println(image1); %>
	</div>
	
	<div>
		<h2>name2: <%= name2 %></h2>
		<h2>subject2: <%= subject2 %></h2>
		<img src="resources/images/<%=image2 %>">
	</div>
	
	<div>
		<h2>name3: <%= name3 %></h2>
		<h2>subject3: <%= subject3 %></h2>
		<img src="resources/images/<%=image3 %>">
	</div>
</body>
</html>