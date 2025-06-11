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
	
	<form method="post" action="update">
		<p>아이디: <input type="text" name="id" value="<%= mb.getId() %>"></p>
		<p>비밀번호: <input type="text" name="pwd" value="<%= mb.getPwd() %>"></p>
		<p><input type="submit" value="수정"></p>
	</form>
</body>
</html>