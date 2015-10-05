<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>景點列表</title>
<script src="scripts/jquery-2.1.4.min.js"></script>
<link rel="stylesheet" href="scripts/bootstrap.min.css">
<script src="scripts/bootstrap.min.js"></script>
<script src="scripts/jquery-ui.js"></script>
<link rel='stylesheet' href='../css/skel-noscript.css' type="text/css" />
<link rel='stylesheet' href='../css/style.css' type="text/css" />
<link rel='stylesheet' href='../css/style-desktop.css' type="text/css" />
<style type="text/css">
#listselects{width:170px;position:fixed;left:80px;border:5px ridge gray;padding:10px;margin-top:110px;}
#butt1{margin:10px auto}
#ul1{width:1280px;margin:20px 0px 0px 280px;height:auto;}
#li1{list-style:none;width:220px;float:left;margin-left:5px;}
li div {border:5px ridge gray;padding: 5px;margin-bottom:5px;word-break:break-all }
li div img {width:200px;margin:5px auto;display:block;}
li div p{text-align: center;font-size: 20px;font-family:標楷體;}
.select{width:140px;font-size: 18px;height:4ex;border-radius:15px;margin:5px auto}
#creattable {border:2px double black;font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
		font-size: 20px;margin: 0px auto;width: 600px;text-align: left;border-collapse: collapse;position: relative;table-layout:fixed;}
table {	border:2px double black;font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;font-size: 20px;
	 	margin: 0px auto; width: 850px;text-align: left;border-collapse: collapse;position: relative;table-layout:fixed;}
