<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery-2.1.4.min.js"></script>

<script src="js/moment-with-locales.js"></script>
<script src="js/bootstrap-datetimepicker.js"></script>
<script src="js/jQueryRotate.js"></script>
<script src="js/date.js"></script>
</head>
<body>

<div>
<img id="xxx" src="img/dog2.gif" class="img-circle" height="100px" width="100px">
<button id="say" type="button" class="btn btn-default"></button>
<br>
<input id="ooo" value="請輸入" type="hidden">
<input id="sumit" value="送出資料" type="hidden">


</div>

        <script>
			(function($){
				var time="${member.registerDate}" //time
					var name="${member.memberName}" //name
					var member="${member}" //true
					var imgid="${member.picture}"
				
				if(name==""){
					name="訪客";
					}
				
				
				$('#say').attr("class","btn btn-info")
				$('#xxx').attr("src","img/dog2.gif");
				$('#say').text(name+"你好");
				
				var time="${member.registerDate}" //time
				var name="${member.memberName}" //name
				var member="${member}" //true
				var imgid="${member.picture}"
				
				
				$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":1},function(data){
					
					var elfNo;
					var targetNo;
					var nevin;
					var typeNo;
					var beginTime;
					var endTime;
					var flag1=false;
					
					if(time){
						if((new Date()-new Date(time))>new Date(1000*60*60*24*30*3)){
							alert("超過");
							flag1=true;
						}
					}
					var arrayObj=new Array(0);
					var date=new Date();
					var begin;
					var end;
					console.log(time)
					$.each(data,function(){
						
						beginTime=this.beginTime;
						endTime=this.endTime;
					
						begin=new Date(beginTime);
						end=new Date(endTime);
						
						elfNo=this.elfNo;
						targetNo=this.targetNo;
						nevin=this.nevin;
						typeNo=this.typeNo;
						
						
						if(date<end && date>begin){  //文章沒過期
							if(member){     //是會員
							
							
							
								if(flag1){		     //老會員
									if(targetNo==3||targetNo==4){
// 										alert("老會員")
										arrayObj.push(nevin+"A0A"+typeNo);
									}
								}			
								else{				//新會員
									if(targetNo==2||targetNo==4||targetNo==3){
// 										alert("新會員")
										arrayObj.push(nevin+"A0A"+typeNo);
									}
								}
							}
							else{					//不是會員
								if(targetNo==2||targetNo==1){
// 									alert("不是會員")

									arrayObj.push(nevin+"A0A"+typeNo);
								}
							}
						}
					});
					
					function aa(){
						var ran=Math.floor(Math.random()*arrayObj.length);
						console.log(arrayObj[ran]);
						var rans=arrayObj[ran].split("A0A");
						
							
						console.log(rans[1]);
						
						if(rans[1]==1){
							$('#say').attr("class","btn btn-primary")
							$('#xxx').attr("src","img/dog2.gif");
							$('#say').text("公告:"+rans[0]);
						}
						else if(rans[1]==2){
							$('#say').attr("class","btn btn-success")
							$('#xxx').attr("src","img/dog2.gif");
							
							$('#say').html("優惠資訊:"+rans[0]);
						}
						else if(rans[1]==3){
							$('#say').attr("class","btn btn-info")
							$('#xxx').attr("src","img/dog2.gif");
							$('#say').text("提醒:"+rans[0]);
						}
						else if(rans[1]==4){
							
							$('#say').attr("class","btn btn-info")
							var imgid=rans[0].split("imgid=");
							var name=imgid[0].split("?name=");
							$('#xxx').attr("src","${pageContext.request.contextPath}/GetImg?imgid="+imgid[1]);
							$('#say').text("會員["+name[1]+"]:"+name[0]);
						}
					}
					
					var flag=true;
					var angle=0;
					function bb(){
						
						if(flag){
							
							angle=angle+10
							$("#xxx").rotate(angle);
							if(angle>45){
								flag=false;
							}
						}else{
						
							angle=angle-10;
							$("#xxx").rotate(angle);
							if(angle<0){
								flag=true;
							}
						}
					}
					
					var timeoutId=setInterval(aa, 5000);
					var timeoutId=setInterval(bb, 250);
					
				})
				if(member){
					$('#xxx').dblclick(function(){
						$('#say').text("讓我幫你昭告天下");
						$('#ooo').attr("type","text");
						$('#sumit').attr("type","button").click(function(){
							
						var nevin=$('#ooo').val();
						var begin=new Date();
						var end=new Date(1000*60*5+ begin.getTime());
						
						begin=begin.format("isoDateTime");
						var a=begin.split("T");
						end=end.format("isoDateTime");
						var b=end.split("T");
						begin=a[0]+" "+a[1];
						end=b[0]+" "+b[1];
								$.ajax({"type":"post","url":"${pageContext.request.contextPath}/Little","dataType":"text","data":{"do":"insert","targetNo":4,"typeNo":4,"beginTime":begin,"endTime":end,"nevin":nevin+"?name="+name+"imgid="+imgid},
									"success":function(da){
									alert("成功")
									$('#ooo').text("");
									$('#ooo').attr("type","hidden");
									$('#say').text("訊息已經送出");
									$('#sumit').attr("type","hidden")
									}
								});			
						});			
					})
				}
					
			}(jQuery));
		
		</script>
					
				
</body>
</html>