<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="scripts/jquery-2.1.4.min.js"></script>
<style type="text/css">
#selects{width:140px;margin:0px auto;position:fixed;left:150px}
#ul1{width:1300px;margin:20px auto;height:auto}
li{list-style:none;width:300px;float:left;margin-left:5px;}
li div {border:5px ridge gray;padding: 5px;margin-bottom:5px;word-break:break-all }
li div img {width:280px;margin:5px auto;display:block;}
li div p{text-align: center;font-size: 20px;font-family:標楷體;}
.select{width:140px;font-size: 18px;height:4ex;margin:10px 20px 0px 20px;border-radius:15px;}
</style>
</head>
<body>
<div id="selects">
			<select id="select1" class="select" >            
	       </select><br>
	       <select id="select2" class="select" >            
	       </select><br>
	       <select id="select3" class="select" >            
	       </select><br>
	       <select id="select4" class="select" >            
	       </select>
</div>
	<ul id="ul1">
		<li></li>
		<li></li>
		<li></li>
		<li></li>		
	</ul>
<script>		
(function($){
	var oul=document.getElementById("ul1");
	var oli=oul.getElementsByTagName("li");
	var lilen=oli.length;
	var offset=0;
	var door=true;
	$.ajax({
		url:"GetCate1.jsp",
		type:"get",
		dataType:"json",
		success:function(data){
			$.each(data,function(){
				if(this.cate1no!=null){
					var cate1no=this.cate1no;
					var cate1name=this.cate1name;
					var opt=$("<option></option>").val(cate1no).text(cate1name);
					$("#select1").append(opt);
				}else if(this.countyno!=null){
					var countyno=this.countyno;
					var countyname=this.countyname;
					var opt=$("<option></option>").val(countyno).text(countyname);
					$("#select3").append(opt);
				}			
			})							
	
			$.ajax({
				url:"GetCateDist.jsp",
				type:"get",
				dataType:"json",
				data:{"cate1no":$("#select1").val(),"countyno":$("#select3").val()},
				success:function(data){
					$.each(data,function(){
						if(this.cate2no!=null){
							var cate2no=this.cate2no;
							var cate2name=this.cate2name;
							var opt=$("<option></option>").val(cate2no).text(cate2name);
							$("#select2").append(opt);
						}else if(this.distno!=null){
							var distno=this.distno;
							var distname=this.distname;
							var opt=$("<option></option>").val(distno).text(distname);
							$("#select4").append(opt);
						}						
					})
					getlist();
				}
			})
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
	$("#select1").change(function (){
		$.ajax({
			url:"GetCate2.jsp",
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
			url:"GetDist.jsp",
			type:"get",
			dataType:"json",
			data:{"countyno":$("#select3").val()},
			success:function(data){
				$("#ul1 li").empty();
				$("#select4 option").remove();
				$.each(data,function(){
					var distno=this.distno;
					var distname=this.distname;
					var opt=$("<option></option>").val(distno).text(distname);
					$("#select4").append(opt);						
				})
				offset=0;
				getlist();
			}
		})
	});
	function getlist(){	
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
	 				return;
	 			}
	 			$.each(data,function(){
	 					var index=getShort();
	 					var photoname=this.photoname;
	 					var stitle=this.stitle;
	 					var attracno=this.attracNo;
	 					var addr=this.address;
	 					var photodata=this.photodata;

	 						var index=getShort();
	 						var adddiv=document.createElement("div");
	 						var addimg=document.createElement("img");
	 						adddiv.id=attracno;
	 						addimg.src=photodata;
	 						addimg.style.width="280px";
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

	$("#ul1 li").on('click','div',function(){
		alert($(this).attr("id"))
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

		　　//當高度小於100時，關閉區塊 
		　　if($this_Top < 200){
		　　　$('#selects').stop().animate({top:"5px"});
		　　　}
		　　　　if($this_Top > 200){
		　　　　$('#selects').stop().animate({top:"5px"});
		　　　 }
		　　}).scroll();
})(jQuery);
</script>
</body>
</html>