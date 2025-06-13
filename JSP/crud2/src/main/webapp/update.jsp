<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		member mb = (member)request.getAttribute("mb");
		
	%>
	
	<form action="update" method="post">
		<p>이름: <input type="text" name="name" value="<%= mb.getName() %>"></p>
		<p>나이: <input type="text" name="age" value="<%= mb.getAge() %>"></p>
		<p><input type="submit" value="수정"></p>
	</form>
	
	<a href="./">home</a>
</body>
</html>