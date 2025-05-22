<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="person" class="ch04.com.dao.ex07_Person" scope="request"/>
	
	<h4>----- useBean03 -----</h4>
	<p>아이디: <%= person.getId() %></p>
	<p>이름: <%= person.getName() %></p>
	
	<%
		person.setId(20230510);
		person.setName("홍길동");
	%>
	
	<h4>----- useBean04 -----</h4>
	<jsp:include page="07_useBean03.jsp"/>
</body>
</html>