<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>My JSP 'login.jsp' starting page</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="UTF-8">
<style type="text/css">
	.myth {
		border: 1px solid black;
		color: red;
		font-size: 20px;
		margin-left: 100px;
		margin-top: 100px;
	}
	.myth1 {
		border: 1px solid black;
		color: red;
		font-size: 20px;
		margin-left: 100px;
		
	}
	.myth td{
		border: 1px solid black;
	}
	.myth1 td{
		border: 1px solid black;
	}
</style>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript">

	$(function(){
		$(".ajaxcha").click(function(){
    		alert(111);
    		var  srtt = $("#ajaxchad").val();
    		alert(srtt),
    		$.ajax({
    			url:"ajaxloginPage",
    			type:"post",
    			data:{name:srtt,pad:"111"},
    			dataType:"json",
   
    			success:function(reult){
    				alert(reult.username);
    			
    				 for (var i = 0; i < reult.length; i++) {
    					alert(reult[i].id)
    					alert(reult[i].username)
					}
    			}
    		});
    	});
	});
	
	
</script>
</head>
  <body>

  	<form action="" >
  		<input id="ajaxchad"  type="text" name="username"  value="">
  		<input class="ajaxcha" type="button"   value="查询">
  	</form>
  	<table style="margin-top: 20px" class="table table-striped table-bordered table-hover 
		">
			<thead>
				<tr>
					<td >家庭</td>
					<td >家庭id</td>
				</tr>
			</thead>
		
			<tbody >
				<c:forEach items="${pageAll.getList()}" var="i">
					<tr>
						<td>${i.familyname}</td>
						<td>${i.family_id }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
  
  </body>
</html>
