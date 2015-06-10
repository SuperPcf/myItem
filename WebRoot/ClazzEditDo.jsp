<%@ page language="java" import="java.util.*,edu.model2.bean.*"
	contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="MasterPageTop.jsp"%>



<h1>班级信息</h1>
<hr />

<div>

	<fieldset>
		<legend>修改班级信息</legend>

		<form action="ClazzEditDo" method="post">
		
			<input type="hidden" name="clazzId" value="${clazz.getClazzId()}" />
			班级名称:<input type="text" name="clazzName" value="${clazz.getClazzName()}" /><br />
			 班级编号：<input type="text"  name="clazzCode" value="${clazz.getClazzCode()}" /><br>
		 <input type="submit" value="确定" /> 
		 <input type="reset" value="重置" />
		</form>

	</fieldset>
</div>

<%@include file="MasterPageBotton.jsp"%>
