<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ENJOY LIFE</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/includes/link" %>
	<script src="js/Template2.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/register.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<link rel='stylesheet' href='css/skel-noscript.css' type="text/css" />
	<link rel='stylesheet' href='css/style.css' type="text/css" />
	<link rel='stylesheet' href='css/style-desktop.css' type="text/css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<style type="text/css">
	label.error{
	/*   background-image: url(images/unchecked.png) no-repeat 0px 0px; */
  	padding-left: 16px;
  	padding-bottom: 2px;
  	font-weight: bold;
  	color: #EA5200;
  	width:300px;
	}
	.control-label{
		width:110px;
		margin:5px;
	}
	
	#usrname, #psw{
		width:150px;
		background-color:#FFF;
		display: inline-block;
	}
	#submit, #reset{
		width:60px;
	}
	.row{
		width:1280px
	}
	.modal-content{
		height:600px;
	}
	.modal-content input{
		width:300px;
		height:30px;
	}
	.form-group{
		width:500px;
		height:43px;
		text-align:center;
	}
	#form{
		width:500px;
		margin:0px;
	}
	.col-xs-3{
		width:300px;
		height:30px;
		padding:0px;
	}
	
</style>		
</head>
<sql:setDataSource dataSource="jdbc/ELDB" var="blog" scope="application"/>
  <sql:query var="rs" dataSource="${blog}">
  			Select top 1 [photoPath] from activity 
  </sql:query>
  <sql:query var="rd" dataSource="${blog}">
  			Select top 10 [photoPath] from (select ROW_NUMBER() OVER(ORDER BY activityNo) 
  			AS 'RowNo', * from [activity]) as t where t.RowNo between 2 and 5
  </sql:query>
<body class="homepage">
		<!-- Header -->
<%@include file="/includes/header" %>	
		<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row"> 
					
					<!-- Content -->
					<div id="content" class="7u skel-cell-important">
						<section>
					<div id="carousel-example-generic" class="carousel slide"
						data-ride="carousel" style="width:550px;">
						<!-- Indicators -->

						<!-- Wrapper for slides -->
						<div class="carousel-inner" role="listbox">
							<c:forEach var="row" items="${rs.rows}" varStatus="status">
							<div class="item active" style="width:550px;">
								<img src="<c:out value='${row.photoPath}' default=""/>" alt="..." style="width:500px;height:500px;">
								<div class="carousel-caption">...</div>
							</div>
							</c:forEach>
							<c:forEach var="row" items="${rd.rows}" varStatus="status">
							<div class="item" style="width:550px;">
								<img src="<c:out value='${row.photoPath}' default=""/>" alt="..." style="width:500px;height:500px;">
								<div class="carousel-caption"></div>
							</div>
							</c:forEach>
							
						</div>

						<!-- Controls -->
					</div>
					</section>
					</div>
					
					<!-- Sidebar -->
					<div id="sidebar" class="5u">
						<section>
							<header style="margin-bottom:10px;" >
								<h4>註冊</h4>
							</header> <!-- Modal content-->
					<div class="modal-content">						
						<div class="container" style="padding-top: 20px;width:500px;">
							<form method="post"  id="form" action="registration.do" enctype="multipart/form-data" >
								<fieldset>
									<div class="form-group">
										<label for="memberId" class="col-sm-4 control-label" style="padding:0px;" >帳號(*)：</label>
										<div class="col-xs-3">
											<input type="text" class="form-control" id="memberId" name="memberId" value="${param.memberId}" title="請輸入帳號">
											<label>${ErrorMsg.memberId}</label>
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-2 control-label" style="padding-top:0px;">密碼(*)：</label>
										<div class="col-xs-3">
											<input type="password" class="form-control" id="password" name="password" value="${param.password}" title="請輸入密碼">
											<label>${ErrorMsg.password}</label>
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-2 control-label" style="padding-top:0px;">確認密碼：</label>
										<div class="col-xs-3">
											<input type="password" class="form-control" id="passwordCheck" name="passwordCheck" title="請再次輸入密碼">
										</div>
									</div>
									<div class="form-group">
										<label for="memberName" class="col-sm-2 control-label" style="padding-top:0px;">姓名(*)：</label>
										<div class="col-xs-3">
											<input type="text" class="form-control" id="memberName" name="memberName" value="${param.memberName}" title="請輸入帳號">
											<label>${ErrorMsg.memberName}</label>
										</div>
									</div>
									<div class="form-group">
										<label for="email" class="col-sm-2 control-label" style="padding-top:0px;">E-mail(*)：</label>
										<div class="col-xs-3">
											<input type="text" class="form-control" id="email" name="email" value="${param.email}" title="請輸入E-mail信箱">
											<label>${ErrorMsg.email}</label>
										</div>
									</div>
									<div class="form-group">
										<label for="sex" class="col-sm-2 control-label" style="padding-top:0px;">姓別：</label>
										<div class="col-xs-2" style="padding-top:6px;">
											<select class="sex" id="sex" name="sex">
												<option value="男">男</option>
												<option value="女">女</option>
											</select>
										</div>
									</div>
									<div class="form-group">
										<label for="birthday" class="col-sm-2 control-label" style="padding-top:0px;">生日：</label>
										<div class="col-xs-3">
											<input type="text" class="form-control" id="birthday" name="birthday" value="${param.birthday}" title="請輸入生日日期">
											<label>${ErrorMsg.birthday}</label>
										</div>
									</div>
									<div class="form-group">
										<label for="address" class="col-sm-2 control-label" style="padding-top:0px;">地址：</label>
										<div class="col-xs-3">
											<input type="text" class="form-control" id="address" name="address" value="${param.address}" title="請輸入地址">
											<label>${ErrorMsg.address}</label>
										</div>
									</div>
									<div class="form-group">
										<label for="picture" class="col-sm-2 control-label" style="padding-top:0px;">圖片：</label>
										<div class="col-xs-3">
											<input type="file" class="form-control" id="picture" name="picture" title="請輸入圖片">
										</div>
									</div>							
									<div class="form-group">
										<div class="col-sm-offset-2 col-sm-10"
											style="padding-left: 170px">
											<input type="button" id="demo" class="btn btn-default" value="DEMO">								
											<input type="submit" id="submit" class="btn btn-success" value="送出"> 
											<input type="reset" id="reset" class="btn btn-primary" value="清除">											
										</div>
									</div>
								</fieldset>
							</form>
						</div>
						<div class="modal-footer"></div>
					</div>
					</section>
					</div>
				</div>
			</div>
		</div>
		
		<!-- Footer -->

		<!-- Footer -->
		
		<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Enjoy Life
			</div>
		</div>
<script>
    (function($){	  
	    $('#demo').click(function(){	
	    	$('#memberId').val("demoId");
	    	$('#password').val("11111");
	    	$('#passwordCheck').val("11111");
	    	$('#memberName').val("大家好");
	    	$('#email').val("demo@gmail.com");
	    	$('#sex').val("男");
	    	$('#birthday').val("1988-05-05");
	    	$('#address').val("台北市");
	    });
	   
    }(jQuery));
</script>		
		
		
		
	</body>
</html>