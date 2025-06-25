<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!-- case 1: html -->
	<h3>simple AJAX test case 1</h3>
	<button id="b1">test case 1</button>
	<div id="result1"></div>
	
	<!-- case 1 JS -->
	<script type="text/javascript">
		var btn = document.querySelector("#b1");
		console.log(btn);
		
		btn.addEventListener("click", case1);
		
		var obj={"name":"kim", "age":"30"};
		
		function case1(){
			console.log("case1");
			$.ajax(
					{
						url: "case1",
						type: "post",
						data: JSON.stringify(obj),
						contentType: "application/json",
						success: function(data){
							alert("success");
							$("#result1").text("response: " + data);
						},
						error: function(errorThrown){
							alert("fail");
						}
					}
			);	
		}
	</script>
	
	
	<!-- case 2: html -->
	<h3>simple AJAX test case 2</h3>
	id: <input type="text" id="text2">
	<button id="b2" >test case 2</button>
	<div id="result2"></div>
	
	<!-- case 2: JS -->
	<script type="text/javascript">
		var btn2 = document.querySelector("#b2");
		console.log(btn2);
		
		btn2.addEventListener("click", case2);
		
		function case2(){
			var inputdata = document.querySelector("#text2").value;
			$.ajax(
				{
					url: "case2",
					type: "post",
					data: JSON.stringify({id:inputdata}),
					contentType: "application/json",
					success: function(data){
						alert(JSON.stringify(data));
						$(result2).text("response: " + data.id);
					},
					error: function(errorThrown){
						alert("fail");
					}
				}		
			);
			
		}
	</script>
	
	
	<!-- case 3: html -->
	<h3>simple AJAX test case 3</h3>
	id: <input type="text" id="text3">
	<button id="b3" >test case 3</button>
	<div id="result3"></div>
	
	<!-- case 3 JS -->
	<script>
		var btn3 = document.querySelector("#b3");
		console.log(btn3);
		btn3.addEventListener("click", case3);
		
		function case3(){
			console.log("case3");
			var inputdata = document.querySelector("#text3").value;
			console.log(inputdata);
			
			$.ajax(
			{
				url: "case3",
				type: "post",
				data: JSON.stringify({id:inputdata}),
				contentType: "application/json",
				success: function(data){
					alert(JSON.stringify(data));
					$("#result3").empty();
					$("#result3").select();
					$.each(data, 
							function(i, dto){
								$("#result3").append("<li>" + dto.id);
							}
					);
				},
				error: function(errorThrown){
					alert("fail");
				}
			}		
			);
			
		}
		
	</script>
</body>
</html>