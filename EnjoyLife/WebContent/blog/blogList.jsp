<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ENJOY LIFE</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<%@include file="/includes/link" %>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" />
<%-- 	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" > --%>
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/skel-noscript.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style-desktop.css' type="text/css" />
<%-- 	<script	type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script> --%>
<%-- 	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script> --%>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>	
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->

<style>
	.blogList{
		border:2px solid #428bca;
		padding:5px;
		margin: 5px;
		display:inline-block;
		width:250px;
		height:430px;
		box-shadow:5px 5px 15px rgba(10,125,225,0.4);
	}
	.layoutSide{
		background-color:#CCEEFF;
		display:block;
		height:auto;
		
	}
	.blogImg{
		border:5px solid gray;
		margin:10px;
		width:220px;
		float:left;
		overflow:hidden;
	}
	.arti{
		color: black;
		font-size:12pt;
	}
	.lab-size{
		font-size:10pt;
	}
	.dataFont{
		font-size:11pt;
	}
	.replyfomat{
		border:1px solid #DDDDDD;
		display:block;
		margin-bottom:5px;
		max-height:870px;
		overflow: auto;
	}
	.fomatA{
		border:1px solid #DDDDDD;
	}
	.fomatF{
		display:block;
		width:60px;	
		height:60px;
		float:left; 
		margin:5px auto;
	}
	.fomatB{
		display:inline-block;
 		line-height: 10px; 
		margin:5px auto;
		width:250px;
		word-break: break-all;
/* 		background-image:url('${pageContext.request.contextPath}/images/reply.png'); */
/* 		background-size:100% 100%; */
	}	
	.mainBody{
/* 		margin-top:50px; */
	}
/* 	.modal-headerX{ */
/* 		min-height:16.43px;padding:15px;border-bottom:1px solid #DDDDDD; */
/* 		} */
</style>
<script type="text/javascript">
	function getAllReply(ArticleNo){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/GetReplyServlet",
			dataType:"json",
			data:{"ArticleNo":ArticleNo},
			success:function(data){		
				$('#replyDiv').empty();
				console.log(data);
				$.each(data,function(i,value){
					var eleDiv1 = document.createElement("div");
					var eleDiv2 = document.createElement("div");
					var eleDiv3 = document.createElement("div");
					
					var eleImg = document.createElement("Img");

					eleImg.setAttribute("src", "${pageContext.request.contextPath}/GetImg?imgid="+value.memPic);
					eleImg.setAttribute("width", "50px");
					eleImg.setAttribute("height", "50px");
					eleDiv1.appendChild(eleImg);
					eleDiv1.setAttribute("class", "fomatF");
					
					var eleP1 = document.createElement("p");
					var eleA  = document.createElement("a");
					var txtP1  = document.createTextNode("說:");
					var txtA  = document.createTextNode(value.replyMemberId);
					eleA.setAttribute("href", "#");
					eleA.appendChild(txtA);
					eleP1.appendChild(eleA);
					eleP1.appendChild(txtP1);
					eleP1.setAttribute("class", "p_rp_memid");
					
					var eleP2 = document.createElement("p");
					var txtP2  = document.createTextNode(value.replyContext);
					eleP2.appendChild(txtP2);
					eleP2.setAttribute("class", "p_rp_context");
					
					var eleP3 = document.createElement("p");
					var txtP3  = document.createTextNode(value.replyDate);
					eleP3.appendChild(txtP3);
					eleP3.setAttribute("class", "p_rp_date");
					
					eleDiv2.setAttribute("class", "fomatB");
					eleDiv2.appendChild(eleP1);
					eleDiv2.appendChild(eleP2);
					eleDiv2.appendChild(eleP3);
					
					eleDiv3.setAttribute("class", "fomatA")
					eleDiv3.appendChild(eleDiv1);
					eleDiv3.appendChild(eleDiv2);
					
					var replyDiv = document.getElementById("replyDiv");
					replyDiv.appendChild(eleDiv3);
				})
			}	
		})			
	}

	function viewArticle(ArticleNo){
		$.ajax({
			type:"get",
			url:"${pageContext.request.contextPath}/showArticleServlet",
			dataType:"json",
			data:{"PostNo":ArticleNo},
			success:function(data){
				var obj = data;
				$('#postModalLabel').text(data.postTitle);				 
				$('#fullImg').attr("src","${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=F&&pathImg="+data.pathPhoto);			 	
				$('#artiNo').text(' '+data.postNo);
				$('#artiMem').text(' '+data.memberId);
				$('#artiPlace').text(' --'+data.AttractionsNo);
				$('#artiDate').text(' '+data.postDate);
				$('#artiContext').text(' '+data.postContent);
				$('#artiScore').text(' '+data.avgScore+'顆星');
				$('#artiView').text(' '+data.viewTotal+' views');				
// 				var childWindow = document.getElementById("myFrame").contentWindow;//mainFrame這個id是父頁面iframe的id 
//  			childWindow.document;//獲取子頁面中的document對象； txtBlogNo
// 				var childBlogNo = childWindow.document.getElementById("txtBlogNo");
// 				childBlogNo.value = data.postNo;
			}
		 });
	getAllReply(ArticleNo);
	}
