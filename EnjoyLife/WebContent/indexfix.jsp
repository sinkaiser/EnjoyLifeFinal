<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html >
<html>
<head>
<title>ENJOY LIFE</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
	<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
	<link rel='stylesheet' href='css/bootstrap.min.css' type="text/css" />
	<link rel='stylesheet' href='css/jquery-ui.min.css' type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.form.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.validate.min.js"></script>
	<script src="js/date.js"></script>
	<script src="js/moment-with-locales.js"></script>
	<script src="js/bootstrap-datetimepicker.js"></script>
	<script src="js/jQueryRotate.js"></script>
	<link rel='stylesheet' href='css/skel-noscript.css' type="text/css" />
	<link rel='stylesheet' href='css/style.css' type="text/css" />
	<link rel='stylesheet' href='css/style-desktop.css' type="text/css" />
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
	#submit, #reset,#demo{
		width:60px;
	}
	.row{
		width:1280px
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
  <c:if test="${!empty black }">
	<c:remove var="black" scope="session" />
	<script type="text/javascript">
		alert("已經成為黑名單");
	</script>
	
	</c:if>
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
					<div id="content" class="6u skel-cell-important">
						<section>
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
										<div class="col-sm-offset-1 col-sm-10"
											style="padding-left: 140px">
											<input type="button" id="demo" class="btn btn-defult" value="展示">																		
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
				var time="${member.registerDate}" //time
					var name="${member.memberName}" //name
					var member="${member}" //true
					var imgid="${member.picture}"
				
				if(name==""){
					name="訪客";
					}
				
				
				$('#say').attr("class","btn btn-info")
				$('#xxx').attr("src","images/dog2.gif");
				$('#say').text(name+"你好");
				
				var time="${member.registerDate}" //time
				var name="${member.memberName}" //name
				var member="${member}" //true
				var imgid="${member.picture}"
				
				
				$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":1},function(data){
					
					var elfNo;
					var targetNo;
					var nevin;
					var typeNo;
					var beginTime;
					var endTime;
					var flag1=false;
					
					if(time){
						if((new Date()-new Date(time))>new Date(1000*60*60*24*30*3)){
							alert("超過");
							flag1=true;
						}
					}
					var arrayObj=new Array(0);
					var date=new Date();
					var begin;
					var end;
					console.log(time)
					$.each(data,function(){
						
						beginTime=this.beginTime;
						endTime=this.endTime;
					
						begin=new Date(beginTime);
						end=new Date(endTime);
						
						elfNo=this.elfNo;
						targetNo=this.targetNo;
						nevin=this.nevin;
						typeNo=this.typeNo;
						
						
						if(date<end && date>begin){  //文章沒過期
							if(member){     //是會員
							
							
							
								if(flag1){		     //老會員
									if(targetNo==3||targetNo==4){
// 										alert("老會員")
										arrayObj.push(nevin+"A0A"+typeNo);
									}
								}			
								else{				//新會員
									if(targetNo==2||targetNo==4||targetNo==3){
// 										alert("新會員")
										arrayObj.push(nevin+"A0A"+typeNo);
									}
								}
							}
							else{					//不是會員
								if(targetNo==2||targetNo==1){
// 									alert("不是會員")

									arrayObj.push(nevin+"A0A"+typeNo);
								}
							}
						}
					});
					
					function aa(){
						var ran=Math.floor(Math.random()*arrayObj.length);
						console.log(arrayObj[ran]);
						var rans=arrayObj[ran].split("A0A");
						
							
						console.log(rans[1]);
						
						if(rans[1]==1){
							$('#say').attr("class","btn btn-primary")
							$('#xxx').attr("src","images/dog2.gif");
							$('#say').text("公告:"+rans[0]);
						}
						else if(rans[1]==2){
							$('#say').attr("class","btn btn-success")
							$('#xxx').attr("src","images/dog2.gif");
							
							$('#say').html("優惠資訊:"+rans[0]);
						}
						else if(rans[1]==3){
							$('#say').attr("class","btn btn-info")
							$('#xxx').attr("src","images/dog2.gif");
							$('#say').text("提醒:"+rans[0]);
						}
						else if(rans[1]==4){
							
							$('#say').attr("class","btn btn-info")
							var imgid=rans[0].split("imgid=");
							var name=imgid[0].split("?name=");
							$('#xxx').attr("src","${pageContext.request.contextPath}/GetImg?imgid="+imgid[1]);
							$('#say').text("會員["+name[1]+"]:"+name[0]);
						}
					}
					
					var flag=true;
					var angle=0;
					function bb(){
						
						if(flag){
							
							angle=angle+10
							$("#xxx").rotate(angle);
							if(angle>45){
								flag=false;
							}
						}else{
						
							angle=angle-10;
							$("#xxx").rotate(angle);
							if(angle<0){
								flag=true;
							}
						}
					}
					
					var timeoutId=setInterval(aa, 5000);
					var timeoutId=setInterval(bb, 250);
					
				})
				if(member){
					$('#xxx').dblclick(function(){
						$('#say').text("讓我幫你昭告天下");
						$('#ooo').attr("type","text");
						$('#sumit').attr("type","button").click(function(){
							
						var nevin=$('#ooo').val();
						var begin=new Date();
						var end=new Date(1000*60*5+ begin.getTime());
						
						begin=begin.format("isoDateTime");
						var a=begin.split("T");
						end=end.format("isoDateTime");
						var b=end.split("T");
						begin=a[0]+" "+a[1];
						end=b[0]+" "+b[1];
								$.ajax({"type":"post","url":"${pageContext.request.contextPath}/Little","dataType":"text","data":{"do":"insert","targetNo":4,"typeNo":4,"beginTime":begin,"endTime":end,"nevin":nevin+"?name="+name+"imgid="+imgid},
									"success":function(da){
									alert("成功")
									$('#ooo').text("");
									$('#ooo').attr("type","hidden");
									$('#say').text("訊息已經送出");
									$('#sumit').attr("type","hidden")
									}
								});			
						});			
					})
				}
					
			}(jQuery));
		
		</script>		
		
		
	<%@include file="/includes/logout" %>	
	</body>
</html>