<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ENJOY LIFE</title>
<link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="scripts/jquery-2.1.4.min.js"></script>
<!-- <script src="scripts/jquery.tinyMap-3.2.18.min.js"></script> -->
<script type="text/javascript"src="http://maps.google.com/maps/api/js?sensor=true"></script>
<script src="scripts/jquery-ui.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/jquery-ui.css">
<link rel="stylesheet" href="scripts/bootstrap.min.css">
<link rel='stylesheet' href='../css/skel-noscript.css' type="text/css" />
<link rel='stylesheet' href='../css/style.css' type="text/css" />
<link rel='stylesheet' href='../css/style-desktop.css' type="text/css" />
<link rel="stylesheet" href="css/attracdesign.css">
<style>
.homepage{
	padding-top:110px;
}
#alllist,#alllist1{
	font-size:30px;
}
</style>
</head>
<body class="homepage" >
<%@include file="/includes/newheader" %>
<nav style="width:100%;text-align:center;" >
		<div class="btn-group" role="group"  style="width:500px;left:30px;" aria-label="..." >
			<a href="${pageContext.request.contextPath}/attrac/Attracimg1.jsp"><button type="button" class="btn btn-primary" style="width:100px;margin-right:20px" >景點列表</button></a>
			<a href="${pageContext.request.contextPath}/attrac/Attracdesign.jsp"><button type="button" class="btn btn-primary" style="width:100px;margin-left:20px" >規劃</button></a>
		</div>	
</nav>
<div class="attraccontainer" >
	<div class="row">
		<div class="col-md-8" style="padding: 0px">
	       <select id="select1" class="select" >            
	       </select>
	       <select id="select2" class="select" >            
	       </select>
	       <select id="select3" class="select" >            
	       </select>
	       <select id="select4" class="select" >            
	       </select>
	       <div id="attraccanvans">
		       <div id="map">	       
		       </div>
		       <div id="allcanvan">
		       <div id="travel">
			       	<div name="default" class="traveldiv" style="text-align:center"><h1>請增加景點</h1></div>	
		       </div>
			    <div id="right-panel" style="display:none;width:auto;">
	   		    <div id="panel" style="border:5px ridge gray;font-size:16px;background-color: white;">
	   		    </div>
	   		    </div> 
	   		    </div> 
		    </div>   
       </div>
       <div class="col-md-4" style="position:relative;height:990px;padding: 0px">
       			<h1 id="alllist">清單列表</h1>
       			<img  id="listloader"src="Data/ajax-loader2.gif" style="margin-left:20px;width: 350px;height:15px;visibility:hidden;">
			    <ul id="menu" class="attraclist">	       			
				</ul>      
		       <div id="attracinfo">
		       </div>
		       <input id="canvans" type="button" value="輸出行程圖檔"  >
		       <input id="mapimg" type="button" value="輸出路程圖檔" >
		       <input id="attracadd" type="button" value="加入行程" >
		       <input type="hidden" id="number" name="attracnum">
		       <input type="hidden" id="addr">
		       <a id="auto" style="display:none;"></a>
       </div>
		<div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
		  <div class="modal-dialog modal-sm">
		    <div class="modal-content">
		      <div>
			      <h4  id="myModalLabel" style="font-size:22px;color:red;background-color:#BEBEBE">錯誤訊息</h4>
			   </div>
			   <div class="modal-body" style="font-size:30px;text-align:center;">
			   </div>
			   <div style="text-align:center;background-color:#BEBEBE">
		        <button type="button" class="btn btn-primary" data-dismiss="modal">確定</button>
		      </div>
		    </div>
		  </div>
		</div>
    </div>
</div>
<div id="copyright">
			<div class="container">
				Enjoy Life
			</div>
		</div>
		<%@include file="/includes/logout" %>
</body>
<script src="scripts/attraclistJQ.js"></script>
<script src="scripts/googletravel.js"></script>
<script src="scripts/html2canvas.js"></script>
<script>		

</script>
</body>
</html>