</script>
</head>
<body class="homepage">
		<!-- Header -->
<%@include file="/includes/newheader" %>	
		<!-- Main -->
		<div id="main">
			<div class="row mainBody">
					<div class="col-md-3 layoutSide">
						<a href="${pageContext.request.contextPath}/BlogListServlet?Index=0&&pType=ALL" class="btn btn-default btn-lg active btn-block" role="button">日誌列表</a><br>
						<a href="${pageContext.request.contextPath}/blog/postBlog.jsp" class="btn btn-default btn-lg active btn-block" role="button">新增日誌</a><br>
						<a href="#" class="btn btn-default btn-lg active btn-block" role="button">我的日誌</a>
					</div>
					<div class="col-md-7">
						<form action="${pageContext.request.contextPath}/BlogListServlet" method="GET">
						
							<div class="" >
								<span>選擇日誌類型</span>
								<input type="radio" name="pType" id="type1" value="ALL" checked>全部
								<input type="radio" name="pType" id="type2" value="TL" > 旅遊					
								<input type="radio" name="pType" id="type3" value="DF" > 美食								
								<input type="radio" name="pType" id="type4" value="ML" > 心情
								<input type="radio" name="pType" id="type5" value="FT" > 搞笑
								<input type="radio" name="pType" id="type6" value="OT" > 其他
							</div>
							<% request.getSession().getAttribute("blogList"); %> 
							<% request.getSession().getAttribute("listIndex");%>
							<% request.getSession().getAttribute("selType");%>
							<div class="row">
							<c:if test="${blogList.size() == 0}"><br><h3>此類型沒有任何文章</h3></c:if>
							<c:forEach var="lists" items="${blogList}">
								<input type="hidden" id="role" value="T" />
								<div class="blogList">
									<img class="blogImg" src="${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=T&&pathImg=${lists.pathPhoto}">
									<br>
									<span class="label label-primary lab-size">日誌編號 </span><span class="dataFont">&nbsp;${lists.postNo}</span>
									<span class="label label-primary lab-size">會員ID</span><span class="dataFont">&nbsp;${lists.memberId}</span>
									<c:choose>
										<c:when test="${lists.postType=='TL'}"><span class="label label-primary lab-size">日誌類型</span><span class="dataFont">&nbsp;旅遊</span></c:when>
										<c:when test="${lists.postType=='DF'}"><span class="label label-primary lab-size">日誌類型</span><span class="dataFont">&nbsp;美食</span></c:when>
										<c:when test="${lists.postType=='ML'}"><span class="label label-primary lab-size">日誌類型</span><span class="dataFont">&nbsp;心情</span></c:when>
										<c:when test="${lists.postType=='FT'}"><span class="label label-primary lab-size">日誌類型</span><span class="dataFont">&nbsp;搞笑</span></c:when>
										<c:when test="${lists.postType=='OT'}"><span class="label label-primary lab-size">日誌類型</span><span class="dataFont">&nbsp;其他</span></c:when>
									</c:choose>
									<span class="label label-primary lab-size">標題 </span><span class="dataFont">&nbsp;${lists.postTitle}</span><br>
									<span class="label label-primary">星級評分</span>&nbsp;${lists.avgScore}顆星
									<span class="label label-primary">瀏覽人數</span>&nbsp;${lists.viewTotal}
									<span class="label label-primary">發文日期</span>&nbsp;${lists.postDate}<br>							
									<span class="label label-primary lab-size">內文</span><span class="dataFont">&nbsp;${lists.postContext}</span>
									<input type="button" value="閱讀全文" class="btn btn-default btn-xs" data-toggle="modal" data-target="#postModal" onclick="viewArticle('${lists.postNo}')">
									<br>
								</div>
							</c:forEach>
							</div>
								<% request.getSession().removeAttribute("blogList"); %> 		  
							<input type="submit" id="btnSend" value="send" style="display:none;">
							<input type="text" name="Index" value="0"  style="display:none;">
						</form>
						<nav>
						  <ul class="pager">
						    <li class="previous" id='previous'><a href='#'><span aria-hidden="true">&larr;上一頁</span></a></li>
						    <li class="next" id="next"><a href='#'> <span aria-hidden="true">下一頁 &rarr;</span></a></li>
						  </ul>
						</nav>
			
						<!-- 互動視窗 -->
						<div class="modal fade" id="postModal" tabindex="-1" role="dialog" aria-labelledby="postModalLabel" aria-hidden="true" >
						  <div class="modal-dialog modal-lg">
						    <div class="modal-content">
						      <div class="modal-header">		
						        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
						        <div class="col-md-1"></div>
						        <h3 class="modal-title" id="postModalLabel"></h3>
						        <div class="col-md-1"></div>
						      </div>
						      <div class="modal-body" id="postModalBody">
						      		<div class="row">
										<!-- Blog顯示完整文章 -->			  
							        	<div class="col-md-6 thumbnail" style="padding-left:0px;margin-left:55px">
							        		<img src="" id="fullImg" style="width:400px;">
							        	</div>
			
							        	<div class="col-md-5" style="padding-left:0px;margin-left:15px"">
							        		日誌編號 <span id="artiNo" class="arti"></span><br><br>
							        		<span id="artiMem" class="arti"></span>
							        		在<span id="artiPlace" class="arti"></span><br><br>
							        		於<span id="artiDate" class="arti"></span>
							        		說<br><br>
							        		<span id="artiContext" class="arti"></span><br><br>
							        		星級 <span id="artiScore" class="arti"></span>
							        		瀏覽次數<span id="artiView" class="arti"></span><br><br>
							        		
			<%-- 				        		<iframe src="${pageContext.request.contextPath}/blog/blogReply.jsp"  --%>
			<!-- 				        			id="myFrame" width="100%" height="500px" frameborder="1" scrolling="auto"></iframe> -->
											<div id="replyDiv" class="replyfomat"></div>			
											<textarea class="form-control" rows='3' placeholder="回點什麼吧..."
												style="resize: none;width:300px;float:left" id="txtRely"></textarea>
											<input type="button" class="btn btn-primary" value="留言" style="float: right;" id="btnReply">
							        	</div>
						        	</div>
						      </div>
						      <div class="modal-footer">
						        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						      </div>
						    </div>
						  </div>
						</div>		
							
					</div>
					<div class="col-md-2 layoutSide"></div>	
			</div>			
		</div>
		
		<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Design: <a href="http://templated.co">TEMPLATED</a> Images: <a href="http://unsplash.com">Unsplash</a> (<a href="http://unsplash.com/cc0">CC0</a>)
			</div>
		</div>
		<%@include file="/includes/logout" %>
