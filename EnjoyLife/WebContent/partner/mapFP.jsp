<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">
<!-- <script src="https://maps.google.com/maps/api/js?sensor=false"></script> -->
<!-- <script src="https://maps.google.com/maps/api/js?sensor=false"></script> -->
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bootstrap.min.css' type="text/css" />
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/jquery-ui.min.css' type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel='stylesheet' href='css/skel-noscript.css' type="text/css" />
<link rel='stylesheet' href='css/style.css' type="text/css" />
<link rel='stylesheet' href='css/style-desktop.css' type="text/css" />
<link rel='stylesheet' href='css/bootstrap-theme.css' type="text/css" />
<link rel='stylesheet' href='css/bootstrap.css' type="text/css" />
<link rel='stylesheet' href='css/menu.css' type="text/css" />
<style type="text/css">
body {
	padding-top: 85px;
}

#googlemap {
	height: 560px;
	width: 1349px;
}

.navbar-inverse {
	height: 50px;
}

.form-textarea {
	width: 500px;
	height: 150px;
}

#inputAdd {
	width: 300px;
}
</style>
<title>Insert title here</title>
</head>
<body class="homepage">
	<%
		String aa = pageContext.getRequest().getParameter("inputAdd");
		pageContext.getRequest().setAttribute("inputAdd", aa);
	%>
	<nav class="navbar-fixed-top">
		<nav id="nav">
			<ul>
				<li><a href="../indexMember.jsp">會員</a></li>
				<li><a
					href="${pageContext.request.contextPath}/attrac/Attracimg1.jsp">景點</a></li>
				<li><a
					href="${pageContext.request.contextPath}/BlogListServlet?Index=0&&pType=ALL">日誌</a></li>
				<li><a
					href="${pageContext.request.contextPath}/partner/ShowAllPartnerServlet">找伴</a></li>
				<li><a
					href="${pageContext.request.contextPath}/activityPage/activitySimple1.jsp">活動資訊</a></li>

				<c:if test="${!empty member}">
					<li style="line-height:30px;float:right">							
					<img src="${pageContext.request.contextPath}/GetImg?imgid=${member.picture}" height="35" width="35" onerror="this.style.display='none'" style="margin-bottom:25px"> 
					<label style="height:30px;margin-bottom:26px;font-size:25px;font-family:微軟正黑體;" >${member.memberName}</label>
					<button type="button" class="btn btn-info" id="logout" data-toggle="modal"
						data-target="#myModalout" style="margin-bottom:26px" >登出</button>
					</li>
				</c:if>
			</ul>
		</nav>
		<nav class="navbar navbar-inverse" role="navigation">
			<div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<div class="navbar-form navbar-left" role="search"
						style="width: 1150px; text-align: center;">
						<!-- Split button -->
						<div class="btn-group">
							<button type="button" class="btn btn-primary">我的徵求</button>
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								<span class="caret"></span> <span class="sr-only">Toggle
									Dropdown</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">徵求中</a></li>
								<li><a href="#">已結束</a></li>
							</ul>
						</div>
						<div class="btn-group">
							<button type="button" class="btn btn-primary">我的參加</button>
							<button type="button" class="btn btn-primary dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false">
								<span class="caret"></span> <span class="sr-only">Toggle
									Dropdown</span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">歷史紀錄</a></li>
							</ul>
						</div>
						<div class="form-group"
							style="margin-right: 0px; width: 280px; margin-left: 80px">
							<input type="text" class="form-control" placeholder="Search"
								id="inputAdd" value="${inputAdd}" />
						</div>
						<button type="button" class="btn btn-default" id="button1">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
						<div class="btn-group" id="button-toggle" style="left: 100px;">
							<a href="#"><button type="button" class="btn btn-default"
									id="btn-left-map">地圖</button></a> <a
								href="${pageContext.request.contextPath}/partner/ShowAllPartnerServlet"><button
									type="button" class="btn btn-default" id="btn-right">列表</button></a>
						</div>
						<div class="btn-group" style="margin-left: 100px; float: right;">
							<button type="button" class="btn btn-primary" data-toggle="modal"
								data-target="#newPartner"
								onclick="createEvent('${mem.PartnerVO.eventNo}','${mem.PartnerVO.eventType}','${mem.PartnerVO.eventTitle}','${mem.PartnerVO.eventContent}','${mem.PartnerVO.addr}')">
								我要新增找伴活動</button>
						</div>
					</div>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
			<!-- /.container-fluid -->
		</nav>
	</nav>

	<div id="googlemap"></div>
	<div id="menu-outer">
		<div id="menu">
			<img src="../images/arrow_left.png" id="menu-icon">
		</div>
		<div id="menu-content"></div>

	</div>
	<script>
		!window.jQuery
				&& document
						.write("<script src='js/jquery-2.1.4.min.js'><\/script>")
	</script>
	<script type='text/javascript'>
		var map;
		function initMap() {
			//var myLatLng = {lat:item.results[0].geometry.location.lat, lng:item.results[0].geometry.location.lng}
			map = new google.maps.Map(document.getElementById("googlemap"), {
				zoom : 14,
				center : {
					lat : 25.053428,
					lng : 121.517561
				}
			});

		}
		(function($) {
			var w = $("#menu-content").width();
			$('#menu-content').css('height', ($(window).height() - 20) + 'px'); //將區塊自動撐滿畫面高度

			$("#menu").click(function() { //滑鼠點擊時
				if ($("#menu-outer").css('right') == '-' + w + 'px') {
					$("#menu-outer").animate({
						right : '0px'
					}, 500, 'swing');
					$("#menu-icon").attr("src", "../images/arrow_right.png")
				} else {
					$("#menu-outer").animate({
						right : '-' + w + 'px'
					}, 500, 'swing');
					$("#menu-icon").attr("src", "../images/arrow_left.png")
				}

			});
			$('#button1').click(function() {
				$.ajax({
					url : 'https://maps.googleapis.com/maps/api/geocode/json',
					type : 'get',
					data : {
						"address" : $('#inputAdd').val()
					},
					dataType : "json",
					success : function(item) {
						console.log(item.results[0].formatted_address);
						//$('#div1').text(item.results[0].formatted_address);
						console.log(0);

						map.panTo({
							lat : item.results[0].geometry.location.lat,
							lng : item.results[0].geometry.location.lng
						});
						var marker = new google.maps.Marker({
							position : {
								lat : item.results[0].geometry.location.lat,
								lng : item.results[0].geometry.location.lng
							},
							map : map

						});

					}

				})
			});

			// 	$("#mwt_slider_content").mouseleave(function(){   //滑鼠離開後
			// 		$("#mwt_mwt_slider_scroll").animate( { right:'-'+w+'px' }, 600 ,'swing');	
			// 	});	
		})(jQuery)
	</script>
	<script async defer
		src="https://maps.googleapis.com/maps/api/js?signed_in=true&callback=initMap"></script>
<!-- Modal -->
  	<div class="modal fade" id="myModalout" role="dialog" aria-labelledby="" tabindex="-1">
    	<div class="modal-dialog" style="width:350px">
    
      	<!-- Modal content-->
      	<div class="modal-content">
        	<div class="modal-header" style="padding:35px 50px;height:30px">
          	<button type="button" class="close" data-dismiss="modal">&times;</button>
          	<h4><span class="glyphicon glyphicon-lock"></span> 登出</h4>
        	</div>
        	<div class="modal-body" style="padding:40px 50px;">
        		<form role="form" action="${pageContext.request.contextPath}/logout.do"" method="post">
          		<h3>您確定要登出?</h3>
          		<button type="submit" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-off"></span> 登出</button>   
          		</form>     
        	</div>
	        
	      </div>
      
    	</div>
  	</div>
</body>
</html>