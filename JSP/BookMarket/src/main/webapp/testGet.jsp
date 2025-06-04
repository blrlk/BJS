<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 데이터베이스 연결 -->
	<%
		Connection conn = null;
		
		//연결할 데이터베이스
		String url="jdbc:mysql://localhost:3306/BookmarketDB";
		
		//접속 id, pwd
		String user="root";
		String pw="1234";
		
		//데베 연결
		Class.forName("com.mysql.jdbc.Driver");	//드라이버 이름
		conn = DriverManager.getConnection(url,user,pw);	//연결 url, id, pw
		
		if(conn==null)
		{
			System.out.println("데이터베이스가 연결 되지 않았습니다.");
		}
		else
		{
			System.out.println("데이터베이스가 연결 되었습니다.");
		}
		
	%>
	
	<%
		PreparedStatement pstmt = null;
		String sql = "select * from member";
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
	%>
	
	<%
		while(rs.next()){
			String id = rs.getString("id");
			String pwd = rs.getString("passwd");
			String name = rs.getString("name");
		
	%>
	<%= id %>, <%= pwd %>, <%= name %><br>
	<% } %>
	</body>
</html>