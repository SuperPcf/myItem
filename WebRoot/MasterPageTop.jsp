<%@page language="java" contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>
<html>
<head>



<title>江西微软技术中心实训考勤系统</title>

<style type="text/css">
html {
	height: 100%;
	overflow: hidden;
}

body {
	background: #4acf9a;
	height: 100%;
}

.top,.left,.right,.bottom {
	background: #b6ff00;
	position: absolute;
}

.top {
	height: 70px;
	left: 10px;
	top: 10px;
	right: 10px;
}

.left {
	width: 300px;
	left: 10px;
	top: 90px;
	bottom: 90px;
}

.right {
	left: 320px;
	right: 10px;
	top: 90px;
	bottom: 90px;
/* 	overflow:scroll; /*任何时候都强制显示滚动条*/ */
	overflow:auto; /*需要的时候会出现滚动条*/
	overflow-x:auto; /*控制X方向的滚动条*/
	overflow-y:auto; 
}

.bottom {
	height: 70px;
	left: 10px;
	right: 10px;
	bottom: 10px;
}
</style>

<!--[if IE 6]>

<style type="text/css">

html{ padding:90px 10px;}

.top,.left,.right,.bottom{ position:relative; top:0; right:0; bottom:0; left:0;}

.top{margin-top:-80px;}

.left{height:100%;margin-top:10px; float:left;}

.right{height:100%; margin:10px 0 0 320px;}

.bottom{margin-top:10px;}

</style>

<![endif]-->



</head>

<body>

	<div class="top"
		>
		<center>
			<font size="7" color="blue"><b>江西微软技术中心实训考勤系统</b></font>
		</center>
	</div>
	<div class="left">

		<ul class="left_ul">
			<li>班级信息管理
				<ul>
					<li><a href="ClazzList"> 查看班级信息</a></li>
					<li><a href="ClazzAdd.jsp"> 添加班级信息</a></li>
					
				</ul>
			</li>
			<li>学生信息管理
				<ul>
					<li><a href="#"> 查看学生信息</a></li>
					<li><a href="#"> 添加学生信息</a></li>
					
				</ul>
			</li>
			<li>考勤管理
				<ul>
					<li><a href="#">查看考勤信息</a></li>
					<li><a href="#"> 添加考勤信息</a></li>
					
				</ul>
			</li>

		</ul>




	</div>
	<div class="right"
		style="background-image: url('images/top.png');background-size:contain;">
	<center>
	