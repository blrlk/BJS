<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버 등록</title>
</head>
<body>
	<%@ include file="index.jsp" %>
	
	<form method="post" action="create">
		<p>이름 <input type="text" name="name"></p>
		<p>나이 <input type="text" name="age"></p>
		<input type="submit" value="전송">
	</form>
</body>
</html>