</body>
<script type="text/javascript">
 (function($){ 	
	 $("[name='Index']").val('${listIndex}');
	 var selectedType = "${selType}";
	 if(selectedType=="ALL"){ $('#type1').attr('checked','true')}
	 if(selectedType=="TL"){ $('#type2').attr('checked','true')}
	 if(selectedType=="DF"){ $('#type3').attr('checked','true')}
	 if(selectedType=="ML"){ $('#type4').attr('checked','true')}
	 if(selectedType=="FT"){ $('#type5').attr('checked','true')}
	 if(selectedType=="OT"){ $('#type6').attr('checked','true')}
	 
	 $("[name='pType']").change(function(){
		 $('#btnSend').click();
	 })
	 
	 $("[name='pType']").attr('selected', true);
// 	 if($('#role').val()!="T"){ 
// 		 $("[name='Index']").val('0');
// 		 $('#btnSend').click();
// 	 }
	 
	 $("#selectGroup").change(function(){
		 $('#btnSend').click();
	 })
	 
	 $('#previous').click(function(){
		 var index = $("[name='Index']").val();
		 var newIndex = parseInt(index)-10;
		 if(newIndex<0){
			 $("[name='Index']").val('0');
		 }else{
			 $("[name='Index']").val(newIndex);
		 }
		 $('#btnSend').click();
	 });
	 $('#next').click(function(){
		 var index = $("[name='Index']").val();
		 var newIndex = parseInt(index)+10;
		 $("[name='Index']").val(newIndex);
		 $('#btnSend').click();		 
	 });
	 	
	$('#btnReply').click(function(){
		var ArticleNo = $('#artiNo').text().trim();
		var context = $('#txtRely').val();

		if(context!=''){
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/ReplyAddServlet",
				dataType:"json",
				data:{"ArticleNo":ArticleNo,"replyContex":context},
				success:function(data){		

					if(data=='failed'){
						alert('新增留言失敗，請重試一次');
					}else{
						$('#txtRely').val('');
						getAllReply(ArticleNo);
					}	
				}	
			})
		}
	})
	
	
 }(jQuery));
 </script>
</html>