td {	font-size: 22px;padding: 8px;background: #e8edff;color: #669;border-top:2px double black;border-bottom: 2px double black;vertical-align: middle;}
tr:hover td {background: #d0dafd;color: #339;}
.input{	width: 450px;}
.xbody{height:100px;width:450px;resize:none;overflow:auto;}
#title{text-align:center; border:2px double black;font-size: 22px;width:130px;}
#cate1no {font-size: 18px;height:4ex}
#cate2no {font-size: 18px;height:4ex}

.homepage{padding-top:110px;}
#imgti{border:0px;padding: 0px;margin-bottom:0px;width:202px;}
#imgti > label,#imgti > button{position:relative;top:-35px;left:61px;}
#headerimg{height:65px;width:60px;margin:0px;display:block;margin-right:0px}
</style>
</head>
<body class="homepage">
<%@include file="/includes/newheader" %>
<nav style="width:100%;text-align:center;" >
		<div class="btn-group" role="group"  style="width:500px;left:30px;" aria-label="..." >
			<a href="${pageContext.request.contextPath}/attrac/Attracimg1.jsp"><button type="button" class="btn btn-primary" style="width:100px;margin-right:20px" >景點列表</button></a>
			<a href="${pageContext.request.contextPath}/attrac/Attracdesign.jsp"><button type="button" class="btn btn-primary" style="width:100px;margin-left:20px" >規劃</button></a>
		</div>	
</nav>
<div id="listselects">
			<select id="select1" class="select" >            
	       </select><br>
	       <select id="select2" class="select" >            
	       </select><br>
	       <select id="select3" class="select" >            
	       </select><br>
	       <select id="select4" class="select" >            
	       </select>
			<button id="butt1" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal2" value="creat" style="width:135px">
			新增景點
			</button>
	<img id="loadimg" src="Data/ajax-loader.gif" style="display:none;width: 140px" >
</div>

	<div id="listdiv">
	<ul id="ul1">
		<li id="li1"></li>
		<li id="li1"></li>
		<li id="li1"></li>
		<li id="li1"></li>		
	</ul>
	</div>
<div id="myModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
  <div class="modal-dialog modal-lg">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><img src="Data/glyphicons-208-remove-2.png" width="24px"></button>
      </div>
      <div  class="modal-body" >
		<table >	
		<tr>
		<td id="title">標題
			<input  type="hidden" name="picmode" />			
			<td id="stitle" colspan="3"></td>
		</tr>	
		<tr>
		<td id="title">分類一
			<td id="cate1" colspan="3"></td>
		</tr>		
		<tr>
		<td id="title">分類二
			<td id="cate2" colspan="3"></td>
		</tr>
		<tr>
		<td id="title">開放時間
			<td id="time" colspan="3"></td>
		</tr>
		<tr>
		<td id="title">地址
			<td id="addr" colspan="3"></td>
		</tr>		
		<tr>
		<td id="title">捷運
		<td id="mrt" colspan="3"></td>
		</tr>
		<tr>
		<td id="title">簡介
		<td  colspan="3">
		<div id="info"  ></div>
		</td>
		</tr>	
		<tr>
		<td id="title">內容
		<td colspan="3" >
			<div id="xbody"  ></div>
		</td>
		</tr>	 	
		<tr>
		<td id="title">照片
		<td colspan="3" > 
			<div  id="result" ></div>
		</td>
		</tr>
		</table>
		<div class="modal-footer">
			<input type="button" class="btn btn-primary" value="確定" data-dismiss="modal" style="width:80px;height:30px;font-size:15px;" >
		</div>	
      </div>
    </div>
  </div>
</div>

 <div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" style="border:5px solid;">
  <div class="modal-dialog" role="document" id="doc" style="width:700px">
    <div class="modal-content" style="width:700px">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><img src="Data/glyphicons-208-remove-2.png" width="24px"></button>
      </div>
      <div  class="modal-body" style="width:700px;">
        <s:form action="myAction3"  method="post">
		<table id="creattable">	
		<tr>
		<td id="title">標題
			<input  type="hidden" name="picmode" />			
			<td colspan="3"><input type="text" class="input" name="bean.stitle"></td>
		</tr>	
		<tr>
		<td id="title">分類一
			<td colspan="3"><select id="cate1no" class="form-control"  name="bean.cat1no"></select></td>
		</tr>		
		<tr>
		<td id="title">分類二
			<td colspan="3"><select id="cate2no" class="form-control"  name="bean.cat2no"></select></td>
		</tr>
		<tr>
		<td id="title">開放時間
			<td colspan="3"><input type="text" class="input" name="bean.time"></td>
		</tr>
		<tr>
		<td id="title">地址
		<td colspan="3"><input type="text" class="input" name="bean.address"></td>
		</tr>		
		<tr>
		<td id="title">捷運
		<td colspan="3"><input type="text" class="input" name="bean.mrt"></td>
		</tr>
		<tr>
		<td id="title">簡介
		<td colspan="3"><input type="text" class="input" name="bean.info"></td>
		</tr>	
		<tr>
		<td id="title">內容
		<td colspan="3"><textarea class="xbody" name="bean.xbody"></textarea></td>
		</tr>	 	
		<tr>
		<td id="title">照片
		<td colspan="3" >
			<input type="file" id="file_input" accept="image/jpeg, image/png, image/gif, image/jpg"  multiple style="width:80px;height:30px;font-size:15px"/>  
			<div  id="selectpic" style="height:200px;overflow:auto;"></div>
		</td>
		</tr>
		</table>
		<div class="modal-footer">
	        <input type="button" id="cancelbut" class="btn btn-default" value="取消" data-dismiss="modal" style="width:80px;height:30px;font-size:15px">
			<input type="submit" class="btn btn-primary" value="確定" style="width:80px;height:30px;font-size:15px;" >
		</div>
		</s:form> 		
      </div>
    </div>
  </div>
</div>

<script>		
(function($){
	var oul=document.getElementById("ul1");
	var oli=oul.getElementsByTagName("li");
	var loadimg =document.getElementById("loadimg")
	var lilen=oli.length;
	var offset=0;
	var door=true;
	$.ajax({
		url:"${pageContext.request.contextPath}/GetCate1Servlet",
		type:"get",
		dataType:"json",
		success:function(data){
			$.each(data,function(){
				if(this.cate1no!=null){
					var cate1no=this.cate1no;
					var cate1name=this.cate1name;
					var opt=$("<option></option>").val(cate1no).text(cate1name);
					var opt2=$("<option></option>").val(cate1no).text(cate1name);
					$("#select1").append(opt);
					$("#cate1no").append(opt2);
				}else if(this.countyno!=null){
					var countyno=this.countyno;
					var countyname=this.countyname;
					var opt=$("<option></option>").val(countyno).text(countyname);
					$("#select3").append(opt);
				}			
			})							
	
			$.ajax({
				url:"${pageContext.request.contextPath}/GetCateDistServlet",
				type:"get",
				dataType:"json",
				data:{"cate1no":$("#select1").val(),"countyno":$("#select3").val()},
				success:function(data){
					$.each(data,function(){
						if(this.cate2no!=null){
							var cate2no=this.cate2no;
							var cate2name=this.cate2name;
							var opt=$("<option></option>").val(cate2no).text(cate2name);
							var opt2=$("<option></option>").val(cate2no).text(cate2name);
							$("#select2").append(opt);
							$("#cate2no").append(opt2);
						}else if(this.distno!=null){
							var distno=this.distno;
							var distname=this.distname;
							var opt=$("<option></option>").val(distno).text(distname);
							$("#select4").append(opt);
						}						
					})
					offset=0;
					getlist();
				}
			})
		}
	})
	
	$('#file_input').change(function(){
			var selectpic = document.getElementById("selectpic"); 
			var input = document.getElementById("file_input"); 
			var files = this.files 
			console.log(files.length)
			var i=0;
			$('#selectpic').empty();
			if(files.length>4){
				alert("請只能選擇四張照片")
			}else{
				while(i<files.length){
					var file=files[i];
					var reader = new FileReader(); 
					reader.readAsDataURL(file); 
					var j=1;
					reader.onload = function(e){ 
					selectpic.innerHTML += '<img  height="150" width="200" src="'+this.result+'" id="img'+j+'" /><input type="hidden" name="picstring" value="['+this.result+']" />' 
					j++;
					} 		
					i++;
				}
			}
	})	
	$("#select4").change(function(){
		$("#ul1 li").empty();
		offset=0;
		getlist();
	});
	$("#select2").change(function(){
		$("#ul1 li").empty();
		offset=0;
		getlist();
	});	
	$("#cate1no").change(function (){
		$.ajax({
			url:"${pageContext.request.contextPath}/GetCate2Servlet",
			type:"get",
			dataType:"json",
			data:{"cate1no":$("#cate1no").val()},
			success:function(data){
				$("#cate2no option").remove();
				$.each(data,function(){
					var cate2no=this.cate2no;
					var cate2name=this.cate2name;
					var opt=$("<option></option>").val(cate2no).text(cate2name);
					$("#cate2no").append(opt);						
				})
			}
		})
	});
	$("#select1").change(function (){
		$.ajax({
			url:"${pageContext.request.contextPath}/GetCate2Servlet",
			type:"get",
			dataType:"json",
			data:{"cate1no":$("#select1").val()},
			success:function(data){
				$("#ul1 li").empty();
				$("#select2 option").remove();
				$.each(data,function(){
					var cate2no=this.cate2no;
					var cate2name=this.cate2name;
					var opt=$("<option></option>").val(cate2no).text(cate2name);
					$("#select2").append(opt);						
				})
				offset=0;
				getlist();
			}
		})
	});
	$("#select3").change(function (){
		$.ajax({
			url:"${pageContext.request.contextPath}/GetDistServlet",
			type:"get",
			dataType:"json",
			data:{"countyno":$("#select3").val()},
			success:function(data){
				$("#select4 option").remove();
				$.each(data,function(){
					var distno=this.distno;
					var distname=this.distname;
					var opt=$("<option></option>").val(distno).text(distname);
					$("#select4").append(opt);						
				})
				$("#ul1 li").empty();
				offset=0;
				getlist();
			}
		})
	});
	function getlist(){	
		loadimg.style.display="inline";
		$.ajax({
	 		url:"GetPhoto2.jsp",
	 		type:"get",
	 		dataType:"json",
	 		data:{"offset":offset,
	 			"cate1no":$("#select1").val(),
	 			"cate2no":$("#select2").val(),
	 			"countyno":$("#select3").val(),
	 			"distno":$("#select4").val()},
	 		success:function(data){
	 			if(data.length==0){
	 				loadimg.style.display="none";
	 				return;
	 			}
				loadimg.style.display="none";
	 			$.each(data,function(){
	 					var index=getShort();
	 					var stitle=this.stitle;
	 					var attracno=this.attracNo;
	 					var photodata=this.photodata;
	 					var adddiv=document.createElement("div");
	 					var addimg=document.createElement("img");
	 					adddiv.id=attracno;					
	 					addimg.src=photodata==null?"Data/nopic.png":photodata;
	 					addimg.style.width="200px";
	 					adddiv.appendChild(addimg);
	 					var addp=document.createElement("p");
	 					addp.innerHTML=stitle;
	 					adddiv.appendChild(addp);
	 					oli[index].appendChild(adddiv);
	 																											
	 			})
				door=true;
	 		}				
		})
	}
	$('#myModal2').on('hidden.bs.modal', function (e) {
		$(":text").val("");
		$(".xbody").val("");
		$("#selectpic").empty();
	})
	
	$("#ul1 li").on('click','div',function(){
		loadimg.style.display="inline";	
		$.ajax({
	 		url:"GetAttracDetail.jsp",
	 		type:"get",
	 		dataType:"json",
	 		data:{"attracno":$(this).attr("id")},
	 		success:function(data){
	 					var result=document.getElementById("result")
	 					$("#result").empty();
	 					loadimg.style.display="none";
	 			$.each(data,function(){
	 					$("#stitle").text(this.stitle);
	 					var attracno=this.attracNo;
	 					$("#addr").text(this.address);
	 					$("#time").text(this.time);
	 					$("#xbody").text(this.xbody);	
	 					$("#mrt").text(this.mrt);
	 					$("#info").text(this.info);
	 					$("#cate1").text(this.cate1name);
	 					$("#cate2").text(this.cate2name);
	 					var photodata=this.photodata;	
	 					var photoname=this.photoname;
						$.each(photoname,function(index,value){
							var addimg=document.createElement("img");
							addimg.src=photodata[index]==null?"Data/nopic.png":photodata[index];
							addimg.alt=photoname[index];
							addimg.style.width="280px";
							result.appendChild(addimg);
	 					})
						$('#myModal').modal('toggle');		 																											
	 			})
	 		}				
		})
	})
	
	
	window.onscroll=function(){
		var index=getShort();
		var ali=oli[index];
		var scrolltop=document.documentElement.scrollTop||document.body.scrollTop
		if($("#select1").val()){
			if(getTop(ali)+ali.offsetHeight < document.documentElement.clientHeight+scrolltop){
				if(door){
					door=false;
					offset+=20;
					getlist();
				}	
			}
		}
	}


	function getShort(){
		var index=0;
		var lih=oli[index].offsetHeight;
		for(var i=1;i<lilen;i++){
			if(oli[i].offsetHeight<lih){
				index=i;
				lih=oli[i].offsetHeight;
			}
		}
		return index;
	}

	function getTop(obj){
		var itop=0;
		while(obj){
			itop += obj.offsetTop;
			obj=obj.offsetParent;
		}
		return itop;
	}

	$(window).bind('scroll resize', function(){
		var $this = $(this);
		var $this_Top=$this.scrollTop();

		if($this_Top < 200){
				$('#listselects').stop().animate({top:"50px"});
		}
		 if($this_Top > 200){
				$('#listselects').stop().animate({top:"50px"});
		}
	}).scroll();
	
})(jQuery);
</script>
<%@include file="/includes/logout" %>
</body>
</html>