<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<%@ page import="dao.BookRepository" %>
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>

<%@ include file="dbconn.jsp" %>
<% 
	System.out.println("Step1. processAddBook.jsp 입장");
	//입장
	//전처리: 전달된 데이터 받음, 유효성 검사, 묶음
	request.setCharacterEncoding("UTF-8");
	
	String filename="";
	String realFolder = "D:\\BJS\\JSP\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\BookMarket\\resources\\images";
	int maxSize=5*1024*1024;
	String encType="utf-8";
	
	MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
	
	String bookId = multi.getParameter("bookId");
	String name = multi.getParameter("name");
	String unitPrice = multi.getParameter("unitPrice");
	String author = multi.getParameter("author");
	String publisher = multi.getParameter("publisher");
	String releaseDate = multi.getParameter("releaseDate");
	String description = multi.getParameter("description");
	String category = multi.getParameter("category");
	String unitsInStock = multi.getParameter("unitsInStock");
	String condition = multi.getParameter("condition");
	
	Enumeration files = multi.getFileNames();
	String fname = (String) files.nextElement();
	String fileName = multi.getFilesystemName(fname);
	
	//전달 데이터 검사
	System.out.println(bookId + ", " + name + ", " + unitPrice + ", " + author + ", " + publisher + ", " + releaseDate + ", " + description + ", " + category + ", " + unitsInStock + ", " + condition);
	
	int price;
	
	if(unitPrice.isEmpty()){
		price=0;
	} else{
		price = Integer.valueOf(unitPrice);
	}
	
	long stock;
	
	if(unitsInStock.isEmpty()){
		stock=0;
	} else{
		stock = Integer.valueOf(unitsInStock);
	}
	
	PreparedStatement pstmt = null;
	String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, bookId);
	pstmt.setString(2, name);
	pstmt.setInt(3, price);
	pstmt.setString(4, author);
	pstmt.setString(5, description);
	pstmt.setString(6, publisher);
	pstmt.setString(7, category);
	pstmt.setLong(8, stock);
	pstmt.setString(9, releaseDate);
	pstmt.setString(10, condition);
	pstmt.setString(11, fileName);
	
	if(pstmt!=null){
		pstmt.close();
	}
	if(conn!=null){
		conn.close();
	}
	
	System.out.println("저장 완료");
	
	response.sendRedirect("books.jsp");
%>