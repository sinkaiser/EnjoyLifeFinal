<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ENJOY LIFE</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href='http://fonts.googleapis.com/css?family=Arimo:400,700' rel='stylesheet' type='text/css'>
	<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/bootstrap.min.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/jquery-ui.min.css' type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>	
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/skel-noscript.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style.css' type="text/css" />
	<link rel='stylesheet' href='${pageContext.request.contextPath}/css/style-desktop.css' type="text/css" />
	<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	<!--[if lte IE 9]><link rel="stylesheet" href="css/ie/v9.css" /><![endif]-->
<style>
	*{
		max-width:1280px;
		margin:0 auto
	}
	.drag {
		opacity:0.8;
		width: 150px;
		height: 100px;
		cursor: pointer;
		border-radius: 5px;
		text-algin: center;
		background-image:url('${pageContext.request.contextPath}/images/dig/dialog001.png');
		background-size:100% 100%;
	}
	.divPartA{
		border: 5px solid #428bca;
		padding:10px;
		margin:10px;
		box-shadow:5px 5px 15px rgba(10,125,225,0.4);
	}	
	.divPartB{
		width:400px;
		margin-left:1px;
		float:left;
		box-shadow:5px 5px 15px rgba(10,125,225,0.4);
	}	
	.pos_abs{
		position: absolute;
	}
	.divBox{
		width: 400px; 
		height: 300px; 
		border: 3px solid #428bca;
		position: relative ;
		display:inline-block;
	}
	.divBox div span{
		top: 30%; 
		left: 20%;
	}
	.divBox div input{
		top: 30%; 
		left: 25%; 
		width:50% ;
	}
	.hiddened{
		display:none;
	}
</style>

</head>
<body class="homepage">
		<!-- Header -->
	<%@include file="/includes/newheader" %>	
		<!-- Main -->
		<div id="main">
			<div class="row">
					<div class="col-md-3">
						<a href="${pageContext.request.contextPath}/BlogListServlet?Index=0&&pType=ALL" class="btn btn-default btn-lg active btn-block" role="button">日誌列表</a><br>
						<a href="${pageContext.request.contextPath}/blog/postBlog.jsp" class="btn btn-default btn-lg active btn-block" role="button">新增日誌</a><br>
						<a href="#" class="btn btn-default btn-lg active btn-block" role="button">我的日誌</a>
					</div>
					<div class="col-md-8">
						<form action="${pageContext.request.contextPath}/BlogPostServlet" method="post" enctype="application/x-www-form-urlencoded">
						
						<div class="divPartA form-inline">
							<jsp:useBean id="blogType" scope="page"	class="com.blog.controller.BlogSortService" />
							<label>日誌類型</label> 
							<select size="1" name="bType" class=":foucs">
								<c:forEach var="SortVO" items="${blogType.all}">
									<option value="${SortVO.postType}">${SortVO.postTypeName}</option>
								</c:forEach>
							</select> 
							
							<label>日誌標題</label><input type="text" name="bTitle" class="form-control" maxlength="10" style="width:200px"> 
							<br>
							<label>簡單描述</label>&nbsp;&nbsp;&nbsp;<span id="nowtxt"></span><br>
							<textarea id="INtext" name="bContext" class="form-control" style="width: 400px; height: 50px; resize:none"></textarea>
							
							<label>景點</label><input type="text" id="findAttrc" name="bPlace" class="form-control" style="width:200px" maxlength="20">
							
							<input id="send" class="btn btn-lg" type="submit" value="發布日誌" 
								style="background-color:#428bca;color:#DDDDDD">
							<c:if test="${!empty ErrorMsg}">
								<div class="alert alert-danger" role="alert">
								  <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
								  <span class="sr-only">Error:</span>
								  ${ErrorMsg}
								</div> 
							</c:if>
						</div>
						
						<div class="divPartB">
							<div id="box1" class="divBox">
								<canvas id="cvs1" name="bCanvas1" class="pos_abs"></canvas>
								<div id="dialog1" class="drag pos_abs">
									<span id="sp1" class="pos_abs" >雙擊輸入內容</span>
									<input type="text"  class="pos_abs" name="txtInput1" style="visibility:hidden">
								</div>
							</div>
							<input id="btnUpload1" type="file" accept="image/*" style="width:80px;display:inline">
							<label>選擇對話框樣式</label>
							<select id="selDialog1" name="dialog1"></select>
							<label>文字大小</label>
							<select id="selFontsize1" name="fontsize1"></select>	
							<div class="hiddened">
								<input type="text" value="0" name="dialogInfo1" ><input type="text" value="" name="img1Base64" >
							</div>				
						</div>
						
						<div class="divPartB">
							<div id="box2" class="divBox">
								<canvas id="cvs2" name="img2" class="pos_abs"></canvas>
								<div id="dialog2" class="drag pos_abs">
									<span id="sp2" class="pos_abs">雙擊輸入內容</span>
									<input type="text" class="pos_abs" name="txtInput2" style="visibility:hidden">
								</div>
							</div>
							<input id="btnUpload2" type="file" accept="image/*" style="width:80px;display:inline">
							<label>選擇對話框樣式</label>
							<select id="selDialog2" name="dialog2"></select>
							<label>文字大小</label>
							<select id="selFontsize2" name="fontsize2"></select>
							<div class="hiddened">
								<input type="text" value="0" name="dialogInfo2" ><input type="text" value="" name="img2Base64" >	
							</div>				
						</div>
						<div class="divPartB">
							<div id="box3" class="divBox">
								<canvas id="cvs3" name="img3" class="pos_abs"></canvas>
								<div id="dialog3" class="drag pos_abs">
									<span id="sp3" class="pos_abs">雙擊輸入內容</span>
									<input type="text" class="pos_abs" name="txtInput3" style="visibility:hidden">
								</div>
							</div>
							<input id="btnUpload3" type="file" accept="image/*" style="width:80px;display:inline">
							<label>選擇對話框樣式</label>
							<select id="selDialog3" name="dialog3"></select>
							<label>文字大小</label>
							<select id="selFontsize3" name="fontsize3"></select>
							<div class="hiddened">
								<input type="text" value="0" name="dialogInfo3" ><input type="text" value="" name="img3Base64" >		
							</div>								
						</div>
						<div class="divPartB">
							<div id="box4" class="divBox">
								<canvas id="cvs4" name="img4" class="pos_abs"></canvas>
								<div id="dialog4" class="drag pos_abs">
									<span id="sp4" class="pos_abs">雙擊輸入內容</span>
									<input type="text" class="pos_abs" name="txtInput4" style="visibility:hidden">
								</div>
							</div>
							<input id="btnUpload4" type="file" accept="image/*" style="width:80px;display:inline">
							<label>選擇對話框樣式</label>
							<select id="selDialog4" name="dialog4"></select>
							<label>文字大小</label>
							<select id="selFontsize4" name="fontsize4"></select>			
							<div class="hiddened">
								<input type="text" value="0" name="dialogInfo4" ><input type="text" value="" name="img4Base64" >		
							</div>	
						</div>											
						</form>					
					</div>				
			</div>					
		</div>
		
		<!-- Copyright -->
		<div id="copyright">
			<div class="container">
				Enjoy Life
			</div>
		</div>
		<%@include file="/includes/logout" %>
