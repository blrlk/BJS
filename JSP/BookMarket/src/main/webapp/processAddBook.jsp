<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.Book" %>
<%@ page import="dao.BookRepository" %>
<%@ page import="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.*" %>
<%@ page import="java.lang.reflect.Method" %>
<%@ page import="java.util.*" %>

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
	
	//price와 stock의 정수 변환 검사
	System.out.println(price  + ", " +  stock);
	
	Book newBook = new Book();
	newBook.setBookId(bookId);
	newBook.setName(name);
	newBook.setUnitPrice(price);
	newBook.setAuthor(author);
	newBook.setPublisher(publisher);
	newBook.setReleaseDate(releaseDate);
	newBook.setDescription(description);
	newBook.setCategory(category);
	newBook.setUnitsInStock(stock);
	newBook.setCondition(condition);
	newBook.setFilename(fileName);
	
	//전처리 마지막 묶음 검증 :: 객체 print 하면 주소가 나오니까 해당 클래스에 toString() 함수 생성 해주어야 함 -> toString() 자동 실행
	System.out.println(newBook);
	
	//repository 객체 받기
	BookRepository dao = BookRepository.getInstance();
	//dao 클래스 내부의 메소드를 가져와 하나씩 출력
	for(Method m : dao.getClass().getMethods()){
		System.out.println(m.getName());
	}
	
	//dto 들고 dao 이동
	dao.addBook(newBook);
	System.out.println("저장 완료");
	
	response.sendRedirect("books.jsp");
%>