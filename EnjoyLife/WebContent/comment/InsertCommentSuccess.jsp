<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lab04_02</title>
</head>
<body> 
<H1>會員 ${ partnerBean.memberId } 的資料新增成功</H1>
<fmt:formatDate value="${partnerBean.commentDate}" var="formattedDate" type="date" pattern="yyyy年M月d日 H:mm" />				
日期: ${formattedDate}<BR>
留言編號: ${ partnerBean.commentNo }<BR>
內文: ${ partnerBean.commentContent }<BR>
被檢舉事件編號: ${ partnerBean.eventNo}<BR>
</body>
</html>