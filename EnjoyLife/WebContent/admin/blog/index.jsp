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
  <body style='background-color:#efefef;'>  
  <script src="js/jquery-2.1.4.min.js"></script>  
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
  
  
 
				
    <!-- Left column -->
    <div class="templatemo-flex-row" >
			
      <!-- Main content --> 
      <div class="templatemo-content  light-gray-bg">
      
      	 <h1>網誌管理</h1>
				
				<div id="aa" style="margin-left:30px">
				
					<a href="index.jsp"><button type="button"  class="btn btn-default">檢舉區</button></a>
					<a href="delete.jsp"><button type="button" class="btn btn-primary">待刪除區</button></a>
					<p id='p' class="btn btn-info" style="margin-left:200px">請選擇一篇文章</p>
				</div>
        
        <div class="templatemo-content-container">
      
          <div class="templatemo-flex-row" style="width:1150px">
          
            
             <div >
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">網誌列表</h2></div>
                <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover">
      
                    <thead>
                      <tr>
                        <td>網誌編號</td>
                        <td>日誌類型</td>
                        <td>日誌標題</td>
                        <td>發佈日期/時間</td>
                        <td>修改日期/時間</td>
                        
                        
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
            
            <div class="templatemo-content-widget white-bg col-md-6 text-center" style="font-size:12px">
              <i class="fa fa-times"></i>
              <h2 id="memberId" class="text-uppercase">使用者ID</h2>
              <h3 id="postContent" class="text-uppercase margin-bottom-10">日誌內文</h3>
              <img id="img" src="images/bicycle.jpg" alt="Bicycle" class="img-thumbnail" width="180px">
            </div>
          </div>
          
          <div class="templatemo-flex-row">
       
            <div class="templatemo-content-widget white-bg col-2 text-center">
              <i class="fa fa-times"></i>
              <h2 class="templatemo-inline-block">數據</h2><hr>
              <br>
              	<p  id="avgScore1">日誌平均分：</p>
				<div class="progress">
				  <div id="avgScore" class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
				    <span></span>
				  </div>
			 	</div>
			 	<p id="qtyToScore1">評分總人數：</p>
				<div class="progress">
				  	<div id="qtyToScore" class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
				    <span></span>
				  </div>
				</div>       
				<p  id="viewTotal1">瀏覽總人數：</p>
				<div class="progress">
				  <div id="viewTotal" class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
				    <span></span>
				  </div>
				</div>
				<div>
					
					<button id="blogdelete" type="button" class="btn btn-danger">移置刪除區</button>
					<button id="blogok" type="button" class="btn btn-success">沒問題</button>
				</div>
            </div>
            
           
          
            <div id="blogReply" class="col-1">      
                    
            
               <div class="templatemo-content-widget white-bg">
                <i class="fa fa-times"></i>
                <div class="media">
                  <div class="media-left">
                      <img class="media-object img-circle" src="images/sunset.jpg" alt="Sunset">
                  </div>
                  <div class="media-body">
                    <h2 class="media-heading text-uppercase">回覆者名稱</h2>
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
                    <h2 class="media-heading text-uppercase">回覆者名稱</h2>
                    <p>回覆內容</p>  
                  </div>
                </div>                
              </div>   
              
            </div>
        </div>
         
          
     
        
        
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
			var count=0;
			
			function first(page){
				$('#p').text("讀取中");
			
			$.getJSON("${pageContext.request.contextPath}/AdminGetBlogbyFlagReprot",{"page":page},function(data){
// 			$.getJSON("${pageContext.request.contextPath}/AdminGetBlogAllJson",{},function(data){
					$('#bd').empty();
					var pagee=page+1
					
					
					
					 
					
				$.each(data,function(){
					count=count+1;
				
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
// 					$('td[name=hidden]').append("<input name='postContent' type='hidden' value="+postContent+">");
					
// 					$('td[name=hidden]').append("<input name='pathPhoto' type='hidden' value="+pathPhoto+">");
// 					$('td[name=hidden]').append("<input name='memberId' type='hidden' value="+memberId+">");
// 					$('td[name=hidden]').append("<input name='avgScore' type='hidden' value="+avgScore+">");
// 					$('td[name=hidden]').append("<input name='qtyToScore' type='hidden' value="+qtyToScore+">");
// 					$('td[name=hidden]').append("<input name='viewTotal' type='hidden' value="+viewTotal+">");
// 					$('td[name=hidden]').append("<input name='flagDelete' type='hidden' value="+flagDelete+">");
// 					$('td[name=hidden]').append("<input name='flagReport' type='hidden' value="+flagReport+">");
// 					$('td[name=hidden]').append("<input name='AttractionsNo' type='hidden' value="+AttractionsNo+">");
				});
					$('#p').text("讀取完畢");
					if(page==0){
						
						if(count<10){
							$('#tablefoot').append("<div><span style='margin-right:10px;margin-left:10px'>現在第"+pagee+"頁</div>")
							
						}else{
							$('#tablefoot').append("<span style='margin-right:10px'>現在第"+pagee+"頁</span><span name='next'>下一頁</span></div>")	
						}
						}
					else{
						if(count<10){
							
							$('#tablefoot').append("<div><span name='back'>上一頁</span><span style='margin-right:10px;margin-left:10px'>現在第"+pagee+"頁</div>")
							
						}else{
							$('#tablefoot').append("<div><span name='back'>上一頁</span><span style='margin-right:10px;margin-left:10px'>現在第"+pagee+"頁</span><span name='next'>下一頁</span></div>")
	
						}
					}
				$('#bd').on('click','tr[name="oneBlog"]',function(){
					pathPhoto=$(this).find("input[name='pathPhoto']").val();
					memberId=$(this).find("input[name='memberId']").val();
					postContext=$(this).find("input[name='postContext']").val();
					
					a=$(this).find('td[name="postNo"]').text();
					$('#p').text('讀取文章編號'+a);
					
					$("#img").attr("src","${pageContext.request.contextPath}/GetBlogImgServlet?isThumbnail=a&&pathImg="+pathPhoto);
					$("#memberId").text(memberId);
					$("#postContent").text(postContext);
					
					avgScore=$(this).find("input[name='avgScore']").val();
					qtyToScore=$(this).find("input[name='qtyToScore']").val();
					viewTotal=$(this).find("input[name='viewTotal']").val();
					$("#avgScore1").empty();
					$("#qtyToScore1").empty();
					$("#viewTotal1").empty();
					
					$("#avgScore1").append("日誌平均分："+avgScore);
					$("#qtyToScore1").append("評分總人數："+qtyToScore);
					$("#viewTotal1").append("瀏覽總人數："+viewTotal);
					
					viewTotal=viewTotal;
					qtyToScore=qtyToScore*2;
					avgScore=avgScore*20;
					
					if(viewTotal>100){
						viewTotal=100
					}
					if(qtyToScore>100){
						qtyToScore=100
					}
					
					$("#avgScore").attr("style","width:"+avgScore+"%");
					$("#qtyToScore").attr("style","width:"+qtyToScore+"%");
					$("#viewTotal").attr("style","width:"+viewTotal+"%");
					
					postNo=$(this).find('td[name="postNo"]').text();
					
					
					
					
					var postNo;
					var replyNo;
					var replyMemberId;
					var replyContext;
					var replyDate;
					var flagDelete;
					
					var imgNo;
					
					$.getJSON("${pageContext.request.contextPath}/GetReplyServlet",{"ArticleNo":postNo},function(data1){ //取回覆
						$('#blogReply').empty();
					
						$.each(data1,function(){
							postNo=this.postNo;
							replyNo=this.replyNo;
							replyMemberId=this.replyMemberId;
							
							
							replyContext=this.replyContext;
							replyDate=this.replyDate.substr(0,16);
							flagDelete=this.flagDelete;
							memPic=this.memPic;
							
							if(flagDelete==0){
							$('#blogReply').append('<div name="oneReply" class="templatemo-content-widget white-bg"><i class="fa fa-times"></i><div class="media"><div class="media-left"><img style="width:35px;height:35px" class="media-object img-circle" src="/EnjoyLife/GetImg?imgid='+memPic+'" alt="Sunset"></div><div class="media-body"><h2 class="media-heading text-uppercase" style="float:left">'+replyMemberId+'</h2><p style="float:right">'+replyDate+'</p><p><br>'+replyContext+'</p><button name="return" type="button" class="btn btn-success">恢復</button></div></div></div>');
							}else{
							$('#blogReply').append('<div name="oneReply" class="templatemo-content-widget white-bg"><i class="fa fa-times"></i><div class="media"><div class="media-left"><img style="width:35px;height:35px" class="media-object img-circle" src="/EnjoyLife/GetImg?imgid='+memPic+'" alt="Sunset"></div><div class="media-body"><h2 class="media-heading text-uppercase" name="replyMemberId" style="float:left">'+replyMemberId+'</h2><p style="float:right">'+replyDate+'</p><br><br><br><p>'+replyContext+'</p><button name="delete" type="button" class="btn btn-danger">刪除</button></div></div></div>');
							}
							
						})
						
						$('#blogReply').on("click","button[name='delete']",function(){
							
							
						})
						$('#p').text('文章編號'+a+"讀取完畢");
					});
				});
			}) };
			//outside
			
			$('#blogdelete').bind('click',function(){
				$('#p').text('傳輸中');
				$.ajax({"url":"${pageContext.request.contextPath}/blogAjaxDeleteOrUpdate","data":{"postNo":a,"type":"delete"},"success":function(data){
					
					if(data=="ok"){
						
						$('tr[value='+a+']').remove();
						$('#p').text('文章編號'+a+'移至刪除區');
	
						
					}else{
						$('#p').text('文章編號'+a+'移至刪除區失敗');
					
						
					}
					
				}})
			});
			
			$('#blogok').bind('click',function(){
				$('#p').text('傳輸中');
				$.ajax({"url":"${pageContext.request.contextPath}/blogAjaxDeleteOrUpdate","data":{"postNo":a,"type":"ok"},"success":function(data){
					if(data=="ok"){
						
						$('tr[value='+a+']').remove();
						
						$("#avgScore").attr("style","width:0%");
						$("#qtyToScore").attr("style","width:0%");
						$("#viewTotal").attr("style","width:0%");
						$('#blogReply').empty()
						
						$('#p').text('文章編號'+a+'取消檢舉成功');
						
						
					}else{
						
						$('#p').text('文章編號'+a+'取消檢舉失敗');
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