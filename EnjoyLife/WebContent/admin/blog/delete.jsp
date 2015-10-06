<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">  

    <meta name="description" content="">
    <meta name="author" content="templatemo">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">



    <link href="${pageContext.request.contextPath}/admin/blog/css/font-awesome.min.css" rel="stylesheet">
<%--     <link href="${pageContext.request.contextPath}/admin/blog/css/bootstrap.min.css" rel="stylesheet"> --%>
    <link href="${pageContext.request.contextPath}/admin/blog/css/templatemo-style.css" rel="stylesheet">
 
  </head>
  <body style="background-color:#efefef">  
  <script src="js/jquery-2.1.4.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  
  
 
				
    <!-- Left column -->
    <div class="templatemo-flex-row">
			
      <!-- Main content --> 
      <div class="templatemo-content col-2 light-gray-bg">
      
      	 <h1>網誌管理</h1>
				
				<div id="aa" style="margin-left:30px">
				
					<a href="index.jsp"><button type="button" class="btn btn-primary">被檢舉文章</button></a>
					<a href="delete.jsp"><button type="button" class="btn btn-default">被刪除文章</button></a>
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
                        <td>會員編號</td>
                        <td>日誌類型</td>
                        <td>日誌標題</td>
                        <td>發佈日期/時間</td>
                        <td>刪除日期/時間</td>
                        
                        
                      </tr>
                    </thead>
                    <tbody id="bd">
                       
                    </tbody>
                    
                  </table>
                  <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                  <div id="tablefoot"class="panel-heading templatemo-position-relative"></div>   
                  </div> 
                </div>  
                
                                        
              </div>
              
             </div>
            
            <div class="templatemo-content-widget white-bg col-1 text-center" style="height:620px">
              <i class="fa fa-times"></i>
              <h2 id="memberId" class="text-uppercase">使用者ID</h2>
              <h3 id="postContent" class="text-uppercase margin-bottom-10">日誌內文</h3>
              <img id="img" src="images/bicycle.jpg" alt="Bicycle" class="img-thumbnail" width="150px">
              <hr>
<!--               <button class="btn btn-danger" id='delete'>刪除</button> -->
              <button  class="btn btn-success" id='back'>復原</button>
            </div>
          </div>
          
          <div class="templatemo-flex-row flex-content-row">
       
           
        </div>
          <footer class="text-right">
            <p>Copyright &copy; 2084 Company Name 
            | Designed by <a href="http://www.templatemo.com" target="_parent">templatemo</a></p>
          </footer>  
          

        
      </div>
    </div>
    </div>
  
    <script>
    var a
		(function($){
			
		
			var memberId;
			var postNo;
			var postType;
			var postTitle;
			var avgScore;
			var qtyToScore;
			var viewTotal;
			var postDate;
			var modifyDate;
			var flagDelete;
			var flagReport;
			var pathPhoto;
			var postContext;
			var AttractionsNo;
			var page=0;
			first(page);
			
			function first(page){
			$.getJSON("${pageContext.request.contextPath}/AdminGetBlogbyDelete",{"page":page},function(data){
// 			$.getJSON("${pageContext.request.contextPath}/AdminGetBlogAllJson",{},function(data){
					$('#bd').empty();
					var pagee=page+1
					if(page==0){
						$('#tablefoot').append("<span style='margin-right:10px'>現在第"+pagee+"頁</span><span name='next'>下一頁</span></div>")
					}
					else{
						$('#tablefoot').append("<div><span name='back'>上一頁</span><span style='margin-right:10px;margin-left:10px'>現在第"+pagee+"頁</span><span name='next'>下一頁</span></div>")
					}
					
					 
					
				$.each(data,function(){
					postNo=this.postNo //已取
					postType=this.postType
					if(postType=="TL"){
						postType="旅遊";
					}else if(postType=="DF"){
						postType="美食";
					}else if(postType=="ML"){
						postType="心情";
					}else if(postType=="FT"){
						postType="搞笑";
					}else if(postType=="OT"){
						postType="其他";
					}
					
					postTitle=this.postTitle
					postDate=this.postDate.substr(0,16);
					modifyDate=this.modifyDate.substr(0,16);
					
					postContext=this.postContext//hiddn
					pathPhoto=this.pathPhoto
					memberId=this.memberId
					
					avgScore=this.avgScore
					qtyToScore=this.qtyToScore
					viewTotal=this.viewTotal
					
					flagDelete=this.flagDelete
					flagReport=this.flagReport
					
					
					
					AttractionsNo=this.AttractionsNo
					
					$('#bd').append("<tr name='oneBlog' value="+postNo+"><td name='postNo'>"+postNo+"</td><td>"+postType+"</td><td name='postTitle'>"+postTitle+"</td><td>"+postDate+"</td><td name='hidden'>"+modifyDate+"<input name='AttractionsNo' type='hidden' value="+AttractionsNo+"><input name='flagReport' type='hidden' value="+flagReport+"><input name='flagDelete' type='hidden' value="+flagDelete+"><input name='viewTotal' type='hidden' value="+viewTotal+"><input name='qtyToScore' type='hidden' value="+qtyToScore+"><input name='avgScore' type='hidden' value="+avgScore+"><input name='memberId' type='hidden' value="+memberId+"><input name='pathPhoto' type='hidden' value="+pathPhoto+"><input name='postContext' type='hidden' value="+postContext+"></td></tr>")

				});
				$('#bd').on('click','tr[name="oneBlog"]',function(){
					
					
					pathPhoto=$(this).find("input[name='pathPhoto']").val();
					memberId=$(this).find("input[name='memberId']").val();
					postContext=$(this).find("input[name='postContext']").val();
					
					a=$(this).find('td[name="postNo"]').text();
					
					$('#p').text('文章編號'+a);
					
					$("#img").attr("src","${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=a&&pathImg="+pathPhoto);
					$("#memberId").text(memberId);
					$("#postContent").text(postContext);
					
					postNo=$(this).find('td[name="postNo"]').text();
					
					
					
					
					
				});
			}) };
			//outside
			
			

			
			$('#back').bind('click',function(){
			
				$.ajax({"url":"${pageContext.request.contextPath}/blogAjaxDeleteOrUpdate","data":{"postNo":a,"type":"back"},"success":function(data){
					if(data=="ok"){
						$('tr[value='+a+']').remove();
						$('#p').text('文章編號'+a+'移至檢舉區');
						
					}else{
					
						$('#p').text('文章編號'+a+'移動失敗');
					}
					
				}})
			});
			
			$('#delete').bind('click',function(){
				$.ajax({"url":"${pageContext.request.contextPath}/AdminDeleteByPostNo","data":{"postNo":a},"success":function(data){
					if(data=="ok"){
						$('tr[value='+a+']').remove();
						$('#p').text('文章編號'+a+'刪除成功');
						
					}else{
						
						$('#p').text('文章編號'+a+'刪除失敗');
					}
					
				}})
			});
			
			 $('#tablefoot').on("click","span[name='next']",function(){
				 page=page+1;
				 $('#tablefoot').empty();
				 first(page);
			 });
				 $('#tablefoot').on("click","span[name='back']",function(){
					page=page-1;
					$('#tablefoot').empty();
					first(page);
			 });
			
		}(jQuery));
					
	</script>			
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

  </body>
</html>