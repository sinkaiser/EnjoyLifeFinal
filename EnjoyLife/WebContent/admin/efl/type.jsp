<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/efl/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath}/efl/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/efl/js/moment-with-locales.js"></script>
<script src="${pageContext.request.contextPath}/efl/js/bootstrap-datetimepicker.js"></script>
</head>
<body>
<h1 class="page-header">小精靈管理</h1>
				
				<h2 class="sub-header">資料庫欄位</h2>
				
				<div id="aa">
					<button type="button" class="btn btn-primary" id="insert">新增</button>
			
					<a href="little.jsp"><button type="button" id="elf" class="btn btn-primary">主要</button></a>
					<a href="type.jsp"><button type="button" id="type" class="btn btn-default">類型</button></a>
					<a href="target.jsp"><button type="button" id="target" class="btn btn-primary">對象</button></a>
					
				</div>
					
				
				<div class="table-responsive" id="main">
					<table class='table table-striped'>
						<thead id='thead'>
							<td>#</td>
							<td>類型</td>
						</thead>
					<tbody id='tb'></tbody>
					</table>
				</div>
				
				<script>
				(function($){
				
									
					$.getJSON("${pageContext.request.contextPath}/GetLittleJson",{"id":2},function(data2){
						
						var typeNo1;
						var type1;
						
						$.each(data2,function(){
							typeNo1=this.typeNo;
							type1=this.type;
							$('#tb').append("<tr><td>"+typeNo1+"</td><td><input class='form-control' type='text' value="+type1+"></td><td><button type='button' name='update' value="+typeNo1+" class='btn btn-warning'>修改</button></td><td><button type='button' class='btn btn-danger' name='delete' value="+typeNo1+">刪除</button></td></tr>");
							
						})
						
						
					});
				}(jQuery));
				</script>
				
</body>
</html>