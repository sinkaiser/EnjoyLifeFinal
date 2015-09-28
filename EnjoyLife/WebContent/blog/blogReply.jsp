<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" >
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.min.css" />
<script	type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
<script type="text/javascript" src="http://www.pureexample.com/js/lib/jquery.ui.touch-punch.min.js"></script>

<style>
	.replyfomat{
		border:1px solid #DDDDDD;
		display:block;
		margin-bottom:5px;
	}
	.fomatF{
		border:1px solid #DDDDDD;
		display:block;
		padding:15px 15px 10px 10px;
		width:60px;	
		float:left; 
		margin:5 auto;
	}
	.fomatB{
		display:inline-block;
		padding:15px 15px 15px 35px;
		margin-bottom:5px;
		width:250px;
		word-break: break-all;
		background-image:url('${pageContext.request.contextPath}/GetImg?imgid=${member.picture}');
		background-size:100% 100%;
	}
</style>

</head>
<body>
	<input type="text" id="txtBlogNo" >
	<div class="replyfomat">
		<div class="fomatF">
			<div>
			<img src="../images/bao.png"><br>
			</div>			
		</div>
		<div class="fomatB">
			<h5><a href="#">baobaobaobao</a>說:</h5>
			<h5>hahaha...hahaha...hahaha...hahaha...</h5><span>2015/09/22 05:30</span>
		</div>
	</div>
	<textarea class="form-control" rows='3' placeholder="回點什麼吧..."
		style="resize: none;width:250px;float:left" id="txtRely"></textarea>
	<input type="button" value="留言" style="float: right;" id="btnReply">
</body>
<script type="text/javascript">
	(function($){

		function getAllReply(){
			var ArticleNo = $('#txtBlogNo').val();
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/GetReplyServlet",
				dataType:"json",
				data:{"ArticleNo":ArticleNo},
				success:function(data){		
				
				}	
			})			
		}
		
		$('#btnReply').click(function(){
			var ArticleNo = $('#txtBlogNo').val();
			var context = $('#txtRely').val();
			$.ajax({
				type:"get",
				url:"${pageContext.request.contextPath}/ReplyAddServlet",
				dataType:"json",
				data:{"PostNo":ArticleNo,"replyContex":context},
				success:function(data){		
					if(data=='failed'){
						alert('新增留言失敗，請重試一次');
					}else{
						
					}
				}	
			})
		})
	}(jQuery))
</script>
</html>