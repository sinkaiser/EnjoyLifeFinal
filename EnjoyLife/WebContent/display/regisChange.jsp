<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/registerChange.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
label{float:left}
</style>
<title>修改基本資料</title>
</head>
<body>
<div class="container">
	<form method="post" class="form-horizontal" role="form" id="form" action="regisChange.do">
		<fieldset>
			<legend>修改個人資料</legend>
			<div class="form-group">
				<label for="memberId" class="col-sm-2 control-label">帳號：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control"  id="memberId" name="memberId" value="${member.memberId}" readonly="readonly">
				</div>
			</div>
			<div class="form-group">
				<label for="memberName" class="col-sm-2 control-label">姓名：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="memberName" name="memberName" value="${member.memberName}" >
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label">郵件：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="email" name="email" value="${member.email}" >
				</div>
			</div>
			<div class="form-group">
			<label for="sex" class="col-sm-2 control-label">姓別：</label>
			<div class="col-xs-4">
				<select class="form-control" id="sex" name="sex" value="${member.sex}">
					<option value="男">男</option>
					<option value="女">女</option>
				</select>
			</div>
			</div>
			<div class="form-group">
				<label for="birthday" class="col-sm-2 control-label">生日：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="birthday" name="birthday" value="${member.birthday}" >
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">地址：</label>
				<div class="col-xs-4">
					<input type="text" class="form-control" id="address" name="address" value="${member.address}" >
				</div>
			</div>
<!-- 			<div class="form-group"> -->
<!-- 				<label for="picture" class="col-sm-2 control-label">圖片：</label> -->
<!-- 				<div class="col-xs-3"> -->
<%-- 					<input type="file" class="form-control" id="picture" name="picture"  value="${member.picture}"> --%>
<!-- 				</div> -->
<!-- 			</div> -->

			<div class="form-group"> 
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" id="submit" value="送出" class="btn btn-success">
				</div>
			</div>
			<a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
		</fieldset>	
	</form>
	
</div>
</body>
</html>