</body>
<script type="text/javascript">
(function($){
	for(var i=1;i<=4;i++){			
		var objSel = document.getElementById('selDialog'+i);
		for(var j=1;j<10;j++){
			var eleOpt = document.createElement("option");
			eleOpt.setAttribute('value','dialog00'+j);
			var txtOpt = document.createTextNode('樣式('+j+')');								
			eleOpt.appendChild(txtOpt);
			objSel.appendChild(eleOpt);
		}
		var objSize = document.getElementById('selFontsize'+i);
		for(var k=14;k<=28;k=k+2){
			var eleOpt = document.createElement("option");
			eleOpt.setAttribute('value',k+'pt');
			var txtOpt = document.createTextNode(k+'pt');		
			eleOpt.appendChild(txtOpt);
			objSize.appendChild(eleOpt);
		}
	}
	
	for(var i=1;i<=4;i++){
		$("#dialog"+i).draggable({
			containment : "#box"+i,
			scroll : false
		}).resizable({
			 containment: "#box"+i
		 });
		$("#sp"+i).draggable({
			containment : "#dialog"+i,
			scroll : false
		});
	}
	
	$("#btnUpload1").unbind("change").on("change", function() {
		var file = this.files[0];
		if (file) {
			if (file.type && !/image/i.test(file.type)) {//验证图片文件类型
				return false;
			}
			var reader = new FileReader();
			reader.onload = function(e) {
				render(e.target.result,document.getElementById('cvs1'),1);//readAsDataURL后执行onload，进入图片压缩逻辑	//e.target.result得到的就是图片文件的base64 string
			};		
			reader.readAsDataURL(file);//以dataurl的形式读取图片文件
		}
	});
	$("#btnUpload2").unbind("change").on("change", function() {
		var file = this.files[0];
		if (file) {
			if (file.type && !/image/i.test(file.type)) {//验证图片文件类型
				return false;
			}
			var reader = new FileReader();
			reader.onload = function(e) {
				render(e.target.result,document.getElementById('cvs2'),2);//readAsDataURL后执行onload，进入图片压缩逻辑	//e.target.result得到的就是图片文件的base64 string
			};			
			reader.readAsDataURL(file);//以dataurl的形式读取图片文件
		}
	});
	$("#btnUpload3").unbind("change").on("change", function() {
		var file = this.files[0];
		if (file) {
			if (file.type && !/image/i.test(file.type)) {//验证图片文件类型
				return false;
			}
			var reader = new FileReader();
			reader.onload = function(e) {
				render(e.target.result,document.getElementById('cvs3'),3);//readAsDataURL后执行onload，进入图片压缩逻辑	//e.target.result得到的就是图片文件的base64 string
			};			
			reader.readAsDataURL(file);//以dataurl的形式读取图片文件
		}
	});
	$("#btnUpload4").unbind("change").on("change", function() {
		var file = this.files[0];
		if (file) {
			if (file.type && !/image/i.test(file.type)) {//验证图片文件类型
				return false;
			}
			var reader = new FileReader();
			reader.onload = function(e) {
				render(e.target.result,document.getElementById('cvs4'),4);//readAsDataURL后执行onload，进入图片压缩逻辑	//e.target.result得到的就是图片文件的base64 string
			};			
			reader.readAsDataURL(file);//以dataurl的形式读取图片文件
		}
	});

	var MAX_WIDTH = 400;
	var MAX_HEIGHT = 300;
	var render = function(src, canvas, i) {
		var image = new Image();
		image.onload = function() {
			var w = image.width;
			var h = image.height;
			//计算压缩后的图片长和宽
			if (h != MAX_HEIGHT) {
				w = MAX_WIDTH;
				h = MAX_HEIGHT;
			}
			var ctx = canvas.getContext("2d");
			canvas.width = w;
			canvas.height = h;
			//将图片绘制到Canvas上，从原点0,0绘制到w,h
			ctx.drawImage(image, 10, 10, w - 20, h - 20); //畫出邊框
			canvas.toDataURL();
			$("[name='img"+i+"Base64']").val(canvas.toDataURL());
		};
		image.src = src;
	};
		
	$('#dialog1').dblclick(function(){
		$('#dialog1>input').css('visibility','visible');
		$('#dialog1>span').css('visibility','hidden') ;
		$('#dialog1>input').focus();
	})
	$('#dialog2').dblclick(function(){
		$('#dialog2>input').css('visibility','visible');
		$('#dialog2>span').css('visibility','hidden') ;
		$('#dialog2>input').focus();
	})
	$('#dialog3').dblclick(function(){
		$('#dialog3>input').css('visibility','visible');
		$('#dialog3>span').css('visibility','hidden') ;
		$('#dialog3>input').focus();
	})
	$('#dialog4').dblclick(function(){
		$('#dialog4>input').css('visibility','visible');
		$('#dialog4>span').css('visibility','hidden') ;
		$('#dialog4>input').focus();
	})
	
	$('#dialog1>input').blur(function(){
		$('#dialog1>input').css('visibility','hidden');
		$('#dialog1>span').css('visibility','visible');
		$('#dialog1>span').text($('#dialog1>input').val());
	});
	$('#dialog2>input').blur(function(){
		$('#dialog2>input').css('visibility','hidden');
		$('#dialog2>span').css('visibility','visible');
		$('#dialog2>span').text($('#dialog2>input').val());
	});
	$('#dialog3>input').blur(function(){
		$('#dialog3>input').css('visibility','hidden');
		$('#dialog3>span').css('visibility','visible');
		$('#dialog3>span').text($('#dialog3>input').val());
	});
	$('#dialog4>input').blur(function(){
		$('#dialog4>input').css('visibility','hidden');
		$('#dialog4>span').css('visibility','visible');
		$('#dialog4>span').text($('#dialog4>input').val());
	});
	 
	$('#selDialog1').change(function(){
		var picName = $(this).val();
		if(picName!=''){
			$('#dialog1').css('background-image','url(${pageContext.request.contextPath}/images/dig/'+picName+'.png)');
		}else{
			$('#dialog1').css('background-image','url()');
		}
	}) 
	$('#selDialog2').change(function(){
		var picName = $(this).val();
		if(picName!=''){
			$('#dialog2').css('background-image','url(${pageContext.request.contextPath}/images/dig/'+picName+'.png)');
		}else{
			$('#dialog2').css('background-image','url()');
		}
	}) 
	$('#selDialog3').change(function(){
		var picName = $(this).val();
		if(picName!=''){
			$('#dialog3').css('background-image','url(${pageContext.request.contextPath}/images/dig/'+picName+'.png)');
		}else{
			$('#dialog3').css('background-image','url()');
		}
	}) 
	$('#selDialog4').change(function(){
		var picName = $(this).val();
		if(picName!=''){
			$('#dialog4').css('background-image','url(${pageContext.request.contextPath}/images/dig/'+picName+'.png)');
		}else{
			$('#dialog4').css('background-image','url()');
		}
	}) 
	
	$('#selFontsize1').change(function(){
		var textSize = $(this).val();
		$('#dialog1>span').css('font-size',textSize);
	})		
	$('#selFontsize2').change(function(){
		var textSize = $(this).val();
		$('#dialog2>span').css('font-size',textSize);
	})		
	$('#selFontsize3').change(function(){
		var textSize = $(this).val();
		$('#dialog3>span').css('font-size',textSize);
	})		
	$('#selFontsize4').change(function(){
		var textSize = $(this).val();
		$('#dialog4>span').css('font-size',textSize);
	})		
	
	$('#send').click(function(){	
		var dT1 = $('#dialog1').position().top-$('#cvs1').position().top+',';
		var dL1 = $('#dialog1').position().left-$('#cvs1').position().left+',';
		var dW1 = $('#dialog1').css('width') + ','  ;
		var dH1 = $('#dialog1').css('height') + ',' ;
		var tT1 = $('#dialog1>span').position().top-$('#cvs1').position().top+','
		var tL1 = $('#dialog1>span').position().left-$('#cvs1').position().left ;
		$("[name='dialogInfo1']").val(dT1+ dL1+ dW1+ dH1+ tT1+ tL1);	
	
		var dT2 = $('#dialog2').position().top-$('#cvs2').position().top+',';
		var dL2 = $('#dialog2').position().left-$('#cvs2').position().left+',';
		var dW2 = $('#dialog2').css('width') + ','  ;
		var dH2 = $('#dialog2').css('height') + ',' ;
		var tT2 = $('#dialog2>span').position().top-$('#cvs2').position().top+','
		var tL2 = $('#dialog2>span').position().left-$('#cvs2').position().left ;
		$("[name='dialogInfo2']").val(dT2+ dL2+ dW2+ dH2+ tT2+ tL2);	
		
		var dT3 = $('#dialog3').position().top-$('#cvs3').position().top+',';
		var dL3 = $('#dialog3').position().left-$('#cvs3').position().left+',';
		var dW3 = $('#dialog3').css('width') + ','  ;
		var dH3 = $('#dialog3').css('height') + ',' ;
		var tT3 = $('#dialog3>span').position().top-$('#cvs3').position().top+','
		var tL3 = $('#dialog3>span').position().left-$('#cvs3').position().left ;
		$("[name='dialogInfo3']").val(dT3+ dL3+ dW3+ dH3+ tT3+ tL3);	
	
		var dT4 = $('#dialog4').position().top-$('#cvs4').position().top+',';
		var dL4 = $('#dialog4').position().left-$('#cvs4').position().left+',';
		var dW4 = $('#dialog4').css('width') + ','  ;
		var dH4 = $('#dialog4').css('height') + ',' ;
		var tT4 = $('#dialog4>span').position().top-$('#cvs4').position().top+','
		var tL4 = $('#dialog4>span').position().left-$('#cvs4').position().left ;
		$("[name='dialogInfo4']").val(dT4+ dL4+ dW4+ dH4+ tT4+ tL4);		
	})
	
	var n = 150-($("#INtext").val().length+1);
    $('#nowtxt').html('<b>剩餘:'+n+'字</b>');
    $('#INtext').keydown(function(){
        n = 150-($("#INtext").val().length+1);
        $('#nowtxt').html('<b>剩餘:'+n+'字</b>');
    });
    $('#INtext').blur(function(){
        n = 150-($("#INtext").val().length+1);
        $('#nowtxt').html('<b>剩餘:'+n+'字</b>');
        if( n<0 ){
            alert('提醒: 字數太多了!');
            return false;
        }
    });
    $('#Submit').click(function(){
        n = 150-($("#INtext").val().length+1);
        if( n<0 ){
            alert('提醒: 字數太多了!');
            return false;
        }
    });
    
    $("#findAttrc").autocomplete({
        source: function(request, response) {
        $.ajax({
        url: "${pageContext.request.contextPath}/SearchAttracServlet",
        type: "POST",
        dataType: "json",
        data: { name: request.term},
        success: function( data ) {               
            response( $.map( data, function( item ) {
            return {
                label: item.attrno+"__"+item.attrname,
                value: item.attrno+"__"+item.attrname,
            }
            }));
        },
        error: function (error) {
           alert('error: ' + error);
        }
        });
        },
        minLength: 2
        });    
}(jQuery));	
</script>
</html>