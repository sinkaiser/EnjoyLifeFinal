<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  
    <title>Visual Admin Dashboard - Home</title>
    <meta name="description" content="">
    <meta name="author" content="templatemo">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">



    <link href="${pageContext.request.contextPath}/admin/blog/css/font-awesome.min.css" rel="stylesheet">
<%--     <link href="${pageContext.request.contextPath}/admin/blog/css/bootstrap.min.css" rel="stylesheet"> --%>
    <link href="${pageContext.request.contextPath}/admin/blog/css/templatemo-style.css" rel="stylesheet">
    
  </head>
  <body>  
  <script src="js/jquery-2.1.4.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  
  
 
				
    <!-- Left column -->
    <div class="templatemo-flex-row">
			
      <!-- Main content --> 
      <div class="templatemo-content col-2 light-gray-bg">
      
      	 <h1>網誌管理</h1>
				
				<div id="aa">
				
					<a href="index.jsp"><button type="button"  class="btn btn-default">被檢舉文章</button></a>
					<a href="delete.jsp"><button type="button" class="btn btn-primary">被刪除文章</button></a>
					<p id='p' class="btn btn-info" style="margin-left:200px">請選擇一篇文章</p>
				</div>
        
        <div class="templatemo-content-container">
      
          <div class="templatemo-flex-row flex-content-row">
          
            
             <div class="col-2">
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">網誌列表</h2></div>
                <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover">
      
                    <thead>
                      <tr>
                        <td>景點編號</td>
                        <td>stile</td>
                        <td>time</td>
                        <td>分類一</td>
                        <td>分類二</td>
                        
                        
                      </tr>
                    </thead>
                    <tbody id="bd">
                       <tr>
                       	<td></td>
                       	<td></td>
                       	<td></td>
                       	<td><select name="cate1no"></select></td>
                       	<td></td>
                       <tr>
                    </tbody>
                    
                  </table>
                  <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                  <div id="tablefoot"class="panel-heading templatemo-position-relative"></div>   
                  </div> 
                </div>  
                
                                        
              </div>
              
             </div>
            
            
            
<!--             asd -->
           <div id="blogReply" class="col-1">      
                    
            
               <div class="templatemo-content-widget white-bg">
                <i class="fa fa-times"></i>
                <div class="media">
                  <div class="media-left">
                      <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset">
                  </div>
                  <div class="media-body">
                    <h2 class="media-heading text-uppercase">xbody</h2>
                    <p>回覆內容</p>  
                  </div>
                </div>                
              </div>    		
              
              
                        
              <div class="templatemo-content-widget white-bg">
                <i class="fa fa-times"></i>
                <div class="media">
                  <div class="media-left">
                      <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset">
                  </div>
                  <div class="media-body">
                    <h2 class="media-heading text-uppercase">info</h2>
                    <p>回覆內容</p>  
                  </div>
                </div>                
              </div>   
              
               <div class="templatemo-content-widget white-bg">
                <i class="fa fa-times"></i>
                <div class="media">
                  <div class="media-left">
                      <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset">
                  </div>
                  <div class="media-body">
                    <h2 class="media-heading text-uppercase">addr</h2>
                    <p>回覆內容</p>  
                  </div>
                </div>                
              </div>   
              
            </div>
<!--            ki -->
            
            
          </div>
          
          <div class="templatemo-flex-row flex-content-row">
       
            <div class="templatemo-content-widget white-bg col-2 text-center">
              <i class="fa fa-times"></i>
              <h2 class="templatemo-inline-block">圖片</h2><hr>
              <br>
              	
              	
              	
              	
            </div>
            
           
          
            
        </div>
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | Designed by <a href="http://www.templatemo.com" target="_parent">templatemo</a></p>
          </footer>  
          
 
        
        
        
      </div>
    </div>
    </div>
  
    <script>
	var cate1,cate2
		(function($){
			$.getJSON("${pageContext.request.contextPath}/attrac/GetCate2.jsp",{"cate1no":101},function(data){
				var cate2no,cate2name
				cate1="<select name=cate1>"
				$.each(data,function(){
					
					cate2no=this.cate2no
					cate2name=this.cate2name
					cate1=cate1+"<option value="+cate2no+">"+cate2name+"</option>";
				})
				cate1=cate1+"</select>"
				
			});
			
			$.getJSON("${pageContext.request.contextPath}/attrac/GetCate2.jsp",{"cate1no":102},function(data){
				var cate2no,cate2name
				cate2="<select name=cate2>"
				$.each(data,function(){
					
					cate2no=this.cate2no
					cate2name=this.cate2name
					cate2=cate2+"<option value="+cate2no+">"+cate2name+"</option>";
					
				})
				cate2=cate2+"</select>"
				
			});
			
			
			$.getJSON("${pageContext.request.contextPath}/AdminSelectByShow",{"page":0,"show":0},function(data){
				var attracno;
				
				$.each(data,function(){
				
					attracno=this.attracno
					
					
				})
				
				
			});
			
			
			
		}(jQuery));
					
	</script>			
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

  </body>
</html>