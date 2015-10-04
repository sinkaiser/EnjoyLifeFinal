<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- 最新編譯和最佳化的 CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<!-- 選擇性佈景主題 -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css">

<link href="${pageContext.request.contextPath}/admin/blog/css/templatemo-style.css" rel="stylesheet">

  <link rel="stylesheet" href="xxx/css/style.css">
<script src="js/jquery-2.1.4.min.js"></script>
<!-- 最新編譯和最佳化的 JavaScript -->
<script src="js/bootstrap.min.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

</head>
<body>
 
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
      
   
          <div class=col-md-6>
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden" style="display: inline; width:600px;">
                
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">網誌列表</h2></div>
                <div class="table-responsive">
			<div name="accordion">
					  <h3>Section 1</h3>
					  <div>
					  </div>
					  <h3>Section 2</h3>
					  <div>
					  </div>
					  <h3>Section 3</h3>
					  <div>
					  </div>
					  <h3>Section 4</h3>
					  <div>
					  </div>
					  <h3>Section 5</h3>
					  <div>
					  </div>
					  <h3>Section 6</h3>
					  <div>
					  </div>
					  <h3>Section 7</h3>
					  <div>
				 	  </div> 
					</div>		

                  
                	</div> 
                </div>  
               </div>
                                        
             
              
     
            
          
          
          <div class=col-md-6>
                 <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden" style="display: inline ;width:600px;">              
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">網誌列表</h2></div>
                <div class="table-responsive">
			<div name="accordion">
					  <h3>Section 1</h3>
					  <div>
					  </div>
					  <h3>Section 2</h3>
					  <div>
					  </div>
					  <h3>Section 3</h3>
					  <div>
					  </div>
					  <h3>Section 4</h3>
					  <div>
					  </div>
					  <h3>Section 5</h3>
					  <div>
					  </div>
					  <h3>Section 6</h3>
					  <div>
					  </div>
					  <h3>Section 7</h3>
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