<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 편집</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript">
	function deleteConfirm(id){
		console.log("함수입장");
		if(confirm("해당 도서 삭제") == true){
			console.log("삭제");
			location.href="./deleteBook.jsp?id=" + id;
		} else{
			return;
		}
	}
</script>
</head>
<%
	String edit = request.getParameter("edit");
%>
<body>
	<div class="container p-4">
		<%@ include file="menu.jsp" %>
		
		<div class="p-5 mb-4 bg-body-tertiary rounded-3">
			<div class="container-fluid py-5">
				<h1 class="display-5 fw-bold">도서 편집</h1>
				<p class="col-md-8 fs-4">BookEditing</p>
			</div>
		</div>
		
		<%@include file="dbconn.jsp" %>
		<div class="row align-items-md-stretch text-center">
		<%
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String sql = "SELECT * FROM book";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
		%>
		<div class="col-md-4">
				<div class="h-100 p-2 round-3">
					<img src="./resources/images/<%= rs.getString("b_fileName") %>" style="width:250; height:350;" />
					<h5><b><%= rs.getString("b_name") %></b></h5>
					<p><%= rs.getString("b_author") %>
					<br><%= rs.getString("b_publisher") %> | <%= rs.getString("b_releaseDate") %></p>
					
					<% if(rs.getString("b_description").length() >= 60){ %>
					<p><%= rs.getString("b_description").substring(0, 60) %></p>
					<% } else { %>
					<p><%= rs.getString("b_description") %></p>
					<% } %>
					
					<p><%= rs.getString("b_unitPrice") %>원</p>
					<p>
						<%
							if(edit.equals("update")){
						%>
						<a href="./updateBook.jsp?id=<%= rs.getString("b_id") %>" class="btn btn-success" role="button">수정 &raquo;</a>
						<%
							} else if(edit.equals("delete")){
						%>
						<a href="#" onclick="deleteConfirm('<%= rs.getString("b_id") %>')" class="btn btn-danger" role="button">삭제 &raquo;</a>
						<%
							}	//if문
						%>
					</p>
				</div>
			</div>
			<%
				}	//while문
				if(rs!=null){
					rs.close();
				}
				if(pstmt!=null){
					pstmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			%>
		</div>
		<%@ include file="footer.jsp" %>
	</div>
</body>
</html>