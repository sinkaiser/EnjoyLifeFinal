<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 最新編譯和最佳化的 CSS -->




<link rel="stylesheet" href="css/bootstrap.min.css">

<link href="${pageContext.request.contextPath}/admin/blog/css/font-awesome.min.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/admin/blog/css/templatemo-style.css" rel="stylesheet">
  
  <style>
  table td{word-break: keep-all;white-space:nowrap;}
  </style>
<script src="js/jquery-2.1.4.min.js"></script>
<!-- 最新編譯和最佳化的 JavaScript -->
<script src="js/bootstrap.min.js"></script>
 <script src="js/jquery-ui.js"></script>

</head>
<body style='background-color:#efefef　'>
 
     <!-- Left column -->
    <div class="templatemo-flex-row">
			
      <!-- Main content --> 
      <div class="templatemo-content col-2 light-gray-bg">
      
      	 <h1>後台管理</h1>
				
				
        
        <div class="templatemo-content-container">
      
            <div id="aa" style="margin-left:30px">
		
			
					<a href="page.jsp"><button type="button"  class="btn btn-default">登入紀錄</button></a>
					<a href="page2.jsp"><button type="button"  class="btn btn-primary">管理紀錄</button></a>
					<p id='p' class="btn btn-info" style="margin-left:200px"></p>
					
				</div>
          
          
          <div class=col-md-12>
           <div class="templatemo-flex-row flex-content-row">

             <div class="col-2">
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">登入紀錄</h2></div>
                <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<td>帳號</td>
							<td>時間</td>
							<td>IP</td>
							<td>動作</td>
							<td>結果</td>
						</tr>
					</thead>
					 <c:forEach var="aa" items="${loginList}">
							  <tr >
							  	<td>admin<input name="logNo" type="hidden" value="${aa.logNo}"> <input name="logDate" type="hidden" value="${aa.logDate}"></td>
							  	<td><fmt:formatDate value="${aa.logDate}" var="formattedDate" type="date" pattern="MM月dd日 HH時mm分ss秒" />${formattedDate}</td>
							  	<td>${aa.executorIp}</td>
							  	<td>${aa.executeAction}</td>
							  	<td>${aa.targetDescription}</td>			  	
							  </tr>

					 </c:forEach>	
				</table>
				
                </div>  
                
                                        
              </div>
              
             </div>
          </div>
                                        
             
              </div>
             
          </div>

       
          

        
      </div>
    </div>
  
  
      
 
 <!-- Button trigger modal -->
<input type="hidden" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" id="dilog">




<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content" id="tab">
		<table class='table'>
			<thead>
				<tr>
				<td>執行者</td>
				<td>時間</td>
				<td>動作</td>
				
				<td>內容</td>
				</tr>
			</thead>
			<tbody id="tb">
			</tbody>
		</table>

    </div>
  </div>
</div>
 
 
 
 
 
 	
    <script>
  $(function() {
	 
	   
	    $('h3[name="title"]').click(function(){
	    	var c=$(this).next().find("input[type='hidden']").val()
	    	$('div[name="day"]').css({"height":80+c*45});
	    })
	    
	    $('h3[name="title"]').dblclick(function(){
	    	$('div[name="day"]').css({"height":0});
	    })
	    
    $('div[name="accordion"]').accordion({
      
    });
	
	    
	    $('h3[name="title"]').dblclick();
	    
	    
	    $("#p").hide();
	    
	    
	    
	    
	    
	   	$('table').on("click",('tr'),function(){
// 	   		alert($(this).find('input[name=logNo]').val());
// 	   		alert($(this).next().find('input[name=logNo]').val());
	  		
	  		
	   		var beginTime=$(this).find('input[name=logDate]').val();
	   		var endTime=$(this).prev().find('input[name=logDate]').val();
	   		if(endTime){
	   		endTime=endTime.substr(0,19);	
// 	   		alert("a");
	   		}else{
	   		endTime="2099-12-15 12:00:00";
// 	   		alert("b");
	   		
	   		}
	   		beginTime=beginTime.substr(0,19);	
	   		
	   		$("#p").text("讀取中");
	  		$("#p").show();
	   		$.ajax({"type":"post","url":"${pageContext.request.contextPath}/WhoDoAjax","dataType":"JSON",
				"data":{"beginTime":beginTime,"endTime":endTime},"success":function(dd){
					
					$('#tb').empty();
					if(dd==""){
						$('#p').text("沒資料");
					}else{
						$.each(dd,function(){
							console.log(this.executorIp);
							this.executor
							this.executorIp
							this.logDate
							this.targetDescription
							if(this.executor!="排程器"){
							$('#tb').append("<tr><td>"+this.executor+"</td><td>"+this.logDate.substr(0,19)+"</td><td>"+this.executeAction+"</td><td>"+this.targetDescription+"</td></tr>")
							}
						})
						 $("#p").hide();
						$('#dilog').click();
					}	
					
				}
				
			});
	   		
	   		
	   		
	   	}) 

 	
		
    
	   	
	   	
	   	
	   	
	   	
	   	
	   	
	   	
  });
  </script>
</body>
</html>