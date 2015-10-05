<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/efl/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/admin/efl/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/efl/js/moment-with-locales.js"></script>
<script src="${pageContext.request.contextPath}/admin/efl/js/bootstrap-datetimepicker.js"></script>
<Style>

.form-control{font-size:8px;margin:0px}

</Style>
</head>
<body>

<h1 class="page-header">小精靈管理</h1>
				
				<h2 class="sub-header">資料庫欄位</h2>
				
				<div id="aa">
					<button type="button" class="btn btn-primary" id="insert">新增</button>
			
					<a href="little.jsp"><button type="button" id="elf" class="btn btn-default">主要</button></a>
					<a href="type.jsp"><button type="button" id="type" class="btn btn-primary">類型</button></a>
					<a href="target.jsp"><button type="button" id="target" class="btn btn-primary">對象</button></a>
					
					
					
				</div>
					
				
				<div class="table-responsive" id="main" >
				</div>
				
				
				
				
			
				
				<script>
				(function($){
					
					
					$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":1},function(data){
// 					$.getJSON("1.txt",function(data){
						

						$('#main').append("<table class='table table-striped'><thead id='thead'><td>#</td><td>對象</td><td>類型</td><td>內容</td><td>開始時間</td><td>結束時間</td></thead><tbody id='tb'></tbody></table>")
							
						var typelist;
						var targetlist;
						
						var elfNo;
						var targetNo;
						var nevin;
						var typeNo;
						var beginTime;
						var endTime;
						
							$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":2},function(data2){
// 							$.getJSON("2.txt",function(data2){
							typelist="<select  name='typeNo'>";
							
								$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":3},function(data3){
// 								$.getJSON("3.txt",function(data3){	
								targetlist="<select  name='targetNo'>";
								
									var typeNo1;
									var type1;
									
									$.each(data2,function(){
										typeNo1=this.typeNo;
										type1=this.type;
										
				
										typelist=typelist+"<option value='"+typeNo1+"'>"+type1+"</option>";
										
									})
									
									typelist=typelist+"</select>";
									
								
								
									var targetNo1;
									var targetRole1;
				
									$.each(data3,function(){
										targetNo1=this.targetNo;
										targetRole1=this.targetRole;
									targetlist=targetlist+"<option value='"+targetNo1+"'>"+targetRole1+"</option>";
									})
									targetlist=targetlist+"</select>";
									
									
									$.each(data,function(){
										
									
										elfNo=this.elfNo;
										targetNo=this.targetNo;
										
										if(this.nevin.length>50){
										nevin=this.nevin.slice(-10,-4);
										}else{
										nevin=this.nevin;
										}
										
										typeNo=this.typeNo;
										beginTime=this.beginTime;
										endTime=this.endTime;
										var a=beginTime.substr(0,10);
										var b=beginTime.substr(11,8);
										beginTime=a+"T"+b
										var a=endTime.substr(0,10);
										var b=endTime.substr(11,8);
										endTime=a+"T"+b
										
										
										$('#tb').append("<tr value="+elfNo+"><td name='elfNo'>"+elfNo+"</td><td name='targetlist'>"+targetlist+"</td><td name='typelist'>"+typelist+"</td><td name='nevin'><input type='text' class='form-control' value="+nevin+"></td><td name='beginTime'><input type='datetime-local' class='form-control' value="+beginTime+"></td><td name='endTime'><input type='datetime-local' class='form-control' value="+endTime+"></td><td><button type='button' name='update' value="+elfNo+" class='btn btn-warning'>修改</button></td><td><button type='button' class='btn btn-danger' name='delete' value="+elfNo+">刪除</button></></tr>");	
										
										$('tr[value='+elfNo+']').find('option[value='+targetNo+']').prop("selected",true);
										$('tr[value='+elfNo+']').find('option[value='+typeNo+']').prop("selected",true);
									});
									
									$('#thead').on('click','[name="delete1"]',function(){
										$(this).parents('tr').remove();
										
									});
									$('#tb').on('click','button[name="delete"]',function(){
										var elfNo=$(this).val();
										tt=$(this);
										$.ajax({"type":"post","url":"${pageContext.request.contextPath}/LittleDel","dataType":"text",
											"data":{"elfNo":elfNo},"success":function(dd){
												
												var dd=dd.split("A");
												if(dd[0]==0){
													
													$('#p').text("編號"+dd[1]+"刪除成功");
													tt.parents('tr').remove();}
												else{
											
													$('#p').text("編號"+dd[1]+"刪除失敗");
												}
												}
												
											});
										
										
										
									});
									
								
									$('button[name="update"]').on('click',function(){
										var update=$(this);
										var elfNo2=$(this).val();
										var typeNo2=$(this).parents('tr').find('select[name="typeNo"]').val();
										var targetNo2=$(this).parents('tr').find('select[name="targetNo"]').val();
										var nevin2=$(this).parents('tr').find('td[name="nevin"]').children().val();
										var beginTime3=$(this).parents('tr').find('td[name="beginTime"]').children().val();
										var endTime3=$(this).parents('tr').find('td[name="endTime"]').children().val();
										
// 										console.log(beginTime3);
										var c =beginTime3.split("T");
										beginTime4=c[0]+" "+c[1];
										var d =beginTime3.split("T");
										endTime4=d[0]+" "+d[1];
										
										$.ajax({"type":"post","url":"${pageContext.request.contextPath}/Little","dataType":"text","data":{"do":"update","elfNo":elfNo2,"targetNo":targetNo2,"typeNo":typeNo2,"beginTime":beginTime4,"endTime":endTime4,"nevin":nevin2},
											"success":function(da){
												update.parents('tr').find('select[name="typeNo"]').val(typeNo2);
												update.parents('tr').find('select[name="targetNo"]').val(targetNo2);
												update.parents('tr').find('td[name="nevin"]').children().val(nevin2);
												update.parents('tr').find('td[name="beginTime"]').children().val(beginTime3);
												update.parents('tr').find('td[name="endTime"]').children().val(endTime3);
												$('#p').text("編號"+elfNo2+"更新成功");
												
											}
										});
											
										
									});
									
									$('#insert').on('click',function(){
										$('#thead').append("<tr><td name='elfNo'>#</td><td>"+targetlist+"</td><td>"+typelist+"</td><td><input name='nevin' type='text' class='form-control'></td><td><input  name='beginTime' type='datetime-local'  class='form-control'></td><td><input name='endTime' type='datetime-local' class='form-control'></td><td><button type='button' class='btn btn-success' name='insertlittle'>新增</button></td><td><button type='button' name='delete1' class='btn btn-danger'>刪除</button></td></tr>")
										
										//資料庫新增
											$('button[name="insertlittle"]').bind('click',function(){
												
												var button=$(this);
												var targetNo=$(this).parents('tr').find('[name="targetNo"]').val();
												var typeNo=$(this).parents('tr').find('[name="typeNo"]').val();
												
												var beginTime=$(this).parents('tr').find('[name="beginTime"]').val();
												var endTime=$(this).parents('tr').find('[name="endTime"]').val();
												var nevin=$(this).parents('tr').find('[name="nevin"]').val();
												
												var a =beginTime.split("T");
												beginTime=a[0]+" "+a[1];
												var b =endTime.split("T");
												endTime=b[0]+" "+b[1];
													
												console.log(endTime);
											
												$.ajax({"type":"post","url":"${pageContext.request.contextPath}/Little","dataType":"text","data":{"do":"insert","targetNo":targetNo,"typeNo":typeNo,"beginTime":beginTime,"endTime":endTime,"nevin":nevin},
													"success":function(da){
														var aa=da.split("A");
														
														if(aa[0]==0){
															
																													
															$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":1,"No":aa[1]},function(data4){
																$.each(data4,function(){
																beginTime=this.beginTime;
																endTime=this.endTime;
																var a=beginTime.substr(0,10);
																var b=beginTime.substr(11,8);
																beginTime=a+"T"+b
																var a=endTime.substr(0,10);
																var b=endTime.substr(11,8);
																endTime=a+"T"+b	
																
																$('#tb').append("<tr value="+this.elfNo+"><td>"+this.elfNo+"</td><td name='targetlist'>"+targetlist+"</td><td name='typelist'>"+typelist+"</td><td name='nevin'><input type='text' class='form-control' value="+this.nevin+"></td><td name='beginTime'><input type='datetime-local' class='form-control' value="+beginTime+"></td><td name='endTime'><input type='datetime-local' class='form-control' value="+endTime+"></td><td><button type='button' name='update' value="+this.elfNo+" class='btn btn-warning'>修改</button></td><td><button type='button' class='btn btn-danger' name='delete' value="+this.elfNo+">刪除</button></></tr>");	
																$('tr[value='+this.elfNo+']').find('option[value='+this.targetNo+']').prop("selected",true);
																$('tr[value='+this.elfNo+']').find('option[value='+this.typeNo+']').prop("selected",true);
																});
															});
															button.parents('tr').remove();
															
															$('#p').text("新增成功");
														}
															
														else{
															$('#p').text("新增失敗");
														}
													}
												});
												})
											})
								});		
							});
					})		
				
				}(jQuery));
				
				</script>
					
					
				
</body>
</html>