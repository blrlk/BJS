<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="DTO.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		member mb = (member)request.getAttribute("member");
	%>
	
	<form action="update" method="post">
		<p>아이디: <input type="text" name="id" value="<%=mb.getId() %>"></p>
		<p>패스워드: <input type="text" name="pwd" value="<%=mb.getPwd() %>"></p>
		<p>이름: <input type="text" name="name" value="<%=mb.getName() %>"></p>
		<p><input type="submit" value="수정"></p>
	</form>

</body>
</html>