<%@page language="java" import="java.util.*,java.lang.*"
	contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

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
		style="background-image: url('images/南航.jpg');background-size:contain;">

		<div>
			<center>
				<font size="6" color="blue"><b>江西微软技术中心实训考勤系统</b> </font>
			</center>
		</div>
		<div id="top_bottom_left">
			<%="当前时间为：" + new Date().toLocaleString()
					+ "&nbsp&nbsp&nbsp"%>
			<font size="2" color="#00f">欢迎您！${sessionScope.userName} </font>
		</div>


	</div>
	<div class="left">

		<div>
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


	</div>

	<div class="right"
		style="background-image: url('images/long.jpg');background-size:contain;">


	</div>

	<div class="bottom"
		style="background-image: url('images/2.jpg');background-size:contain;">

	</div>

</body>

</html>