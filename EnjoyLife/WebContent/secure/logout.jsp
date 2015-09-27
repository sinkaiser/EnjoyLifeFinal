<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:remove var="user"/>
<%
  session.invalidate();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登出</title>
</head>
<body>
您已經登出<P/>
<!-- 
<a href="../index.jsp">回首頁</a>
 -->
<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
</body>
</html>