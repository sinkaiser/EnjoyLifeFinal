<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>名單</title>
</head>
<body>
<table class="table">
<%-- 	<div><p id="success">${xxx}</p></div> --%>
		<h2>會員管理</h2>
		<div id="result">${result}</div>
		<thead>
			<tr>				
				<td>大頭照</td>
				<td>會員帳號</td>
				<td>會員名稱</td>
				<td>會員信箱</td>
				<td>註冊日期</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${all}">			
				<tr name="${row.memberId}">
				<td><img src="${pageContext.request.contextPath}/GetImg?imgid=${row.picture}" height="35" width="35"  onerror="this.style.display='none'"></td>			
					<td>${row.memberId}</td>
					<td>${row.memberName}</td>
					<td>${row.email}</td>
					<fmt:formatDate value="${row.registerDate}" var="formattedDate" type="date" pattern="yyyy年M月d日 H:mm" />
					<td>${formattedDate}</td>
<%-- 					<td>${row.registerDate}</td> --%>
					<td><select name="sel">
					<c:if test="${row.permission=='0'}">
						<option selected="selected" value="0">正常</option>
						<option value="3">黑名單</option>
					</c:if>
					<c:if test="${row.permission=='3'}">
						<option value="0">正常</option>
						<option selected="selected" value="3">黑名單</option>
					</c:if>
					
					</select></td>	
					<td><a name="black" href="#"><input type="button" value="修改"></a></td>
				</tr>										
		</c:forEach>
		</tbody>
</table>
<script type="text/javascript">
	(function($){
		$('a[name="black"]').click(function(){
			$("#result").text("資料沒有修改")
		});
		$('select[name="sel"]').change(function(){
			var aa=$(this).val();
			var memberId = $(this).parents("tr").attr("name");  
			$(this).parents("tr").find('a[name="black"]').attr("href","manager.do?memberId="+memberId+"&black="+aa);
			console.log(aa);
			console.log(memberId);
		});
	}(jQuery));
	
</script>
</body>
</html>