<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js">
		</script>

<script typy="text/javascript">
			$(document).ready(function(){
				//ajax请求得到学生信息，并且显示所出
				showStu();
			});
			function showByTag(tag) {
				$("#addStu").css("display","none"); 
				$("#StuTable").css("display","none");
				$("#updateStu").css("display","none");
				$("#detailedGrade").css("display","none");
				$("#lookClazzGrade").css("display","none");
				$("#publishExamination").css("display","none");
				if(tag == "addStu") {
					$("#addStu").css("display","block"); 
				} else if(tag=="StuTable") {
					$("#StuTable").css("display","table");
				} else if(tag=="updateStu") {
					$("#updateStu").css("display","block");
				} else if(tag=="detailedGrade") {
					$("#detailedGrade").css("display","block");
				} else if(tag=="lookClazzGrade") {
					$("#lookClazzGrade").css("display","block");
				} else if(tag=="publishExamination") {
					$("#publishExamination").css("display","block");
				}
			}
			function deleteStu(Stuid) {
				$.ajax({
						type : "post",//请求的方式
						url : "deleStuById.do",//请求的url
						dataType : "text",//接收的数据类型声明
						data : {
							id:Stuid
						}, 
						success : function(inf) {
							if(inf=="yes"){
								showStu();
							}else{
								alert("刪除失败");
							}
						},
						error : function() {//当ajax请求失败回调
							alert("ajax请求失败")
						}
					});
			} 
			//ajax请求得到学生信息，并且显示所出
			function showStu() {
				//得到班级的clazzId
				$.ajax({
					type : "get",//请求的方式
					url : "getStuByClazzId.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						clazzId: ${ clazz.id}
					}, 
					success : function(stuList) {
						stuList = JSON.parse(stuList);
						var stuInf = "<tr><td>id</td><td>no</td><td>name</td><td>sex</td><td>pwd</td><td>删除</td><td>修改</td><td>详细信息</td></tr>";
						for(let i=0; i<stuList.length; i++) {
							var stu = stuList[i];
							stuInf += "<tr>";
						    stuInf += "<td>"+stu.id+"</td>";
							stuInf += "<td>"+stu.no+"</td>";
							stuInf += "<td>"+stu.name+"</td>";
							stuInf += "<td>"+stu.sex+"</td>";
							stuInf += "<td>"+stu.pwd+"</td>";
							stuInf += "<td class='a' onclick='deleteStu("+stu.id+");'>删除</td>";
							stuInf += "<td class='a' onclick='updateStu("+stu.id+",\""+stu.no+"\",\""+stu.name+"\",\""+stu.sex+"\",\""+stu.pwd+"\");'>修改</td>";
							stuInf += "<td class='a' onclick='detailedGrade("+stu.id+",\""+stu.name+"\");'>详细信息</td>";
							stuInf += "</tr>";
						}
						$("#StuTable").html(stuInf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			//点击搜索学生按钮
			function searchStuByKey() {
				showByTag("StuTable");
				$.ajax({
					type : "post",//请求的方式
					url : "selectBylike.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						key:$("#key").val(),
						clazzId: ${ clazz.id}
					}, 
					success : function(stuList) {
						stuList = JSON.parse(stuList);
						var stuInf = "<tr><td>id</td><td>no</td><td>name</td><td>sex</td><td>pwd</td><td>删除</td><td>修改</td><td>详细信息</td></tr>";
						for(let i=0; i<stuList.length; i++) {
							var stu = stuList[i];
							stuInf += "<tr>";
						    stuInf += "<td>"+stu.id+"</td>";
							stuInf += "<td>"+stu.no+"</td>";
							stuInf += "<td>"+stu.name+"</td>";
							stuInf += "<td>"+stu.sex+"</td>";
							stuInf += "<td>"+stu.pwd+"</td>";
							stuInf += "<td class='a' onclick='deleteStu("+stu.id+");'>删除</td>";
							stuInf += "<td class='a' onclick='updateStu("+stu.id+",\""+stu.no+"\",\""+stu.name+"\",\""+stu.sex+"\",\""+stu.pwd+"\");'>修改</td>";
							stuInf += "<td class='a' onclick='detailedGrade("+stu.id+",\""+stu.name+"\");'>详细信息</td>";
							stuInf += "</tr>";
						}
						$("#StuTable").html(stuInf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			//进入增加学生的界面 
			function addStu() {// 
				showByTag("addStu");
				var name=$("#stuName").val("");
				var no=$("#stuNo").val("");
				var sex=$("#stuSex").val("");
				var pwd=$("#stuPwd").val("");
			}
			
			//确定增加学生
			function sureAddStu() {//显示table
				showByTag("StuTable");
				//stuName,stuNo,stuSex,stuPwd
				
				var name=$("#stuName").val();
				var no=$("#stuNo").val();
				var sex=$("#stuSex").val();
				var pwd=$("#stuPwd").val();
				$.ajax({
					type : "post",//请求的方式
					url : "insertStu.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						name :name,
						no: no,
						sex: sex,
						pwd: pwd,
						clazzId: ${clazz.id}
					}, 
					success : function(inf) {
						if(inf=="yes"){
							 showStu();
						}else{
							alert("增加失败");
						}
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			
			//取消增加学生
			function cancleAddStu() {//显示table
				showByTag("StuTable");
			}
			function lookClazzGrade(){
				showByTag("lookClazzGrade");
			}
			//进入修改学生的界面
			function updateStu(oldStuId,oldStuNo,oldStuName,oldStuSex,oldStuPwd) {
				showByTag("updateStu");
				
				$("#oldStuId").val(oldStuId);
				$("#oldStuName").val(oldStuName);
				$("#oldStuNo").val(oldStuNo);
				$("#oldStuPwd").val(oldStuPwd);
				
				if(oldStuSex=="男"){
					$("input[name='oldStuSex']")[0].setAttribute("checked","checked");
				}else{
					$("input[name='oldStuSex']")[1].setAttribute("checked","checked");
				}
				
				//获取所有的班级的id和name,然后使用select显示出来
				$.ajax({
					type : "get",//请求的方式
					url : "getAllclazz.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {}, 
					success : function(clazzList) {
						clazzList = JSON.parse(clazzList);
						var clazzInf ="";
						for(let i=0; i<clazzList.length; i++) {
							var clazz = clazzList[i];
							clazzInf += "<option checked='true' value='"+clazz.id+"'>"+clazz.name+"</option>";
						}
						
						$('#clazzSelect').html(clazzInf);
						$("#clazzSelect>option[value='"+ ${clazz.id}+"']").attr("selected", true);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			//确定修改学生
			function sureUpdateStu() {
				showByTag("StuTable");
				//updateStu
				//获得要修改的数据
				var stuId=$("#oldStuId").val();
				var stuName =$("#oldStuName").val();
				var stuNo=$("#oldStuNo").val();
				var stuPwd = $("#oldStuPwd").val();
				var stuSex = $("input[name='oldStuSex']:checked").val();
				var clazzId = $("#clazzSelect").val();
				
				$.ajax({
					type : "post",//请求的方式
					url : "updateStu.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						id:stuId,
						name:stuName,
						no:stuNo,
						pwd:stuPwd,
						sex:stuSex,
						clazzId:clazzId
					}, 
					success : function(inf) {
						if(inf=="yes"){
							showStu();
						}else{
							alert("修改失败");
						}
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			
			//取消修改学生
			function cancleUpdateStu() {
				showByTag("StuTable");
			}
			
			//查看学生的成绩
			function detailedGrade(stuId,stuName) {
				showByTag("detailedGrade");
				$.ajax({
					type : "get",//请求的方式
					url : "getAllGrade.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						stuId:stuId
					}, 
					success : function(gradelist) {
						gradelist=JSON.parse(gradelist);
						var inf="<tr><td>学生名</td><td>考试名</td><td>分数</td><td>第几次</td></tr>";
						//<tr><td>学生名</td><td>考试名</td><td>分数</td><td>第几次</td></tr>
						for(let i=0;i<gradelist.length;i++){
							var grade=gradelist[i];
							inf += "<tr><td>"+stuName+"</td><td>"+grade.examinationName+"</td><td>"+grade.score+"</td><td>"+grade.times+"</td></tr>";
						}
						$("#stuGradeTable").html(inf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
		}
			
			//进入发布当前班级的一次考试
			function publishExamination() {
				showByTag("publishExamination");
				//查出当前班级是否正在进行的考试
				$.ajax({
					type : "get",//请求的方式
					url : "getExaminationName.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {
						clazzId: ${clazz.id}
					}, 
					success : function(examination) {
						 var inf;
						if(examination!="no"){//有正在进行的考试
							 inf = "正在对\""+examination+"\"进行考试，不能发布新考试";
							 $("#haveExamination").css("color","red");
							 $("#surePublishExaminationBtn").css("display", "none");	
							 $("#endExaminationBtn").css("display", "block");
							
						}else {//没有正在进行的考试
							 inf = "请发布考试";
							 $("#haveExamination").css("color","green");
							 $("#surePublishExaminationBtn").css("display", "block");	
							 $("#endExaminationBtn").css("display", "none");
						}
						$("#examinationName").html(examination); 
						$("#haveExamination").html(inf); 
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
				categoryDiv();
			}
			<!-- 确定发布考试 -->
			function surePublishExamination() {
				alert(1);
				var inputArray = $("#categoryDiv>input:checkbox:checked");
				var categoryIdArray = "{";//"{1,2,3,4}";
				for(let i=0; i<inputArray.length; i++) {
					var id = inputArray[i].value;
					if(i==inputArray.length-1) {//最后一个
						categoryIdArray += id+"}";
					}else {
						categoryIdArray += id+",";
					}
				}
				$.ajax({
					type : "post",//请求的方式
					url : "publishExamination.do",//请求的url
					dataType : "text",//
					data : {
						clazzId: ${clazz.id},//班级id
						examinationName:$("#examinationName").val(),
						subjectNum:	 $("input[name='subject_num']:checked").val(),
						teacherId: (JSON.parse(localStorage.getItem("teacher"))).id,
						category: categoryIdArray
					}, 
					success : function(msg) {
						alert(2);
						if(msg=="yes") {//发布考试成功
							alert(3);
							publishExamination();
						}else {
							alert("发布考试失败");							
						}
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
			function  categoryDiv() {
				$.ajax({
					type : "get",//请求的方式
					url : "getAllcategory.do",//请求的url
					dataType : "text",//接收的数据类型声明
					data : {}, 
					success : function(categorylist) {
						categorylist=JSON.parse(categorylist);
						var inf="题目类型有:";
						for(let i=0;i<categorylist.length;i++){
							var category=categorylist[i];
							inf+="<input type='checkbox' value="+category.id+">"+category.name;
						}
						$("#categoryDiv").html(inf);
					},
					error : function() {//当ajax请求失败回调
						alert("ajax请求失败")
					}
				});
			}
		</script>
</head>
<body>
	<div id="content">
		<div id="top">${clazz.id},${clazz.name }</div>
		<div id="middle">
			<div id="middle1">
				<input type="text" id="key" />
				<button onclick="searchStuByKey()">搜索学生</button>
				<button onclick="addStu()">增加学生</button>
				<button onclick="lookClazzGrade()">查看本班的成绩</button>
				<button onclick="publishExamination()">发布考试</button>
			</div>
			<div id="middle2">
				<table cellspacing='0' id="StuTable">

				</table>
				<div id="addStu" class="hiddenDiv">
					<h1 align="center">增加学生</h1>
					
					
					姓名:<input type="text" id="stuName" /><br /> 学号:<input type="text"
						id="stuNo" /><br /> 性别:<input type="text" id="stuSex" /><br />
					密码:<input type="text" id="stuPwd" /><br />  <a
						href="javascript: sureAddStu()">确定</a> <a
						href="javascript: cancleAddStu()">取消</a>
				</div>
				<div id="updateStu" class="hiddenDiv">
					<h1 align="center">修改学生</h1>
					<input type="text" id="oldStuId" value="+stu.id+"
						style="display: none" /><br /> 名字:<input type="text"
						id="oldStuName" value="秦可卿" /><br /> 学号:<input type="text"
						id="oldStuNo" value="007" /><br /> 密码:<input type="text"
						id="oldStuPwd" value="123456" /><br /> 性别:男<input type="radio"
						name="oldStuSex" value="男" checked="true" /> 女<input type="radio"
						name="oldStuSex" value="女" /><br /> 班级:<select id="clazzSelect">
					</select> <br /> <a href="javascript: sureUpdateStu()">确定</a> <a
						href="javascript: cancleUpdateStu()">取消</a>
				</div>
				<div id="detailedGrade" class="hiddenDiv">
					<table id="stuGradeTable">
						<tr>
							<td>学生名</td>
							<td>考试名</td>
							<td>分数</td>
							<td>第几次</td>
						</tr>

					</table>
				</div>
				<div id="lookClazzGrade" class="hiddenDiv">本班所有学生的所有成绩</div>
				<div id="publishExamination" class="hiddenDiv">
						<h1 id="haveExamination">正在对"java"进行考试，不能发布新考试</h1>
						<br /> 考试名:<input id="examinationName" type="text"
						value="spring测试" /> <br />
						题数:
						<input type="radio" name="subject_num" value="20" checked="true"/>20道题
						<input type="radio" name="subject_num" value="25"/>25道题
						<input type="radio" name="subject_num" value="40"/>40道题<br />
						<div id="categoryDiv">
							
						</div>
						<button id="surePublishExaminationBtn" onclick="surePublishExamination()">确认发布考试</button>
						<button id="endExaminationBtn" onclick="endExamination();">结束考试</button> 
						<br />
				</div>
			</div>
		</div>
	</div>
</body>
<script src="base.js" type="text/javascript" charset="utf-8"></script>
<style>
body {
	font-size: 1rem;
}

input[type='radio'] {
			width: 1rem;
			height: 1rem;
		}
input[type='checkbox'] {
			width: 1rem;
			height: 1rem;
		}
#detailedGrade {
	background-color: silver;
	font-size: 1rem;
}

.hiddenDiv {
	height: 40rem;
	background: paleturquoise;
	width: 100%;
	display: none;
	font-size: 2rem;
}

#updateStu {
	height: 40rem;
	background: paleturquoise;
	width: 100%;
	display: none;
	font-size: 2rem;
}

#addStu {
	height: 40rem;
	background: paleturquoise;
	width: 100%;
	display: none;
	font-size: 2rem;
}

.a:hover {
	background: palegoldenrod;
	cursor: pointer
}

tr:hover {
	background: #EEEEEE;
}

tr:first-child {
	background-color: pink;
	font-size: 2rem;
}

th, td {
	text-align: center;
	padding-top: 1rem;
	padding-bottom: 1rem;
	color: orange;
}

table {
	width: 100%;
	display: table;
}

table, th, td {
	border: 1px solid black;
}

#middle1>* {
	margin: 1rem;
}

#middle1 {
	width: 80rem;
	background: green;
}

#middle {
	width: 80rem;
	min-height: 40rem;
	background: gray;
}

#top {
	width: 80rem;
	height: 10rem;
	background: palegoldenrod;
	font-size: 5rem;
	text-align: center;
	line-height: 10rem;
	//
	文字的行高
}

#content {
	width: 80rem;
	min-height: 50rem;
	background: pink;
	margin: 0 auto;
}
</style>
</html>
