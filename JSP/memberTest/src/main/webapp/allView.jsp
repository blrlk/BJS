<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "DTO.member" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<member> arr = (ArrayList<member>)request.getAttribute("arr");
		System.out.println(arr);
	%>
	
	<table>
		<tr>
			<td>아이디</td> <td>패스워드</td> <td>이름</td> <td>수정</td> <td>삭제</td>
		</tr>
		<%
			for(int i=0;i<arr.size();i++){
				member mb = arr.get(i);
				String id = mb.getId();
		%>
		<tr>
			<td><%= id %></td>
			<td><%= mb.getPwd() %></td>
			<td><%= mb.getName() %></td>
			<td><a href="update?id=<%= id %>">수정</a></td>
			<td><a href="delete?id=<%= id %>">삭제</a></td>
		</tr>
		<%
			}
		%>
	</table>
	
	<a href="./">home</a>
</body>
</html>