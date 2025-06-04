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
		String user="admin";
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
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String name = request.getParameter("name");
		
		System.out.println(id);
		System.out.println(passwd);
		System.out.println(name);
		
		//데베에 데이터 넣기
		Statement stmt = null;
		String sql = "insert into Member(id, passwd, name) values('"+ id +"', '" + passwd + "', '" + name + "')";
		
		stmt = conn.createStatement();
		//데이터 삽입
		stmt.executeUpdate(sql);
	%>
	
	
	
	<%
		//PreparedStatement pstmt = null;
		//String sql2 = "insert into member(id, passwd, name) values(?, ?, ?)";
		//pstmt = conn.prepareStatement(sql2);
		//?(변수) 값 채우기 :: 문자열: setString, 정수: setInt etc. -> setString(순서번호, 변수)
		//pstmt.setString(1, id);
		//pstmt.setString(2, passwd);
		//pstmt.setString(3, name);
		//데이터 삽입
		//pstmt.executeUpdate();
	%>
</body>
</html>