<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
	}
	#blogside{
		border-bottom:2px solid #E0E0E0;
		margin-bottom:20px;
		width:400px;
		height: 600px;
		padding-bottom:20px;
	}
</style>		
</head>
<sql:setDataSource dataSource="jdbc/ELDB" var="blog" scope="application"/>
  <sql:query var="rs" dataSource="${blog}">
  			Select top 5 [photoPath],[activityDepiction],[activityName],[activityNo] from activity order by activityNo
  </sql:query>
<%--   <sql:query var="rd" dataSource="${blog}"> --%>
<!--   			Select top 10 [photoPath] from (select ROW_NUMBER() OVER(ORDER BY activityNo)  -->
<!--   			AS 'RowNo', * from [activity]) as t where t.RowNo between 2 and 5 -->
<%--   </sql:query> --%>
<%--   <sql:query var="rf" dataSource="${blog}"> --%>
<!--   			select top 1 partner.eventContent,partner.eventDate,partner.imgNo,ImgList.imgName,ImgList.imgNo,ImgList.imgContent,ImgList.imgType -->
<!--   			from partner inner join ImgList on partner.imgNo=ImgList.imgNo -->
<!--   			order by eventDate desc; -->
<%--   </sql:query> --%>
<body class="homepage">
		<!-- Header -->
