(function($){
				
				$.getJSON("/lab/GetLittleJson",{"id":1},function(data){
					
					var elfNo;
					var targetNo;
					var nevin;
					var typeNo;
					var beginTime;
					var endTime;
					var flag1=false;
					
					var time=$("#hiddenName").val(); //time
					var name=$("#hiddenName1").val(); //name
					var member=$("#hiddenName2").val(); //true
					if((new Date()-new Date(time))>new Date(1000*60*60*24*30*3)){
						alert("超過");
						flag1=true;
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
						
						
						if(date<end && date>begin){  //文章沒過期
							if(member){     //是會員
							
							elfNo=this.elfNo;
							targetNo=this.targetNo;
							nevin=this.nevin;
							typeNo=this.typeNo;
							
								if(flag1){		     //老會員
									if(targetNo==3||targetNo==4){
// 										alert("老會員")
										arrayObj.push(nevin+"A"+typeNo);
									}
								}			
								else{				//新會員
									if(targetNo==2||targetNo==4){
// 										alert("新會員")
										arrayObj.push(nevin+"A"+typeNo);
									}
								}
							}
							else{					//不是會員
								if(targetNo==2||targetNo==4){
// 									alert("不是會員")
									arrayObj.push(nevin+"A"+typeNo);
								}
							}
						}
					});
					

					
					
					
					function aa(){
						var ran=Math.floor(Math.random()*arrayObj.length)+1
						var rans=arrayObj[ran].split("A");
						
						console.log(rans[1]);
						$('#say').text(rans[0])
						if(rans[1]==1){
							$('#say').attr("class","btn btn-primary")
						}
						else if(rans[1]==2){
							$('#say').attr("class","btn btn-success")
						}
						else if(rans[1]==3){
							$('#say').attr("class","btn btn-info")
						}
						else if(rnas[1]==4){
							$('#say').attr("class","btn btn-warning")
						}
					}
					
					var timeoutId=setInterval(aa, 5000);
					
					
					
				})
				
			}(jQuery));