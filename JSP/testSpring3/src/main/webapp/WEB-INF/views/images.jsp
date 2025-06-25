<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이미지</h1>
	<img src="resources/images/${img}" />
	<!-- 
		별도의 수신 코드 없이 바로 데이터 사용 가능
		- Model/ModelMap	ex) model.addAttribute("msg", "hello");
		- ModelAndView
		- @RequestParam	:: 변수(값) 단위, 변수 앞 사용	ex) public String a(@RequestParam String name){}
		- @ModelAttribute	:: 객체 단위, 객체 앞 사용	ex) public String b(@ModelAttribute User user){} 
		- request.setAttribute()	ex) request.setAttribute("msg", "hello");
		- @SessionAttributes()	:: 클래스 앞, 내부에 ModelAttribute와 함께 사용	ex) @SessionAttributes("user")\n public class UserController{} -> user라는 이름으로 Model에 등록된 객체를 세션에도 자동 저장
	-->
</body>
</html>