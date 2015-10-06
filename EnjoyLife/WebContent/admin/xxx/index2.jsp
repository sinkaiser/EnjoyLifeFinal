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

	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/admin/blog/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/admin/blog/css/templatemo-style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <script src="js/jquery-2.1.4.min.js"></script>
      
    <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!--     <script src="js/jquery.ui.widget.js"></script> -->
<!-- 	<script src="js/jquery.iframe-transport.js"></script> -->

  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    
  <style>
  #gallery { float: left; width: 65%; min-height: 12em; }
  .gallery.custom-state-active { background: #eee; }
  .gallery li { float: left; width: 96px; padding: 0.4em; margin: 0 0.4em 0.4em 0; text-align: center; }
  .gallery li h5 { margin: 0 0 0.4em; cursor: move; }
  .gallery li a { float: right; }
  .gallery li a.ui-icon-zoomin { float: left; }
  .gallery li img { width: 100%; cursor: move; }
 
  #trash { float: right; width: 32%; min-height: 18em; padding: 1%; }
  #trash h4 { line-height: 16px; margin: 0 0 0.4em; }
  #trash h4 .ui-icon { float: left; }
  #trash .gallery h5 { display: none; }
  </style>
    
    
  </head>
  <body>  
 	
    <!-- Left column -->
    <div class="templatemo-flex-row">
			
      <!-- Main content --> 
      <div class="templatemo-content col-2 light-gray-bg">
      
      	 <h1>景點管理</h1>
				
				<div id="aa" style="margin-left:30px">
				
					<a href="index.jsp"><button type="button"  class="btn btn-primary">未確認景點</button></a>
					<a href="index2.jsp"><button type="button" class="btn btn-default">景點列表</button></a>
					<p id='p' class="btn btn-info" style="margin-left:200px">請選擇一篇景點</p>
				</div>
        
        <div class="templatemo-content-container">
      
          <div class="templatemo-flex-row">
          
            
             <div class="col-2">
              <div class="panel panel-default templatemo-content-widget white-bg no-padding templatemo-overflow-hidden">
                
                <div class="panel-heading templatemo-position-relative"><h2 class="text-uppercase">網誌列表</h2></div>
                <div class="table-responsive">
                  <table class="table table-striped table-bordered table-hover">
      
                    <thead>
                      <tr>
                        <td>景點編號</td>
                        <td>名稱</td>
                        <td>分類一</td>
                        <td>分類二</td>
                        
                        
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
            
            
            
<!--             asd -->
           <div id="blogReply" class="col-1">      
                    
            
               <div class="templatemo-content-widget white-bg">
                <i class="fa fa-times"></i>
                <div class="media">

                  <div class="media-body" id="xbody">
                    <h2 class="btn btn-default">景點敘述</h2>
                    <textarea  name="target" cols="30" rows="5"></textarea>
                  </div>
                  
                   <hr>
                  
                  <div class="media-body" id="info">
                    <h2 class="btn btn-default">交通資訊</h2>
                    <textarea  name="target" cols="30" rows="5"></textarea>
                     
                  </div>
                  <hr>
                  
                   <div class="media-body" id="addr">
                    <h2 class="btn btn-default">住址</h2>
                    <textarea  name="target" cols="30" rows="1"></textarea>  
                  </div>                 
                  
                  
                </div>                
              </div>    		
              
              
                     
              
            </div>
<!--            ki -->
            
            
          </div>
          
          <div class="templatemo-flex-row">
       
            <div class="templatemo-content-widget white-bg col-2 text-center">
              <i class="fa fa-times"></i>
              <input type="hidden" id="sumit" value="確認送出" class="btn btn-success" style="float: left">
              <h2 class="templatemo-inline-block">圖片</h2><hr>
              
              <br>
              	
<!--               	//ui -->
              	
				<div class="ui-widget ui-helper-clearfix">
				
				
				  <input accept="image/*" id="uploadImage" type="file">
  
  

				
				<div>
					<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
					
					
					  
					</ul>
				</div>
				
				<div id="trash" class="ui-widget-content ui-state-default">
				  <h4 class="ui-widget-header"><span class="ui-icon ui-icon-trash">Trash</span> 垃圾桶</h4>
				</div>
				 
				</div>
              	
<!--               	ui -->
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
              	
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
	var cate21,cate22
	var cate1="<select name=cat1no><option value=101>景點</option><option value=102>住宿</option></select>";
	var page=0;
	var p;
		(function($){
			$.getJSON("${pageContext.request.contextPath}/attrac/GetCate2.jsp",{"cate1no":101},function(data){
				var cate2no,cate2name
				cate21="<select name=cate1>"
				$.each(data,function(){
					
					cate2no=this.cate2no
					cate2name=this.cate2name
					cate21=cate21+"<option value="+cate2no+">"+cate2name+"</option>";
				})
				cate21=cate21+"</select>"
				
			});
			
			$.getJSON("${pageContext.request.contextPath}/attrac/GetCate2.jsp",{"cate1no":102},function(data){
				var cate2no,cate2name
				cate22="<select name=cate2>"
				$.each(data,function(){
					
					cate2no=this.cate2no
					cate2name=this.cate2name
					cate22=cate22+"<option value="+cate2no+">"+cate2name+"</option>";
					
				})
				cate22=cate22+"</select>"
				first(0);
			});
			
			
			
			
			
			function first(page){
				$('#bd').empty();
				$('#sumit').attr("type","hidden");
				
				var pagee=page+1
				var count=0;
				
				
				$.getJSON("${pageContext.request.contextPath}/AdminSelectByShow",{"page":page,"show":1},function(data){
					var attracno;
					var address;
					var county;
					var dist;
					var info;
					var mrt;
					var stitle;
					var time;
					var xbody;
					var cat1no;
					var cat2no;
				    
					$.each(data,function(){
						count++;
						address=this.address;
						county=this.county;
						dist=this.dist;
						info=this.info;
						mrt=this.mrt;
						xbody=this.xbody;
						
						attracno=this.attracno
						stitle=this.stitle;
						time=this.time;
						cat1no=this.cat1no;
						cat2no=this.cat2no;
						if(cat1no==101){
							$('#bd').append("<tr name='onedata' value="+attracno+"><td name='attracno'>"+attracno+"</td><td name='stitle'>"+stitle+"</td><td>"+cate1+"</td><td name='hide'>"+cate21+"<input type='hidden' name='address' value="+address+"><input type='hidden' name='county' value="+county+"><input type='hidden' name='dist' value="+dist+"><input type='hidden' name='info' value="+info+"><input type='hidden' name='mrt' value="+mrt+"><input type='hidden' name='xbody' value="+xbody+"></td></tr>");
							$('tr[value='+attracno+']').find('select[name=cate1]').val(cat2no).prop("disabled", true);
						}else{
							$('#bd').append("<tr name='onedata'><td name='attracno'>"+attracno+"</td><td name='stitle'>"+stitle+"</td><td>"+cate1+"</td><td name='hide'>"+cate22+"<input type='hidden' name='address' value="+address+"><input type='hidden' name='county' value="+county+"><input type='hidden' name='dist' value="+dist+"><input type='hidden' name='info' value="+info+"><input type='hidden' name='mrt' value="+mrt+"><input type='hidden' name='xbody' value="+xbody+"></td></tr>");
							$('tr[value='+attracno+']').find('select[name=cate2]').val(cat2no).prop("disabled", true);
						}
						$('tr[value='+attracno+']').find('select[name=cat1no]').val(cat1no).prop("disabled", true);
						
						
						
// 						$('tr[value='+attracno+']').find('td[name="hide"]').append("<input type='hidden' name='address' value="+address+">");
// 						$('tr[value='+attracno+']').find('td[name="hide"]').append("<input type='hidden' name='county' value="+county+">");
// 						$('tr[value='+attracno+']').find('td[name="hide"]').append("<input type='hidden' name='dist' value="+dist+">");
// 						$('tr[value='+attracno+']').find('td[name="hide"]').append("<input type='hidden' name='info' value="+info+">");
// 						$('tr[value='+attracno+']').find('td[name="hide"]').append("<input type='hidden' name='mrt' value="+mrt+">");
// 						$('tr[value='+attracno+']').find('td[name="hide"]').append("<input type='hidden' name='xbody' value="+xbody+">");
						
					})
				
					
					if(page==0){
						
						if(count<10){
							$('#tablefoot').append("<span style='margin-right:10px'>現在第"+pagee+"頁</span></div>")

						}else{
							$('#tablefoot').append("<span style='margin-right:10px'>現在第"+pagee+"頁</span><span name='next'>下一頁</span></div>")

						}
					}
					else{
						if(count<10){
							$('#tablefoot').append("<div><span name='back'>上一頁</span><span style='margin-right:10px;margin-left:10px'>現在第"+pagee+"頁</span></div>")

						}else{
							$('#tablefoot').append("<div><span name='back'>上一頁</span><span style='margin-right:10px;margin-left:10px'>現在第"+pagee+"頁</span><span name='next'>下一頁</span></div>")

						}
					}
				});	
			}
			
			
			
			//outside
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
				 var xbody;
				 var addr;
				 var info;
				 $('#bd').on("click","tr[name='onedata']",function(){
					 
					 $('#trash').html('<h4 class="ui-widget-header"><span class="ui-icon ui-icon-trash">Trash</span> 垃圾桶</h4>')
						
					 $('#sumit').attr("type","button");
					 p=$(this).find('td[name="attracno"]').text()
					 $('#p').text("現在選擇編號為"+p);
					 
					 xbody=$(this).find('input[name="xbody"]').val();
					 
// 					 alert(xbody);
					 addr=$(this).find('input[name="address"]').val();
					 info=$(this).find('input[name="info"]').val();
					 
					 $('#xbody').find('textarea[name="target"]').text(xbody);
					 $('#addr').find('textarea[name="target"]').text(addr);
					 $('#info').find('textarea[name="target"]').text(info);
					 
					 
					 //img				 
					 $.getJSON("${pageContext.request.contextPath}/GetPhotoByAttracNo",{"attracNo":p},function(data){	
						 $('#gallery').empty();
						 $.each(data,function(){
							 
												 
							 $('#gallery').append('<li class="ui-widget-content ui-corner-tr"><h5 class="ui-widget-header">'+this.name+'</h5><img src='+this.data+'  width="96" height="72"><a href='+this.data+' title="放大" class="ui-icon ui-icon-zoomin"></a><a href="link/to/trash/script/when/we/have/js/off" title="放入" class="ui-icon ui-icon-trash"></a></li>');
// 							
							 
							 });
						 	
						 ui();
						 
					 })
					 
					 
			 });
				
			     $('#sumit').on('click',function(){
			  
					 $.ajax({"type":"post","url":"${pageContext.request.contextPath}/AjaxChangeFlag","dataType":"text","data":{"AttracNo":p},

						 "success":function(da){
								if(da="ok"){
								$('#p').text("標號"+p+"更新成功")
								$('tr[value='+p+']').remove();
								}
								else{
								$('#p').text("標號"+p+"更新失敗")
								}
							}
					 });
					 
				 });
				
				 
				 
				 
				 
				   $("#uploadImage").change(function(){
					      readImage( this );
					    });
					 
					    function readImage(input) {
					      if ( input.files && input.files[0] ) {
					    	var data;
					    	var name;
					        var FR= new FileReader();
					        FR.onload = function(e) {
					        	
					        	data=e.target.result;
					        	name=$(uploadImage).val();
					        	var c=name.split("\\");
					        	var d=c.length;
					        	name=c[d-1];
					        	
					        	$('#gallery').append('<li class="ui-widget-content ui-corner-tr"><h5 class="ui-widget-header">'+name+'</h5><img src='+data+'  width="96" height="72"><a href='+data+' title="放大" class="ui-icon ui-icon-zoomin"></a><a href="link/to/trash/script/when/we/have/js/off" title="放入" class="ui-icon ui-icon-trash"></a></li>');
					    
					        };       
					        FR.readAsDataURL( input.files[0] );
					        
					        
					        
					        	
					      }
					    }
				 
					    
				 
				 
				 
				 
				 
// 				 ui
				// there's the gallery and the trash
				function ui(){
				    var $gallery = $( "#gallery" ),
				      $trash = $( "#trash" );
				 
				    // let the gallery items be draggable
				    $( "li", $gallery ).draggable({
				      cancel: "a.ui-icon", // clicking an icon won't initiate dragging
				      revert: "invalid", // when not dropped, the item will revert back to its initial position
				      containment: "document",
				      helper: "clone",
				      cursor: "move"
				    });
				 
				    // let the trash be droppable, accepting the gallery items
				    $trash.droppable({
				      accept: "#gallery > li",
				      activeClass: "ui-state-highlight",
				      drop: function( event, ui ) {
				        deleteImage( ui.draggable );
				      }
				    });
				 
				    // let the gallery be droppable as well, accepting items from the trash
				    $gallery.droppable({
				      accept: "#trash li",
				      activeClass: "custom-state-active",
				      drop: function( event, ui ) {
				        recycleImage( ui.draggable );
				      }
				    });
				 
				    // image deletion function
				    var recycle_icon = "<a href='link/to/recycle/script/when/we/have/js/off' title='Recycle this image' class='ui-icon ui-icon-refresh'>Recycle image</a>";
				    function deleteImage( $item ) {
				      $item.fadeOut(function() {
				        var $list = $( "ul", $trash ).length ?
				          $( "ul", $trash ) :
				          $( "<ul class='gallery ui-helper-reset'/>" ).appendTo( $trash );
				 
				        $item.find( "a.ui-icon-trash" ).remove();
				        $item.append( recycle_icon ).appendTo( $list ).fadeIn(function() {
				          $item
				            .animate({ width: "48px" })
				            .find( "img" )
				              .animate({ height: "36px" });
				        });
				      });
				    }
				 
				    // image recycle function
				    var trash_icon = "<a href='link/to/trash/script/when/we/have/js/off' title='Delete this image' class='ui-icon ui-icon-trash'>Delete image</a>";
				    function recycleImage( $item ) {
				      $item.fadeOut(function() {
				        $item
				          .find( "a.ui-icon-refresh" )
				            .remove()
				          .end()
				          .css( "width", "96px")
				          .append( trash_icon )
				          .find( "img" )
				            .css( "height", "72px" )
				          .end()
				          .appendTo( $gallery )
				          .fadeIn();
				      });
				    }
				 
				    // image preview function, demonstrating the ui.dialog used as a modal window
				    function viewLargerImage( $link ) {
				      var src = $link.attr( "href" ),
				        title = $link.siblings( "img" ).attr( "alt" ),
				        $modal = $( "img[src$='" + src + "']" );
				 
				      if ( $modal.length ) {
				        $modal.dialog( "open" );
				      } else {
				        var img = $( "<img alt='" + title + "' width='384' height='288' style='display: none; padding: 8px;' />" )
				          .attr( "src", src ).appendTo( "body" );
				        setTimeout(function() {
				          img.dialog({
				            title: title,
				            width: 400,
				            modal: true
				          });
				        }, 1 );
				      }
				    }
				 
				    // resolve the icons behavior with event delegation
				    $( "ul.gallery > li" ).click(function( event ) {
				      var $item = $( this ),
				        $target = $( event.target );
				 
				      if ( $target.is( "a.ui-icon-trash" ) ) {
				        deleteImage( $item );
				      } else if ( $target.is( "a.ui-icon-zoomin" ) ) {
				        viewLargerImage( $target );
				      } else if ( $target.is( "a.ui-icon-refresh" ) ) {
				        recycleImage( $item );
				      }
				 
				      return false;
				    }); 
				 //ui
	}
		}(jQuery));
					
	</script>			
    <script type="text/javascript" src="js/templatemo-script.js"></script>      <!-- Templatemo Script -->

  </body>
</html>