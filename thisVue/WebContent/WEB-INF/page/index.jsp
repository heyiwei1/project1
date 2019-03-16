<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta charset="UTF-8">
	<!-- 
		Bootstrap不再兼容老版本的IE浏览器。
		为了让IE浏览器运行最新的渲染模式，
		建议将此 <meta>标签加入到页面中 。
	-->
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<!-- 
		viewport:浏览器窗口设置声明
		width=device-width:内容宽度和设备宽度一致
		initial-scale=1:初始缩放100%
		maximum-scale=1:最大缩放100%
		user-scalable=no:禁止用户缩放 
	-->
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<!-- 将网页放入移动设备中，能够有更好的显示效果 -->
			
	<meta name="content-type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="../js/vue.js"></script>
	<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>

	<link rel="stylesheet" href="../bootstrap/css/bootstrap.css">

 
<style type="text/css">
	.tab-h2 {
	
		color:#0059b2;
		
		font-size:20px;
		
		letter-spacing: 1px;
		
		text-align:center;
		
		margin:45px 0 10px;
	
	}
	
	.tab-p {
	
		font-size: 15px;
		
		letter-spacing: 2px;
		
		text-align:center;
		
		color: #999;
		
		margin:15px 0 45px;
	
	}
</style>
<script type="text/javascript" src="../js/jquery-1.11.3.js"></script>
<script type="text/javascript">

	
</script>
</head>
  <body >
  	<div class="container" style="padding: 30px 100px;">
	  	<div class="row col-lg-12 col-xs-12 col-sm-12 content">
	  		<form action="loginPage">
	  			
	  			<input class="col-lg-5 col-xs-5 col-sm-5 visible-lg"  type="text" name="username"  class="form-control" placeholder="文本输入"/>
	  			<input class="col-lg-5 col-xs-5 col-sm-5 visible-xs visible-sm visible-md"  type="text" name="username" style="font-size: 10px"  class="form-control" placeholder="文本输入"/>
	  			<input class="col-lg-1 col-xs-1 col-sm-1 visible-xs visible-sm visible-md" style="width: 80px ;font-size: 10px" type="submit" class="btn" name="查询"/>
	  			<input class="col-lg-1 col-xs-1 col-sm-1 visible-lg" style="width: 150px" type="submit" class="btn" name="查询"/>
	  		</form>
	  	</div>
  			
				<table class="table table-striped table-bordered table-hover"  style="margin-top: 20px" >
					<thead >
						<tr >
							<td >家庭</td>
							<td >家庭id</td>
						</tr>
					</thead>
				
					<tbody >
						<c:forEach items="${pageAll.getList()}" var="i">
							<tr >
								<td>${i.familyname}</td>
								<td >${i.family_id }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div  class="row col-lg-12 col-xs-12 col-sm-12">${navigateBar}</div>
		
	
	</div>
	<div class="content" style="padding: 30px 100px;">
		<div class="hidden-xs">超小型设备</div>
		<div class="visible-xs" style="color:red;">超小型设备可见</div>
		<div class="hidden-sm">小型设备</div>
		<div class="visible-sm" style="color:red;">小型设备可见</div>
		<div class="hidden-md">中型设备</div>
		<div class="visible-md" style="color:red;">中型设备可见</div>
		<div class="hidden-lg">大型设备</div>
		<div class="visible-lg" style="color:red;">大型设备可见</div>
	</div>
	<!--自适应文字大小  -->
	<div class="container">
		<h2 class="tab-h2">「这里测试文字自适应」</h2>
		<p class="tab-p">这里测试文字自适应，这里测试文字自适应，这里测试文字自适应！</p>
	</div>
	
	<div id = "div1">
		<h1>{{num}}</h1>
	</div>
	
	
	<table class="table table-striped table-bordered table-hover"  style="margin-top: 20px" >
			<thead >
				<tr >
					<td >家庭</td>
					<td >家庭id</td>
				</tr>
			</thead>
		
			<tbody  v-for="i in num">
				<tr>
					<td>{{i.family_id}}</td>
				</tr>
			</tbody>
	</table>
	<script type="text/javascript">
		var ve = new Vue({
			el:'#div1',
			data:{
				num:'${pageAll.getList()}',
			}
		
		});
	</script>
  </body>
</html>
