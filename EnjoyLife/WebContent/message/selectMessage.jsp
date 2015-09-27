<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- <title>主旨：${message.messageTitle}</title> --%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover" style="margin: 10px;width: 500px">
	<thead>
		<tr><th>寄件備份</th></tr>
		<tr>
			<th>收件人</th>
			<th>信件主旨</th>
<!-- 			<th>信件內容</th> -->
			<th>發送時間</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="row" items="${message}">
			<c:if test="${row.showMessage==0}">
				<tr>
					<td>${row.messageTo}</td>
					<td><a name="${row.messageNo}" data-toggle="modal" data-target=".bs-example-modal-sm">${row.messageTitle}</td>
<%-- 					<td>${row.message}</td> --%>
					<fmt:formatDate value="${row.talkDate}" var="formattedDate" type="date" pattern="yyyy年M月d日 H:mm" />
					<td>${formattedDate}</td>
					<td><a href="${pageContext.request.contextPath}/message/updateMessage1.do?mid=${row.messageNo}"/> <input class="btn btn-primary btn-xs" type="button" value="刪除訊息"></a></td>
				</tr>	
			</c:if>	
		</c:forEach>							
	</tbody>	
</table>
<!-- Small modal -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div id='no' ></div>
    </div>
  </div>
</div>
<script>
$('a[data-toggle="modal"]').click(function(){
	var aa=$(this).attr("name");	
	$('div[id="no"]').empty();	
// 	console.log(aa);
	$.getJSON("${pageContext.request.contextPath}/GetMessageJson",{"no":aa},function(data){
// 		console.log(data[0]);
		var MessageFrom=data[0].MessageFrom;
		var MessageTo=data[0].MessageTo;
		var MessageTitle=data[0].MessageTitle;
		var TalkDate=data[0].TalkDate;
		var Message=data[0].Message;		
			$('div[id="no"]').append("<table class='table table-hover'><tr><td><h3>收件人:"+MessageTo+"</h3></td></tr>"+"<tr><td><h3>主旨:"+MessageTitle+"</h3></td></tr>"+"<tr><td><h3>訊息內容:"+Message+"</h3></td></tr>"+"<tr><td><h3>訊息時間:"+TalkDate+"</h3></td></tr></table>");				
	});
	
})
</script>
<a href="${pageContext.request.contextPath}/message/message.jsp">訊息首頁</a>
</html>