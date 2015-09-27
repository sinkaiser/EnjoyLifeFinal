<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
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

<title>訊息首頁</title>
</head>
<body>
	<div class="img">
 		 <a  href="${pageContext.request.contextPath}/message/writeMessage.jsp">
    		<img src="${pageContext.request.contextPath}/images/admessage.jpg" alt="傳送訊息" width="110" height="90">
  		</a>
  			<div class="desc">傳送訊息</div>
	</div>
	<div class="img">
  		<a  href="${pageContext.request.contextPath}/message/selectMessageAll.do">
    		<img src="${pageContext.request.contextPath}/images/addMessage.png" alt="查詢訊息" width="110" height="90">
  		</a>
  			<div class="desc">查詢訊息</div>
	</div>
	<div class="img">
  		<a  href="${pageContext.request.contextPath}/message/selectMessage.do">
    		<img src="${pageContext.request.contextPath}/images/iMess.jpeg" alt="寄件備份" width="110" height="90">
  		</a>
  			<div class="desc">寄件備份</div>
	</div>
	<a href="${pageContext.request.contextPath}/message/writeMessage.jsp">傳送訊息</a><br>
	<a href="${pageContext.request.contextPath}/message/selectMessageAll.do">查詢訊息</a><br>
	<a href="${pageContext.request.contextPath}/message/selectMessage.do">寄件備份</a><br>
	<a href="${pageContext.request.contextPath}/index.jsp">首頁</a>		
</body>
</html>