<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 最新編譯和最佳化的 CSS -->


<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">


<link rel="stylesheet" href="css/bootstrap.min.css">

<link href="${pageContext.request.contextPath}/admin/blog/css/font-awesome.min.css" rel="stylesheet">
 <link href="${pageContext.request.contextPath}/admin/blog/css/templatemo-style.css" rel="stylesheet">
  
  <style>
  table td{word-break: keep-all;white-space:nowrap;}
  </style>
<script src="js/jquery-2.1.4.min.js"></script>
<!-- 最新編譯和最佳化的 JavaScript -->
<script src="js/bootstrap.min.js"></script>
 <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>
<body style="background-color:white">
 
     <!-- Left column -->
    <div class="templatemo-flex-row">
			
      <!-- Main content --> 
      <div class="templatemo-content col-2 light-gray-bg">
      
      	 <h1>網誌管理</h1>
				
				<div id="aa">
				
					<a href="index.jsp"><button type="button" class="btn btn-primary">被檢舉文章</button></a>
					<a href="delete.jsp"><button type="button" class="btn btn-default">被刪除文章</button></a>
					<p id='p' class="btn btn-info" style="margin-left:200px">請選擇一篇文章</p>
					
				</div>
        
        <div class="templatemo-content-container">
      
   
          <div class=col-md-8>
          
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden" style="display: inline; width:600px;">
                
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">紀錄列表</h2></div>
                <div class="table-responsive">
			<div name="accordion">
					  <h3>今天</h3>
					  <div>
					  	
						  <table class="table">
						  	  <thead>
						  	  	<tr>
						  	  		<td>執行者</td>
						  	  		<td>時間</td>
						  	  		<td>IP</td>
						  	  		<td>對象</td>
						  	  		<td>動作</td>
						  	  		<td>內容</td>
						  	  	</tr>
						  	  </thead>
							  <c:forEach var="aa" items="${AdminLog.day1}">
							  <tr>
							  	<td>${aa.executor}</td>
							  	<td><fmt:formatDate value="${aa.logDate}" var="formattedDate" type="date" pattern="HH:mm" />${formattedDate}</td>
							  	<td>${aa.executorIp}</td>
							  	<td>${aa.executeTarget}</td>
							  	<td>${aa.executeAction}</td>
							  	<td>${aa.targetDescription}</td>			  	
							  </tr>
								
							  </c:forEach>
						  </table>
					  </div>
					  <h3>${date.one}</h3>
					  <div>
					  </div>
					  <h3>${date.two}</h3>
					  <div>
					  </div>
					  <h3>${date.three}</h3>
					  <div>
					  </div>
					  <h3>${date.four}</h3>
					  <div>
					  </div>
					  <h3>${date.five}</h3>
					  <div>
					  </div>
					  <h3>${date.six}</h3>
					  <div>
				 	  </div> 
					</div>		

                  
                	</div> 
                </div>  
               </div>
                                        
             
              
     
            
          
          
          <div class=col-md-4>
                 <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden" style="display: inline ;width:600px;">              
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">登入紀錄</h2></div>
                <div class="table-responsive">
			<div name="accordion">
					  <h3>今天</h3>
					  <div>
					  </div>
					  <h3>${date.one}</h3>
					  <div>
					  </div>
					  <h3>${date.two}</h3>
					  <div>
					  </div>
					  <h3>${date.three}</h3>
					  <div>
					  </div>
					  <h3>${date.four}</h3>
					  <div>
					  </div>
					  <h3>${date.five}</h3>
					  <div>
					  </div>
					  <h3>${date.six}</h3>
					  <div>
				 	  </div> 
			</div>		

                  
                </div> 
                </div>  
                </div>
                                        
             
              
             
          </div>

       
          

        
      </div>
    </div>
  
 
 
    <script>
  $(function() {
    $('div[name="accordion"]').accordion({
      
    });
  });
  </script>
</body>
</html>