<nav class="navbar-fixed-top">	
	<div class="header1">	
		<div id="header" >
				
				<!-- Logo -->
				<div id="logo">
					<h1><a href="${pageContext.request.contextPath}/GetIndexInfoServlet">Enjoy Life</a></h1>
				</div>
				
				<div style="width:750px;margin-left:200px;">
					<img id="xxx" src="images/dog2.gif" class="img-circle" height="60px" width="60px">
					<button id="say" type="button" class="btn btn-default" style="margin-bottom:15px;"></button>
					<br>
					<input id="ooo" value="請輸入" type="hidden">
					<input id="sumit" value="送出資料" type="hidden">
				</div>
				
				
		</div>
		<div>
			<!-- Nav -->
				<nav id="nav">
					<ul>
			<li><a href="${pageContext.request.contextPath}/indexMember.jsp">會員</a></li>
			<li><a href="${pageContext.request.contextPath}/attrac/Attracimg1.jsp">景點</a></li>
			<li><a href="${pageContext.request.contextPath}/BlogListServlet?Index=0&&pType=ALL">日誌</a></li>
			<li><a href="${pageContext.request.contextPath}/partner/ShowAllPartnerServlet">找伴</a></li>
			<li><a href="${pageContext.request.contextPath}/activityPage/activitySimple1.jsp">活動資訊</a></li>
			
			<c:if test="${!empty member}">
				<li style="line-height:30px;">
				<div id="imgti" style="position:relative;top:-30px;height:70px;">							
				<img src="${pageContext.request.contextPath}/GetImg?imgid=${member.picture}" id="headerimg" class="img-circle" style="height:65px;width:60px;box-shadow:0px 0px 10px 7px #F5FAFF;"> 
				<label style="height:30px;font-size:26px;font-family:微軟正黑體;" >${member.memberName}</label>
				<button type="button" class="btn btn-info" id="logout" data-toggle="modal" data-target="#myModalout" style="margin-bottom:26px" >登出</button>
				</div>
			</li>
			</c:if>
		</ul>
				</nav>
		</div>
	</div>
	</nav>	
		<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row" style="width:1280px;" > 
					<!-- Sidebar -->
					<div id="sidebar" class="2u">
						<section>
							<header style="height:50px;">
								<p style="font-size:35px;" >活動</p>
							</header>
						</section>
					</div>
					<!-- Content -->
					<div id="content" class="5u skel-cell-important" style="margin-left:100px;">
					<section style="border:0px;" >
						<header>
							<h2 style="font-size:30px;" >HOT</h2>
						</header>
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel" style="width: 450px;" data-interval="4000">
							<!-- Indicators -->

							<!-- Wrapper for slides -->
							<div class="carousel-inner" role="listbox" style="width: 450px;">
							<%request.getSession().getAttribute("bloglist");%>
								<c:forEach var="lists" items="${bloglist}" begin="0" end="0">
									<div class="item active" id="blogside">
											<p style="font-size: 25pt;">${lists.postTitle}</p>
											<img
												src="${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=T&&pathImg=${lists.pathPhoto}"
												alt="..."
												style="width: 400px; height: 450px; position: relative; top: -15px;"><br>
											<span class="glyphicon glyphicon-user" aria-hidden="true">${lists.memberId}</span>
											<span class="glyphicon glyphicon-eye-open" aria-hidden="true"
												style="margin-left:10px;">${lists.viewTotal}</span>
											<fmt:formatDate value="${lists.postDate}" var="formattedDate"
												type="date" pattern="MM月dd日 HH:mm" />
											<span style="float:right;" >${formattedDate}</span>
											<div class="carousel-caption">...</div>
									</div>
								</c:forEach>
								<c:forEach var="lists" items="${bloglist}" begin="1" end="4">
									<div class="item" id="blogside">
											<p style="font-size: 25pt;">${lists.postTitle}</p>
											<img
												src="${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=T&&pathImg=${lists.pathPhoto}"
												alt="..."
												style="width: 400px; height: 450px; position: relative; top: -15px;"><br>
											<span class="glyphicon glyphicon-user" aria-hidden="true">${lists.memberId}</span>
											<span class="glyphicon glyphicon-eye-open" aria-hidden="true"
												style="margin: 0px 40px 0px 10px;">${lists.viewTotal}</span>
											<fmt:formatDate value="${lists.postDate}" var="formattedDate"
												type="date" pattern="MM月dd日 HH:mm" />
											<span style="float:right;">${formattedDate}</span>
											<div class="carousel-caption">...</div>
									</div>
								</c:forEach>
							</div>

							<!-- Controls -->
						</div>
					</section>
				</div>
					
					<!-- Sidebar -->
					<div id="sidebar" class="4u" >
						<section>
							<header style="height:50px;">
								<p style="font-size:35px;" >活動</p>
							</header>
							<ul class="style">
								<li>
									<div id="carousel-example-generic" class="carousel slide"
									data-ride="carousel" style="width: 330px;" data-interval="3000">
									<!-- Indicators -->

									<!-- Wrapper for slides -->
									<div class="carousel-inner" role="listbox" style="width:330px;">
									<% request.getSession().getAttribute("parterlist") ; %>
										<c:forEach var="list2" items="${parterlist}" begin="0" end="0">
											<div class="item active" style="width: 330px;cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/partner/ShowAllPartnerServlet'">
												<p style="font-size:15px;height:45px;">${list2.eventContent}</p>
												<img src="${pageContext.request.contextPath}/GetImg?imgid=${list2.imgNo}"
													alt="..." style="width: 330px; height: 250px;"><br>
												<span class="glyphicon glyphicon-user" aria-hidden="true" >${list2.memberName}</span>
												<fmt:formatDate value="${list2.eventDate}" var="formattedDate1"
												type="date" pattern="MM月dd日 HH:mm" />
												<span class="glyphicon glyphicon-tag" aria-hidden="true" style="margin-left:20px;float:right" >${formattedDate1}</span>
												<div class="carousel-caption">...</div>
											</div>
										</c:forEach>
										<c:forEach var="list2" items="${parterlist}" begin="1" end="4">
											<div class="item" style="width: 330px;cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/partner/ShowAllPartnerServlet'">
												<p style="font-size:15px;height:45px;">${list2.eventContent}</p>
												<img src="${pageContext.request.contextPath}/GetImg?imgid=${list2.imgNo}"
													alt="..." style="width: 330px; height: 250px;"><br>
												<span class="glyphicon glyphicon-user" aria-hidden="true" >${list2.memberName}</span>
												<fmt:formatDate value="${list2.eventDate}" var="formattedDate1"
												type="date" pattern="MM月dd日 HH:mm" />
												<span class="glyphicon glyphicon-tag" aria-hidden="true" style="margin-left:20px;float:right">${formattedDate1}</span>
												<div class="carousel-caption"></div>
											</div>
										</c:forEach>

									</div>

									<!-- Controls -->
								</div>
							</li>
								<li>
									<div id="carousel-example-generic" class="carousel slide"
									data-ride="carousel" style="width: 250px;">
									<!-- Indicators -->

									<!-- Wrapper for slides -->
									<div class="carousel-inner" role="listbox">
										<c:forEach var="row" items="${rs.rows}" varStatus="status" begin="0" end="0">
											<div class="item active" style="width: 250px;cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/view/id/<c:out value='${row.activityNo}' default=""/>.jsp'">
												<p style="font-size:15px;" ><c:out value='${row.activityName}' default=""/></p>
												<img src="<c:out value='${row.photoPath}' default=""/>"
													alt="..." style="width: 250px; height: 200px;"><br>
												<c:out value='${row.activityDepiction}' default=""/>
											</div>
										</c:forEach>
										<c:forEach var="row" items="${rs.rows}" varStatus="status" begin="1" end="4">
											<div class="item" style="width: 250px;cursor:pointer;" onclick="location.href='${pageContext.request.contextPath}/view/id/<c:out value='${row.activityNo}' default=""/>.jsp'">
												<p style="font-size:15px;" ><c:out value='${row.activityName}' default=""/></p>
												<img src="<c:out value='${row.photoPath}' default=""/>"
													alt="..." style="width: 250px; height: 200px;"><br>
												<c:out value='${row.activityDepiction}' default=""/>
											</div>
										</c:forEach>

									</div>

									<!-- Controls -->
								</div>
								</li>
							</ul>
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