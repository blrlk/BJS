<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="date" class="java.util.Date"/>
	<!-- Date date = new Date(); -->
	
	<p>
		<%
			out.print("<h2>오늘의 날짜 및 시각</h2>");
		%>
	</p>
	
	<p><%= date %></p>
</body>
</html>