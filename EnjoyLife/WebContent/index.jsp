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
		width:650px;
		padding-bottom:20px;
	}
	#blogpage{
		width:300px;
		border:2px solid;
		border-radius:10% 10% 5% 5%;
		padding-left:22px;
		background-color:#C4E1FF;
	}
</style>		
</head>
<sql:setDataSource dataSource="jdbc/ELDB" var="blog" scope="application"/>
  <sql:query var="rs" dataSource="${blog}">
  			Select top 5 [photoPath],[activityDepiction],[activityName] from activity order by activityNo
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
<%@include file="/includes/newheader" %>	
		<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row"> 
					
					<!-- Content -->
					<c:if test="${!empty regisOK }">
							<c:remove var="regisOK" scope="session" />
							<script type="text/javascript">
								alert("註冊成功");
							</script>
	
						</c:if>
					<div id="content" class="7u skel-cell-important">
					<section style="border:0px;" >
						<header>
							<h2>HOT</h2>
						</header>
						<%
							request.getSession().getAttribute("bloglist");
						%>
						<c:forEach var="lists" items="${bloglist}">
							<div class="item active" id="blogside">
								<div id="blogpage">
									<p style="font-size:25pt;">${lists.postTitle}</p>
									<img
										src="${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=T&&pathImg=${lists.pathPhoto}"
										alt="..." style="width: 250px; height: 230px;position:relative;top:-15px;"><br>
									<span class="glyphicon glyphicon-user" aria-hidden="true" >${lists.memberId}</span>
									<span class="glyphicon glyphicon-eye-open" aria-hidden="true" style="margin:0px 40px 0px 10px;" >${lists.viewTotal}</span>
									<fmt:formatDate value="${lists.postDate}" var="formattedDate" type="date" pattern="MM月dd日 HH:mm" />
									<span>${formattedDate}</span>
									<div class="carousel-caption">...</div>
								</div>
							</div>
						</c:forEach>
					</section>
				</div>
					
					<!-- Sidebar -->
					<div id="sidebar" class="5u">
						<section>
							<header style="height:50px;">
								<p style="font-size:35px;" >活動</p>
							</header>
							<ul class="style">
								<li>
									<div id="carousel-example-generic" class="carousel slide"
									data-ride="carousel" style="width: 350px;" data-interval="3000">
									<!-- Indicators -->

									<!-- Wrapper for slides -->
									<div class="carousel-inner" role="listbox" style="width:350px;">
									<% request.getSession().getAttribute("bloglist") ;%>
									<% request.getSession().getAttribute("parterlist") ; %>
										<c:forEach var="list2" items="${parterlist}" begin="0" end="0">
											<div class="item active" style="width: 350px;">
												<p style="font-size:15px;">${list2.eventContent}</p>
												<img src="${pageContext.request.contextPath}/GetImg?imgid=${list2.imgNo}"
													alt="..." style="width: 350px; height: 280px;"><br>
												<span class="glyphicon glyphicon-user" aria-hidden="true" >${list2.memberId}</span>
												<span class="glyphicon glyphicon-tag" aria-hidden="true" style="margin-left:20px;" >${list2.eventNo}</span>
												<div class="carousel-caption">...</div>
											</div>
										</c:forEach>
										<c:forEach var="list2" items="${parterlist}" begin="1" end="4">
											<div class="item" style="width: 350px;">
												<p style="font-size:15px;">${list2.eventContent}</p>
												<img src="${pageContext.request.contextPath}/GetImg?imgid=${list2.imgNo}"
													alt="..." style="width: 350px; height: 280px;"><br>
												<span class="glyphicon glyphicon-user" aria-hidden="true" >${list2.memberId}</span>
												<span class="glyphicon glyphicon-tag" aria-hidden="true" style="margin-left:20px;">${list2.eventNo}</span>
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
											<div class="item active" style="width: 250px;">
												<p style="font-size:15px;" ><c:out value='${row.activityName}' default=""/></p>
												<img src="<c:out value='${row.photoPath}' default=""/>"
													alt="..." style="width: 250px; height: 200px;"><br>
												<c:out value='${row.activityDepiction}' default=""/>
											</div>
										</c:forEach>
										<c:forEach var="row" items="${rs.rows}" varStatus="status" begin="1" end="4">
											<div class="item" style="width: 250px;">
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
		<%@include file="/includes/logout" %>
	</body>
</html>