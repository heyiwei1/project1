<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript">

function test_(){
	//将原生的js转换为jquery的js -- 只需要在外围加上s
	var test = document.getElementById("test").value;
	var testJquery = $(document.getElementById("test")).val();
	alert(testJquery)
	
	//将jquery 的js转换为原生的js 是加上gey(0)
	var jqueryTest = $("#test").val();
	var testJs=$("#test").get(0).value;
	alert(testJs);
}
</script>
</head>
<body>
	<input type="text" value="123" id="test">
	<input type= "button" value="测试" onclick="test_()">
</body>
</html>
	<!-- <script >
		
	</script>
 -->