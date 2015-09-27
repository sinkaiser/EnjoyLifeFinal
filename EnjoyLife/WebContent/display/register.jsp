<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<title>註冊</title>
<style type="text/css">
label { float: left;}  
label.error{
/*   background-image: url(images/unchecked.png) no-repeat 0px 0px; */
  padding-left: 16px;
  padding-bottom: 2px;
  font-weight: bold;
  color: #EA5200;
}
</style>
</head>
<body>
<div class="container">
	<form method="post" class="form-horizontal" id="form" action="registration.do" enctype="multipart/form-data">
		<fieldset>
			<legend >註冊</legend>
			<div class="form-group">
				<label for="memberId" class="col-sm-2 control-label">帳號(*)：</label>
				<div class="col-xs-3">
					<input type="text" class="form-control"  id="memberId" name="memberId" value="${param.memberId}" title="請輸入帳號">
					<label>${ErrorMsg.memberId}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">密碼(*)：</label>
				<div class="col-xs-3">
					<input type="password" class="form-control"  id="password" name="password" value="${param.password}" title="請輸入密碼">
					<label>${ErrorMsg.password}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label">確認密碼：</label>
				<div class="col-xs-3">
					<input type="password" class="form-control"  id="passwordCheck" name="passwordCheck" title="請再次輸入密碼">
				</div>
			</div>
			<div class="form-group">
				<label for="memberName" class="col-sm-2 control-label">姓名(*)：</label>
				<div class="col-xs-3">
					<input type="text" class="form-control"  id="memberName" name="memberName" value="${param.memberName}" title="請輸入帳號">
					<label>${ErrorMsg.memberName}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">E-mail(*)：</label>
				<div class="col-xs-3">
					<input type="text" class="form-control"  id="email" name="email" value="${param.email}" title="請輸入E-mail信箱">
					<label>${ErrorMsg.email}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">姓別：</label>
				<div class="col-xs-3">
					<select class="sex" id="sex" name="sex">
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="birthday" class="col-sm-2 control-label">生日：</label>
				<div class="col-xs-3">
					<input type="text" class="form-control"  id="birthday" name="birthday" value="${param.birthday}" title="請輸入生日日期" >
					<label>${ErrorMsg.birthday}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">地址：</label>
				<div class="col-xs-3">
					<input type="text" class="form-control"  id="address" name="address" value="${param.address}" title="請輸入地址">
					<label>${ErrorMsg.address}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="picture" class="col-sm-2 control-label">圖片：</label>
				<div class="col-xs-3">
					<input type="file" class="form-control"  id="picture" name="picture" title="請輸入圖片">
				</div>
			</div>
			<div class="form-group"> 
				<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" id="submit" class="btn btn-success" value="送出">
				<input type="reset" id="reset" class="btn btn-primary" value="清除">
				</div>
			</div>
		</fieldset>	
		<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
	</form>
	
</div>

</body>
</html>