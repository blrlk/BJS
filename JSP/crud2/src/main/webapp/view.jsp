<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dto.member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<member> arr = (ArrayList<member>) request.getAttribute("arr");
	%>
	<table>
		<tr>
			<td>이름</td>
			<td>나이</td>
			<td>수정</td>
			<td>삭제</td>
		</tr>
		
		<%
			for(int i=0;i<arr.size();i++){
				member mb = arr.get(i);
		%>
		<tr>
			<td><%= mb.getName() %></td>
			<td><%= mb.getAge() %></td>
			<td><a href="update?name=<%= mb.getName() %>">수정</a></td>
			<td><a href="delete?name=<%= mb.getName() %>">삭제</a></td>
		</tr>
		<% } %>
	</table>
	
	<a href="./">home</a>
</body>
</html>