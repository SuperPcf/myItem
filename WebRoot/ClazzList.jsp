<%@ page language="java" import="java.util.*,edu.model2.bean.*"
	contentType="text/html;charset=utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="MasterPageTop.jsp"%>



<h1>班级信息</h1>
<hr />
<a href="ClazzAdd.jsp">添加班级信息</a>
<table>
	<tr>
		<th></th>
		<th>班级编号：</th>
		<th>班级名称：</th>
		<th>操作:</th>

	</tr>
	<c:forEach items="${clazzList}" var="clazz" varStatus="st">
		<tr>
			<td><input type="checkbox" name="${clazz.clazzId}">
			</td>
			<td>${clazz.clazzCode}</td>
			<td>${clazz.clazzName}</td>
			<td><a href="ClazzEdit?clazzId=${clazz.clazzId}">编辑</a>&nbsp;&nbsp;
				<a href="ClazzDelete?clazzId=${clazz.clazzId}">删除</a>
			</td>
		</tr>
	</c:forEach>
</table>

<%@include file="MasterPageBotton.jsp"%>
