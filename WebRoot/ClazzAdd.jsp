<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@include file="MasterPageTop.jsp" %>



    <h1>添加班级信息</h1>
    <form action="ClazzAddDo" method="post">
	          班级代码:<input type="text" name="clazzCode"/><br/>
	   
	           班级名称:<input type="text" name="clazzName"/><br/>
	    <input type="submit" value="提交"/>
	    <input type="reset" value="重置"/>
    </form>
 
 
<%@include file="MasterPageBotton.jsp" %>
<!-- Run:	http://localhost:8080/Model2/CLazzAdd.jsp	 -->
