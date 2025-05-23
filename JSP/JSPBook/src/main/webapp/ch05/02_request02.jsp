<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- %@ page import="java.util.Enumeration" %-->
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- %
		Enumeration en=request.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName = (String)en.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print(headerName + ":" + haderValue + "<br>");
		}
	%-->
	<%
		HashMap<String, String> data = (HashMap<String, String>)request.getAttribute("mapData");
		for(String key : data.keySet()){	//hashmap 속성
			String value = data.get(key);
			out.println("<p>"+key+": "+value+"</p>");
		}
	%>
	
	
</body>
</html>