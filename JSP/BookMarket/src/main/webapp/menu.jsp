<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<script src="https://kit.fontawesome.com/fc2e77f065.js" crossorigin="anonymous"></script>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<header class="p-3 border-bottom">
	<div class="container">
		<div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
			<a href="./welcome.jsp" class="d-flex align-items-center mb-3-mb-md-0 me-md-auto text-dark text-decoration-none">
				<i class="fa-solid fa-house"></i>
				<span class="fs-4">Home</span>
			</a>
			<ul class="nav nav-pills">
				<li class="nav-item"><a href="./books.jsp" class="nav-link">도서 목록</a></li>
				<li class="nav-item"><a href="./addBook.jsp" class="nav-link">도서 등록</a></li>
				<li class="nav-item"><a href="./editBook.jsp?edit=update" class="nav-link">도서 수정</a></li>
				<li class="nav-item"><a href="./editBook.jsp?edit=delete" class="nav-link">도서 삭제</a></li>
				
			</ul>
		</div>
	</div>
</header>