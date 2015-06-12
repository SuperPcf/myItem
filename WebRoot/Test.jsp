<%@ page language="java" import="java.util.*,edu.model2.filter.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Test.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body><div align="right"> 
	This is my JSP page. Test Ip. 
	<br></div>
	<iframe src="http://whois.pconline.com.cn/ipJson.jsp" width="20%"
		height="50%"> 脚本之家使用了框架技术，但是您的浏览器不支持框架，请升级您的浏览器以便正常访问脚本之家。 </iframe>
<%out.print(IPFilter.getIpAddr((HttpServletRequest)request));%>
</body>
</html>
