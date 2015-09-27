<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>好友名單</title>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover" style="margin: 10px;width: 500px">
	<thead>
	<tr>
		<td></td><th>好友列表</th><td></td>
<!-- 		<th>好友</th> -->
		
	</tr>
	</thead>
	<tbody>	
<!-- 		<tr><td></td><td>好友名單</td><tr> -->
		<c:forEach var="row" items="${selectFriend}">
			<c:if test="${row.FriendVO.unfriend==2}">
				<tr>
					<td width="50">
					<img src="${pageContext.request.contextPath}/GetImg?imgid=${row.Picture}" height="30" width="30"  onerror="this.style.display='none'">
					</td>
					<td>${row.FriendVO.friendId}</td>
					<td><a href="${pageContext.request.contextPath}/friend/deleteFriend.do?id=${row.FriendVO.friendId}"/> <input type="button" class="btn btn-primary btn-xs" value="刪除好友"></a></td>
				</tr>
			</c:if>	
		</c:forEach>
		
		<tr><td></td><th>申請中好友</th><td></td></tr>
		<c:forEach var="row" items="${selectFriend}">
			<c:if test="${row.FriendVO.unfriend==0}">
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/GetImg?imgid=${row.Picture}" height="30" width="30"  onerror="this.style.display='none'">
					</td>
					<td>${row.FriendVO.friendId}</td>
					<td><a href="${pageContext.request.contextPath}/friend/deleteFriend.do?id=${row.FriendVO.friendId}"/> <input type="button" class="btn btn-primary btn-xs" value="取消申請"></a></td>					
				</tr>
			</c:if>	
		</c:forEach>
		
		<tr><td></td><th>好友邀請確認</th><td></td></tr>
		<c:forEach var="row" items="${selectFriend}">
			<c:if test="${row.FriendVO.unfriend==1}">
				<tr>
					<td>
					<img src="${pageContext.request.contextPath}/GetImg?imgid=${row.Picture}" height="30" width="30" onerror="this.style.display='none'">
					</td>
					<td>${row.FriendVO.friendId}</td>					
					<td><a href="${pageContext.request.contextPath}/friend/updateFriend.do?id=${row.FriendVO.friendId}"/> <input type="button" class="btn btn-primary btn-xs" value="確認"></a></td>
				</tr>
			</c:if>	
		</c:forEach>							
	</tbody>	
</table>
<a href="${pageContext.request.contextPath}/friend/friend.jsp">好友首頁</a>
</body>
</html>