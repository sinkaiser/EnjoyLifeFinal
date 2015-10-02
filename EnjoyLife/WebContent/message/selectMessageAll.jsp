<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<table class="table table-hover" style="margin: 10px;width: 650px">
	<thead>
		<tr><th>收件夾</th></tr>
		<tr>
			<th>大頭照</th>
			<th>帳號</th>
			<th>寄件人</th>
			<th>信件主旨</th>
<!-- 			<th>信件內容</th> -->
			<th>發送時間</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach var="row" items="${Message}">
			<c:if test="${row.MessageVO.unMessage==0}">
				<tr>
					<td><img src="${pageContext.request.contextPath}/GetImg?imgid=${row.MemberVO.picture}" height="35" width="35" "></td>
					<td>${row.MessageVO.messageFrom}</td>
					<td>${row.MemberVO.memberName}</td>
					<td><a name="${row.MessageVO.messageNo}" data-toggle="modal" data-target=".bs-example-modal-sm">${row.MessageVO.messageTitle}</a></td>
<%-- 					<td>${row.message}</td> --%>
					<fmt:formatDate value="${row.MessageVO.talkDate}" var="formattedDate" type="date" pattern="yyyy年M月d日 H:mm" />
					<td>${formattedDate}</td>
<%-- 					<td><a href="${pageContext.request.contextPath}/message/updateMessage2.do?mid=${row.MessageVO.messageNo}"/> <input class="btn btn-primary btn-xs" type="button" value="刪除訊息"></a></td> --%>
					<td><button type="button" class="btn btn-primary btn-xs delete" data-toggle="modal" id="${row.MessageVO.messageNo}" data-target="#myModal">
  						 刪除訊息
						</button></td>
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
      <div class="modal-footer" style="text-align: center">
        <button type="button" class="btn btn-primary" data-dismiss="modal">關閉</button>
      </div>
    </div>
  </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" data-target=".bs-example-modal-sm"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="myModalLabel" style="text-align: center">刪除訊息</h4>
      </div>
      <div class="modal-body" style="text-align: center">
       		<h2> 您確定要刪除?</h2>
      </div>
      <div class="modal-footer" style="text-align: center">
        <button type="button" class="btn btn-success" data-dismiss="modal">關閉</button>
        <button type="button" class="btn btn-danger" id="checkdelete">刪除</button>
      </div>
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
			$('div[id="no"]').append("<table class='table table-hover'><tr><td><h3>會員帳號:"+MessageFrom+"</h3></td></tr>"+"<tr><td><h3>信件主旨:"+MessageTitle+"</h3></td></tr>"+"<tr><td><h3>訊息內容:"+Message+"</h3></td></tr>"+"<tr><td><h3>訊息時間:"+TalkDate+"</h3></td></tr></table>");				
	});
	
});
var value;
$('.delete').click(function(){
	value = $(this).attr('id');	
});
$('#checkdelete').click(function(){
	window.location="${pageContext.request.contextPath}/message/updateMessage2.do?mid="+value;
});

</script>
<a href="${pageContext.request.contextPath}/message/message.jsp">訊息首頁</a>
</body>
</html>