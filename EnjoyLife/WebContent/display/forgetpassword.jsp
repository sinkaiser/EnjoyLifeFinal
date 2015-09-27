<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
                      "http://www.w3.org/TR/html4/loose.dtd">                     
<html>
    <head>
        <meta http-equiv="Content-Type" 
              content="text/html; charset=UTF-8">
        <title>忘記密碼？</title>
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
    <form method="post" class="cmxform" id="form" action="forgetPassword.do">
		<fieldset>
			<legend>忘記密碼</legend>
			<p>
				<label class="tag" for="user">使用者帳號：</label>
				<input type="text" id="memberId" name="memberId" title="請輸入帳號"  value="${param.memberId}">
			</p>
			<p>
				<label class="tag" for="password">使用者信箱：</label>
				<input type="text" id="email" name="email" title="請輸入信箱 " value="${param.email}">
				<label>${ErrorMsg.wrong}</label>
			</p>					
			<input type="submit" id="submit" value="送出">
			<input type="reset" id="reset" value="清除">
			<a href="${pageContext.request.contextPath}/index.jsp">請按此回首頁</a>
		</fieldset>	
	</form>
    </body>
</html>