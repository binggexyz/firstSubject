<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
</script>
<script type="text/javascript">
	$(document).ready(function(){
		showStues();
	});
	function showStues() {
		$("#stuDiv").html("数据正在加载中...");
		$.ajax({
			type : "get",//请求的方式 ("get")
			url : "getAllStu",//请求的url
			dataType : "text",//接收的数据类型声明
			data : {},//发送请求参数
			success : function(list) {//当ajax成功返回后回调
				//
				list = JSON.parse(list);
				var stuInf = "<table border='1'>";
				stuInf += "<tr><th>id</th><th>name</th><th>sex</th><th>age</th></tr>";
				for(let i=0;i<list.length; i++) {
					var stu = list[i];
					stuInf += "<tr><td>"+stu.id+"</td><td>"+stu.name+"</td><td>"+stu.sex+"</td><td>"+stu.age+"</td></tr>";
				}
				stuInf += "</table>";
				$("#stuDiv").html(stuInf);
			},
			error : function() {//当ajax请求失败回调
				alert("ajax请求失败")
			}
		});
	}
</script>
</head>
<body>
	<h1 algin="center">这是index.jsp</h1>
	<div id="stuDiv">
	</div>
</body>
</html>













