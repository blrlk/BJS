<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="tt" class="programming.test" />
	<jsp:setProperty property="name" name="tt" value="홍길동" />
	<jsp:setProperty property="age" value="15" name="tt" />
	
	<p>이름: <jsp:getProperty property="name" name="tt"/></p>
	<p>나이: <jsp:getProperty property="age" name="tt"/></p>
</body>
</html>