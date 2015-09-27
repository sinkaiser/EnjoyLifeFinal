<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://cdn.ckeditor.com/4.5.3/basic/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
label { float: left;}  
</style>
<title>發送訊息</title>
</head>
<body>
<div class="container">
	<form action="writeMessage.do" class="form-horizontal" method="post">
		<fieldset>
			<legend>發送訊息</legend>
			<div class="form-group">
				<label class="col-sm-2 control-label">收件者帳號：</label>
				<div class="col-xs-3">
					<input class="form-control" type="text" name="messageTo" value='${param.messageTo}'>
				</div>
				<label>${ErrorMsg.messageTo}</label>
			</div>
			<div class="form-group">	
				<label class="col-sm-2 control-label">信件主旨(*)：</label>
				<div class="col-xs-3">
					<input class="form-control" type="text" name="messageTitle">
				</div>
				<label>${ErrorMsg.messageTitle}</label>
			</div>
			<div class="form-group">
       			<textarea name="message" id="editor1"  rows="4" cols="50">
           		 </textarea>            
			</div>
			<script>
				CKEDITOR.replace( 'editor1' );
			</script>
			<div class="form-group"> 
				<div class="col-sm-offset-2 col-sm-10">
					<input class="btn btn-success" type="submit" id="submit" value="送出" >
					<input class="btn btn-primary" type="reset" id="reset" value="清除" >	
				</div>
			</div>	
		</fieldset>
		<a href="${pageContext.request.contextPath}/message/message.jsp">訊息首頁</a>
	</form>
</div>	
</body>
</html>