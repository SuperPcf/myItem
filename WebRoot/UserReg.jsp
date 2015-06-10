<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="MasterPageTop.jsp"%>
<h1>User Register</h1>
<hr />
<form action="UserRegDo" method="post">
	User Account:<input type="text" name="userAccount"
		value="${user.userAccount}" /><br /> User Key:<input type="password"
		name="userKey" value="${user.userKey}" /><br /> User Email:<input
		type="text" name="userEmail" value="${user.userEmail}" /><br /> <input
		type="submit" value="Submit" /><br> <input type="reset"
		value="Reset" /> <span>${errMsg}</span>
</form>

<%@ include file="MasterPageBotton.jsp"%>