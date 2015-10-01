<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
div.img {
    margin: 5px;
    padding: 5px;
    border: 1px solid #0000ff;
    height: auto;
    width: auto;
    float: left;
    text-align: center;
div.img img {
    display: inline;
    margin: 5px;
    border: 1px solid #ffffff;
}
div.img a:hover img {
    border:1px solid #0000ff;
}

div.desc {
    text-align: center;
    font-weight: normal;
    width: 120px;
    margin: 5px;
}
}
</style>
</head>
<body>
	<c:if test="${!empty addSuccess }">
	<c:remove var="addSuccess" scope="session" />
	<script type="text/javascript">
		alert("申請成功");
	</script>
	
	</c:if>
	<div class="img">
 		 <a  href="${pageContext.request.contextPath}/friend/addFriend.jsp">
    		<img src="${pageContext.request.contextPath}/images/addFriend.jpg" alt="新增好友" width="110" height="90">
  		</a>
  			<div class="desc">新增好友</div>
	</div>
	<div class="img">
  		<a  href="${pageContext.request.contextPath}/friend/selectFriend.do">
    		<img src="${pageContext.request.contextPath}/images/friend.jpg" alt="查詢好友" width="110" height="90">
  		</a>
  			<div class="desc">查詢好友</div>
	</div>
	<div class="img">
  		<a  href="${pageContext.request.contextPath}/friend/deleteFriend.jsp">
    		<img src="${pageContext.request.contextPath}/images/delete.jpg" alt="刪除好友" width="110" height="90">
  		</a>
  			<div class="desc">刪除好友</div>
	</div>
<%-- 	<a href="${pageContext.request.contextPath}/friend/addFriend.jsp">新增好友</a><br> --%>
<%-- 	<a href="${pageContext.request.contextPath}/friend/selectFriend.do">查詢好友</a><br> --%>
<%-- 	<a href="${pageContext.request.contextPath}/friend/deleteFriend.jsp">刪除好友</a><br> --%>
<%-- 	<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a> --%>
</body>
</html>