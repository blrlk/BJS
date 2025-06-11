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
		ArrayList<member> arr = (ArrayList<member>)request.getAttribute("arr");
	%>
	
	<table>
		<tr>
			<td>아이디
			<td>비밀번호
			<td>수정
			<td>삭제
		</tr>
		<%
			for(int i=0;i<arr.size();i++){
				member mb = arr.get(i);
			
		%>
		<tr>
			<td><%= mb.getId() %>
			<td><%= mb.getPwd() %>
			<td><a href="update?id=<%= mb.getId() %>">수정</a>
			<td><a href="delete?id=<%= mb.getId() %>">삭제</a>
		</tr>
		<%} %>
	</table>
	<a href="./">home</a>
	
</body>
</html>