<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ENJOY LIFE</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
	<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bootstrap.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/jquery-ui.min.css' type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<link rel='stylesheet' href='${pageContext.request.contextPath}/activityPage/css/skel-noscript.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/activityPage/css/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/activityPage/css/style-desktop.css' type="text/css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
</head>
<body class="homepage">
<sql:setDataSource dataSource="jdbc/ELDB" var="activity" scope="application"/>
  <sql:query var="rs" dataSource="${activity}">
  			Select * from (select ROW_NUMBER() OVER(ORDER BY activityNo) 
  			AS 'RowNo', * from [activity]) as t where t.RowNo between 16 and 20
  </sql:query>

		<!-- Header -->
<%@include file="/includes/newheader" %>
		<!-- Main -->
		<div id="main">
			<div class="container">
				<div class="row"> 
					
					
					<!-- Sidebar -->
					<div id="sidebar" class="4u">
						<section>
							<header>
								<h2>活動資訊</h2>
							</header>
							<ul class="style">
							<c:forEach var="row" items="${rs.rows}" varStatus="status">
								<li>
									<p class="posted"><a href="../view/id/${row.activityNo}.jsp" ><c:out value="${row.activityName}" /></a></p>
									<a href ="../view/id/${row.activityNo}.jsp" ><img src="<c:out value='${row.photoPath}' />" alt="" /></a>
									<p class="text"><c:out value="${row.activityDepiction}" /></p>
									<p class="date"><c:out value="${row.activityDate}" /></p>
								</li>
							</c:forEach>	
							</ul>
						</section>
					</div>
					<!-- Content -->
					<div id="sidebar-viewR" class="3u">
						<section>
							<ul id="sideview">
								<li>
									<img src="${pageContext.request.contextPath}/activityPage/images/love.jpg" alt="" style="width:300px;height:300px;"/>
								</li>
								<li>
									<img src="${pageContext.request.contextPath}/activityPage/images/love1.jpg" alt="" style="width:300px;height:300px;"/>
								</li>
							</ul>
						</section>
					</div>
				</div>
				<nav class="dopage" style="text-align: center">
  					<ul class="pagination" >
    					<li><a href="activitySimple3.jsp"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
    					<li><a href="activitySimple1.jsp">1</a></li>
    					<li><a href="activitySimple2.jsp">2</a></li>
    					<li><a href="activitySimple3.jsp">3</a></li>
    					<li class="active"><a href="activitySimple4.jsp">4</a></li>
    					<li><a href="activitySimple5.jsp">5</a></li>
    					<li><a href="activitySimple6.jsp">6</a></li>
    					<li><a href="activitySimple5.jsp"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
  					</ul>
				</nav>
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