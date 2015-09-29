<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ENJOY LIFE</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/includes/link" %>	
	<link rel='stylesheet' href='${pageContext.request.contextPath}/activityPage/css/skel-noscript.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/activityPage/css/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/activityPage/css/style-desktop.css' type="text/css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
</head>
<sql:setDataSource dataSource="jdbc/ELDB" var="activity" scope="application"/>
  <sql:query var="rs" dataSource="${activity}">
  			Select * from (select ROW_NUMBER() OVER(ORDER BY activityNo) 
  			AS 'RowNo', * from [activity]) as t where t.RowNo between 1 and 5
  </sql:query>
<body class="homepage">
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
<%-- 								<c:url value="../view/id/${row.activityNo}.jsp" var="path"> --%>
<%-- 									<c:param name="activityName" value="${row.activityName}" /> --%>
<%-- 									<c:param name="activityContent" value="${row.activityContent}" /> --%>
<%-- 									<c:param name="activityDate" value="${row.activityDate}" /> --%>
<%-- 									<c:param name="activityLocation" value="${row.activityLocation}" /> --%>
<%-- 									<c:param name="activityContact" value="${row.activityContact}" /> --%>
<%-- 								</c:url> --%>
								<li>
									<p class="posted" ><a href="../view/id/${row.activityNo}.jsp" ><c:out value="${row.activityName}" default=""/></a></p>
									<a href ="../view/id/${row.activityNo}.jsp" ><img src="../<c:out value='${row.photoPath}' default=""/>" alt="" /></a>
									<p class="text"><c:out value="${row.activityDepiction}"  default=""/></p>
									<p class="date"><c:out value="${row.activityDate}" default=""/></p>
									
								</li>
							</c:forEach>
							</ul>
						</section>
					</div>
					<!-- Content -->
					<div id="content" class="8u skel-cell-important">
						<section>
							<header>
								<h2>HOT</h2>
								<span class="byline">Integer sit amet pede vel arcu aliquet pretium</span>
							</header>
							<a href="#" class="image full"><img src="images/pic07.jpg" alt="" /></a>
							<p>This is <strong>Iridium</strong>, a responsive HTML5 site template freebie by <a href="http://templated.co">TEMPLATED</a>. Released for free under the <a href="http://templated.co/license">Creative Commons Attribution</a> license, so use it for whatever (personal or commercial) &ndash; just give us credit! Check out more of our stuff at <a href="http://templated.co">our site</a> or follow us on <a href="http://twitter.com/templatedco">Twitter</a>.</p>
							<p>Sed etiam vestibulum velit, euismod lacinia quam nisl id lorem. Quisque erat. Vestibulum pellentesque, justo mollis pretium suscipit, justo nulla blandit libero, in blandit augue justo quis nisl. Fusce mattis viverra elit. Fusce quis tortor. Consectetuer adipiscing elit. Nam pede erat, porta eu, lobortis eget lorem ipsum dolor.</p>
						</section>
					</div>
				</div>
				<nav class="dopage" style="text-align: center">
  					<ul class="pagination" >
    					<li><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>
    					<li class="active"><a href="activitySimple1.jsp">1</a></li>
    					<li><a href="activitySimple2.jsp">2</a></li>
    					<li><a href="activitySimple3.jsp">3</a></li>
    					<li><a href="activitySimple4.jsp">4</a></li>
    					<li><a href="activitySimple5.jsp">5</a></li>
    					<li><a href="activitySimple6.jsp">6</a></li>
    					<li><a href="activitySimple2.jsp"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>
  					</ul>
				</nav>
			</div>
		</div>

		<!-- Footer -->

		<!-- Footer -->
		<div id="footer">
			<div class="container">
				<div class="row">
					<div class="4u">
						<section>
							<h2>Latest Posts</h2>
							<ul class="default">
								<li><a href="#">Pellentesque lectus gravida blandit</a></li>
								<li><a href="#">Lorem ipsum consectetuer adipiscing</a></li>
								<li><a href="#">Phasellus nibh pellentesque congue</a></li>
								<li><a href="#">Cras vitae metus aliquam pharetra</a></li>
								<li><a href="#">Maecenas vitae orci feugiat eleifend</a></li>
							</ul>
						</section>
					</div>
					<div class="4u">
						<section>
							<h2>Ultrices fringilla</h2>
							<ul class="default">
								<li><a href="#">Pellentesque lectus gravida blandit</a></li>
								<li><a href="#">Lorem ipsum consectetuer adipiscing</a></li>
								<li><a href="#">Phasellus nibh pellentesque congue</a></li>
								<li><a href="#">Cras vitae metus aliquam pharetra</a></li>
								<li><a href="#">Maecenas vitae orci feugiat eleifend</a></li>
							</ul>
						</section>
					</div>
					<div class="4u">
						<section>
							<h2>Aenean elementum</h2>
							<ul class="default">
								<li><a href="#">Pellentesque lectus gravida blandit</a></li>
								<li><a href="#">Lorem ipsum consectetuer adipiscing</a></li>
								<li><a href="#">Phasellus nibh pellentesque congue</a></li>
								<li><a href="#">Cras vitae metus aliquam pharetra</a></li>
								<li><a href="#">Maecenas vitae orci feugiat eleifend</a></li>
							</ul>
						</section>
					</div>
				</div>
			</div>
		</div>

		<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Enjoy Life
			</div>
		</div>
		
	</body>
</html>