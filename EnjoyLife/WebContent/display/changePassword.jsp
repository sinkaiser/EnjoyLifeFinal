<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密碼</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
 label { float: left;}  
</style>
</head>
<body>
<div class="container">
	<form method="post" class="form-horizontal" id="form" action="changePassword.do">
		<fieldset>
			<legend>修改密碼</legend>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="user">帳號(*)：</label>
				<div class="col-xs-3">
					<input class="form-control" type="text" id="memberId" name="memberId" title="請輸入帳號"  value="${member.memberId}" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">舊密碼：</label>
				<div class="col-xs-3">
					<input class="form-control" type="password" id="oldPassword" name="oldPassword" title="請輸入密碼 ">
					<label>${ErrorMsg.password}</label>
				</div>
			</div>					
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">新密碼：</label>
				<div class="col-xs-3">
					<input class="form-control" type="password" id="newPassword" name="newPassword" title="請輸入密碼">				
					<label>${ErrorMsg.newPassword}</label>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label" for="password">再次確認</label>
				<div class="col-xs-3">
					<input class="form-control" type="password" id="passwordCheck" name="passwordCheck" title="請再次輸入密碼">
					<label>${ErrorMsg.passwordCheck}</label>
				</div>
			</div>
			<div class="form-group"> 
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" id="submit" class="btn btn-success" value="送出">
					<input type="reset" id="reset" class="btn btn-primary" value="清除">
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/index.jsp">請按此回首頁</a>
		</fieldset>	
	</form>
</div>

</body>
</html>