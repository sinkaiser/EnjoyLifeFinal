<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% request.getSession().getAttribute("bloglist") ;%>
	<c:if test="${bloglist.size() == 0}"><br><h3>此類型沒有任何文章</h3></c:if>
	<c:forEach var="lists" items="${bloglist}">
		<div style="border:2px solid black">
			<img class="blogImg" src="${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=T&&pathImg=${lists.pathPhoto}">
			<p>日誌編號 :${lists.postNo}</p>
			<p>會員編號 :${lists.memberId}</p>
			<p>日誌標題 :${lists.postTitle}</p>
			<p>瀏覽人數:${lists.viewTotal}</p>
			<fmt:formatDate value="${lists.postDate}" var="formattedDate" type="date" pattern="yyyy年MM月dd日 HH:mm" />		
		</div>
	</c:forEach>
	
	<% request.getSession().getAttribute("parterlist") ; %>
	<c:if test="${parterlist.size() == 0}"><br><h3>此類型沒有任何文章</h3></c:if>
	<c:forEach var="list2" items="${parterlist}">
		<div style="border:2px solid black">
			<img src="${pageContext.request.contextPath}/GetImg?imgid=${list2.imgNo}">
			<p>事件編號:${list2.eventNo}</p>
			<p>會員編號:${list2.memberId}</p>
			<p>事件內容:${list2.eventContent}</p>
		</div>
	</c:forEach>
	
	<% request.getSession().removeAttribute("bloglist"); %>
	<% request.getSession().removeAttribute("parterlist") ;%>
</body>
</html>