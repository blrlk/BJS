<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		HttpSession session = request.getSession(false);
		String id = (String)session.getAttribute("id");
		String pwd = (String)session.getAttribute("pwd");
	%>
	<a href="other">다른 컨트롤러</a>
	<p>아이디: <%= id %>
	<p>비밀번호: <%= pwd %>
</body>
</html>