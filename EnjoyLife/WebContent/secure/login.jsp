<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="" />

<title>Login</title>
</head>
<body>

<h3>Login</h3>

<form action="<c:url value="/secure/login.do" />" method="post">
<table>
	<tr>
		<td>ID : </td>
		<td><input type="text" name="memberId" value="${param.memberId}"></td>
		<td>${error.username}</td>
	</tr>
	<tr>
		<td>PWD : </td>
		<td><input type="password" name="password" value="${param.password}"></td>
		<td>${error.password}</td>
	</tr>
	<tr>
		<td>自動登入：</td>
		<td><input type="checkbox" name="login" value="auto" checked="checked"></td>
     </tr>
     <tr>
        <TD align="CENTER" colspan='3'><Font size="-1">${error.LoginError}&nbsp;</Font></TD>             
    </tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="Login"></td>
	</tr>
</table>
<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
</form>

</body>
</html>