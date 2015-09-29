<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <meta http-equiv="Refresh" content="10"> -->

<title>找伴列表</title>

<link rel="stylesheet" href="css/demo.css">
<link rel="stylesheet" href="css/layout.css">
<link rel="stylesheet" href="css/filter.css">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" type="text/css" />


<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel='stylesheet' href='css/skel-noscript.css' type="text/css" />
<link rel='stylesheet' href='css/style.css' type="text/css" />
<link rel='stylesheet' href='css/style-desktop.css' type="text/css" />
<link rel='stylesheet' href='css/bootstrap-theme.css' type="text/css" />
<link rel='stylesheet' href='css/bootstrap.css' type="text/css" />
<script src="../js/skel.min.js"></script>
<script src="../js/skel-panels.min.js"></script>
<script src="../js/init.js"></script>

<style type="text/css">
#contentp {
	padding: 2px 0;
	width: 200px;
	font-size: 1em;
}

#plocation {
 display: inline;
}

#alocation > img{
 
 margin-right:0px;
}

#locationdiv {
	display: inline;
}
.post_meta{
 	    position:none;
}

#up{
	display: inline;
}
.navbar-inverse{
	height:50px;
}

body{
		padding-top:90px;
	}
.form-textarea{
	width:500px;
	height:150px;
}
#inputAdd{
	width:300px;
}
</style>

</head>
<body class="homepage">
<%String aa=pageContext.getRequest().getParameter("inputAdd");
  	pageContext.getRequest().setAttribute("inputAdd", aa);
  %>
<nav class="navbar-fixed-top" style="height:90px">
	<nav id="nav">
		<ul>
			<li><a href="../indexMember.jsp">會員</a></li>
			<li><a href="${pageContext.request.contextPath}/attrac/Attracdesign.jsp">規劃</a></li>
			<li><a href="${pageContext.request.contextPath}/blog/blogList.jsp">日誌</a></li>
			<li><a href="${pageContext.request.contextPath}/partner/mapFP.jsp">找伴</a></li>
			<li><a href="${pageContext.request.contextPath}/activityPage/activitySimple1.jsp">活動資訊</a></li>
			
			<c:if test="${!empty member}">							
				<li><a href="${pageContext.request.contextPath}/secure/logout.jsp">登出</a></li>
				<li><img src="${pageContext.request.contextPath}/GetImg?imgid=${member.picture}" height="30" width="30" onerror="this.style.display='none'"> 
					${member.memberName}
				</li>
			</c:if>	
		</ul>
	</nav>
		<nav class="navbar navbar-inverse" role="navigation">
			<div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					
					<div class="navbar-form navbar-left" role="search" style="width:1280px;text-align:center;">
						<div class="form-group" style="margin-right:30px;width:300px;margin-left:250px">
						<form action="SearchServlet" id="jsearch" method="post">
							<input type="text" class="form-control" placeholder="Search"
								id="inputAdd" name="eventTitleContent" value="${inputAdd}" />
						</form>
						</div>
						<button type="button" id="btnsearch" onclick="searchsubmit()" class="btn btn-default" id="button1"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
						<div class="btn-group" id="button-toggle" style="left:150px;">
							<a href="${pageContext.request.contextPath}/partner/mapFP.jsp"><button type="button" class="btn btn-default"
									id="btn-left">地圖</button></a> <a
								href="${pageContext.request.contextPath}/partner/ShowAllPartnerServlet"><button
									type="button" class="btn btn-default" id="btn-right-list">列表</button></a>
						</div >
						<div class="btn-group" style="margin-left:80px;float:right;">
						<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#newPartner" onclick="createEvent('${mem.PartnerVO.eventNo}','${mem.PartnerVO.eventType}','${mem.PartnerVO.eventTitle}','${mem.PartnerVO.eventContent}','${mem.PartnerVO.addr}')">
	  					我要新增找伴活動
						</button>
						</div>
					</div>

				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
			<!-- /.container-fluid -->
		</nav>
	</nav>
	<div class="wrap">

		<div class="main">
			<div class="inwrap">

				<div class="detail">
					<p id="filters" class="cxbtn_group">
						<a class="cxbtn" href="javascript://" data-filter="all">Reset filters</a>
						<a class="cxbtn" href="javascript://" data-filter="購物">購物</a>
						<a class="cxbtn" href="javascript://" data-filter="餐飲">餐飲</a> 
						<a class="cxbtn" href="javascript://" data-filter="娛樂">娛樂</a>
						<a class="cxbtn" href="javascript://" data-filter="運動">運動</a>
						<a class="cxbtn" href="javascript://" data-filter="藝文">藝文</a>
						<a class="cxbtn" href="javascript://" data-filter="交通">交通</a>
					</p>
				</div>




				<div class="example">
				
					<div id="main" role="main">
						<ul id="tiles">
							<!-- These are our grid blocks -->
							<c:forEach var="mem" varStatus="statusX" items="${AllPartners}">
								<li data-filter-class='["${mem.PartnerVO.eventType}"]'>
									<table>
										<tr>
											<td><img style="float: left"
												src="${pageContext.request.contextPath}/GetImg?imgid=${mem.imgNo}"
												height="30" width="30" onerror="this.style.display='none'">
												<h2>${mem.PartnerVO.eventTitle}
													<a href="#" data-toggle="modal" data-target="#myModal3" onclick="attend('${mem.PartnerVO.eventNo}','${member.memberId}','${mem.PartnerVO.memberId}')"><img style="float: right" src="img/plusone2.png"
														id="plusone" width="32" height="32" alt="+1"></a>
												</h2>


												<p id="contentp">${mem.PartnerVO.eventContent}</p>
												<img src="${pageContext.request.contextPath}/GetImg?imgid=${mem.PartnerVO.imgNo}"
												height="180" width="220" title="${mem.PartnerVO.eventTitle}">

												<div class="post_meta" style="margin: 0">
													
													<span><a href="#"><img src="../partner/img/icon-location.png">${mem.PartnerVO.memberId}</a></span>
													 <a href="${pageContext.request.contextPath}/partner/FindByTypeServlet?mType=${mem.PartnerVO.eventType}"><img src="../partner/img/icon-tag.png">${mem.PartnerVO.eventType}
													 <a href="mapFP.jsp?inputAdd=${mem.PartnerVO.addr}" title="${mem.PartnerVO.addr}"><img src="../partner/img/icon-location.png">${mem.PartnerVO.getAddr().toString().substring(0,3)}</a>
													<fmt:formatDate value="${mem.PartnerVO.eventDate}"
														var="formattedDate" type="date" pattern="yyyy年M月d日 H:mm" />
													<a href="#" title="${formattedDate}"><img src="../partner/img/icon-time.png">
													
													<fmt:formatDate value="${mem.PartnerVO.eventDate}"
														var="formattedDate" type="date" pattern="M月d日 H:mm" />
													${formattedDate}</a>

													<c:if test="${!mem.PartnerVO.memberId.equals(member.memberId)}">
														<a href="#" data-toggle="modal" data-target="#myModal2" onclick="openNewWindow(${mem.PartnerVO.eventNo})"><img src="../partner/img/icon-more.png">檢舉</a>
													</c:if>

													<c:if test="${mem.PartnerVO.memberId.equals(member.memberId)}">
														<a href="#" data-toggle="modal" data-target="#myModal" onclick="editEvent('${mem.PartnerVO.eventNo}','${mem.PartnerVO.eventType}','${mem.PartnerVO.eventTitle}','${mem.PartnerVO.eventContent}','${mem.PartnerVO.addr}','${mem.PartnerVO.imgNo}')"><img src="../partner/img/icon-more.png")">編輯</a>
													</c:if>
												</div></td>
										</tr>
									</table>
									
								</li>
							</c:forEach>
							<!-- End of grid blocks -->
						</ul>
					</div>
				</div>



			</div>
		</div>
	</div>





<!-- 新增找伴活動Modal -->
	<div class="modal fade" id="newPartner" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增找伴活動</h4>
				</div>
				<div class="modal-body">
					<form name="insertMemberFormA" action="NewEventServlet" id="jinsert"
						method="POST" enctype="multipart/form-data">
						<div class="form-group">
							<label>事件類型:</label><br>
							<input id='num' style="text-align: left" name="type" type="text" size="14">
						</div>
						<div class="form-group">
							<label>標題:</label><br>
							<input id='num' style="text-align: left" name="title" type="text" size="42">
						</div>
						<div class="form-group">
							<label>內文:</label><br>
							<textarea name="content" type="text" size="54" class="form-textarea"></textarea>
						</div>
						<div class="form-group">
							<label>地點:</label><br>
							<input name="address" type="text" size="54">
						</div>
						<div class="form-group">
							<label>圖片:</label><br>
							<input id="selectpic1" name="photo" type="file" size="14" accept="image/*">
							<div id="pic1"></div>
							<div id="result1"></div>
						</div>
					</form>

				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" onclick="createsubmit()">送出</button>
				</div>
			</div>
		</div>
	</div>
	
	
	
<!-- 編輯貼文Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">編輯貼文</h4>
      </div>
      <div class="modal-body">

		<form name="insertMemberFormB" action="UpdateEventServlet" id="jupdate" method="POST">
		    <input id='num' style="text-align:left" name="eno2" type="hidden" size="14">
		    <div class="form-group">
			    <label>事件類型:</label><br>
			    <input id='num' style="text-align:left" name="type2" type="text" size="14">
			</div>
			<div class="form-group">
			    <label>標題:</label><br>
			    <input id='num' style="text-align:left" name="title2" type="text" size="42">
			</div>
			<div class="form-group">
			    <label>內文:</label><br>
			    <textarea name="content2" type="text" size="54" class="form-textarea"></textarea>
			</div>
			<div class="form-group">
			    <label>地點:</label><br>
		        <input name="address2" type="text" size="54">
		    </div>
		    <div  class="form-group">
			    <label>圖片:</label><br>
			    <input id="selectpic" name="photo" type="file" size="14" accept="image/*">
				<div id="pic"></div>
				<div id="result"></div>
		    </div>
		</form>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">關閉</button>
        <button type="button" class="btn btn-primary"  onclick="jsubmit()">送出</button>
      </div>
    </div>
  </div>
</div>






<!-- 檢舉貼文Modal -->
<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">檢舉貼文</h4>
      </div>
      <div class="modal-body">
		<form name="insertMemberFormA" action="../comment/NewCommentServlet" id="jcomment" method="POST">
        <input name="eno" id="eno" type="hidden" size="54" value="${param.t}">
	    <label>檢舉原因:</label>
	         <select id="selectoption" name="content">
	         	<option>這則貼文是垃圾訊息或詐騙</option>
	         	<option>這則貼文是廣告</option>
	         	<option>色情內容</option>
	         	<option>違反智慧財產權</option>
	         </select>
		</form>
      </div>
      <div class="modal-footer">
        <button type="button" id="btncommentclose" class="btn btn-default" data-dismiss="modal">關閉</button>
        <button type="button" id="btncommentsubmit" class="btn btn-primary" onclick="jcomment()">送出</button>
      </div>
    </div>
  </div>
</div>



<script type="text/javascript">
	$('#btnsearch').click(function() {
		
		
		
// 		$.ajax({
// 			url: "${pageContext.request.contextPath}/partner/SearchServlet",
//             data: {
//             		"eventTitleContent": $("#inputAdd").val(),
//             	  },
//             type:"POST",
//             dataType:'text',

//             success: function(msg){
//                 alert(msg);
//             },

//              error:function(xhr, ajaxOptions, thrownError){ 
//                 alert(xhr.status); 
//                 alert(thrownError); 
//              }
//         });
	});

</script>



<script type="text/javascript">
	$('#btncommentsubmit').click(function() {
		$('#btncommentclose').click()
		$.ajax({
			url: "${pageContext.request.contextPath}/comment/NewCommentServlet",
            data: {
            		"content": $("#selectoption").val(),
            		"eno": $("#eno").val() 
            	  },
            type:"POST",
            dataType:'text',

            success: function(msg){
                alert(msg);
            },

             error:function(xhr, ajaxOptions, thrownError){ 
                alert(xhr.status); 
                alert(thrownError); 
             }
        });
	});

</script>







<!-- 送出參加活動訊息Modal -->
<div class="modal fade" id="myModal3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">確定送出參加活動請求？</h4>
      </div>
      <div class="modal-body">

		<form name="insertMemberFormC" action="${pageContext.request.contextPath}/message/writeMessage.do" id="jmessage" method="POST">
		    <input id='xxxeno' style="text-align:left" name="eno" type="hidden" size="14">
		    <input id='xxx1' style="text-align:left" id="messageFrom" name="messageFrom" value="${member.memberId}" type="hidden" size="14">
		    <input id='xxx2' style="text-align:left" id="messageTo" name="messageTo" type="hidden" size="14">
		    <label>你還想說:</label><br>
	        <textarea id="xxx3" name="message" class="form-textarea"></textarea>
		</form>
		
      </div>
      <div class="modal-footer">
        <button type="button" id="btn2" class="btn btn-default" data-dismiss="modal">取消</button>
        <button type="button" id="btn1" class="btn btn-primary"  >確定</button>
      </div>
    </div>
  </div>
</div>




<script type="text/javascript">
	$('#btn1').click(function() {
		$('#btn2').click()
		$.ajax({
			url: "${pageContext.request.contextPath}//AjaxMessage",
            data: {
            		"eno": $("#xxxeno").val(),
            		"messageFrom": $("#xxx1").val(),
            		"messageTo": $("#xxx2").val(),
            		//"messageTitle": $("#xxx3").val(),
            		"message": $("#xxx3").val()
            	  },
            type:"POST",
            dataType:'text',

            success: function(msg){
                alert(msg);
            },

             error:function(xhr, ajaxOptions, thrownError){ 
                alert(xhr.status); 
                alert(thrownError); 
             }
        });
	});

</script>




	<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/jquery.imagesloaded.js"></script>
<script src="js/jquery.wookmark.min.js"></script>

<script>
(function ($){
	  $('#tiles').imagesLoaded(function() {
	    // Prepare layout options.
	    var options = {
	      autoResize: true, // This will auto-update the layout when the browser window is resized.
	      container: $('#main'), // Optional, used for some extra CSS styling
	      offset: 2, // Optional, the distance between grid items
	      itemWidth: 250, // Optional, the width of a grid item
	      fillEmptySpace: false // Optional, fill the bottom of each column with widths of flexible height
	    };

	    // Get a reference to your grid items.
	    var handler = $('#tiles li'),
	      filters = $('#filters a');

	    // Call the layout function.
	    handler.wookmark(options);

	    /**
	     * When a filter is clicked, toggle it's active state and refresh.
	     */
	    var onClickFilter = function(e) {
	      var $item = $(e.currentTarget),
	        activeFilters = [],
	        filterType = $item.data('filter');

	      if (filterType === 'all') {
	        filters.removeClass('active');
	      } else {
	        $item.toggleClass('active');

	        // Collect active filter strings
	        filters.filter('.active').each(function() {
	          activeFilters.push($(this).data('filter'));
	        });
	      }

	      handler.wookmarkInstance.filter(activeFilters, 'and');
	    }

	    // Capture filter click events.
	    $('#filters').on('click.wookmark-filter', 'a', onClickFilter);
	  });
	})(jQuery);
</script>







<script type="text/javascript">

	function createEvent(num1,num2,num3,num4,num5){
		$("[name='eno']").val(num1);
		$("[name='type']").val(num2);
		$("[name='title']").val(num3);
		$("[name='content']").val(num4);
		$("[name='address']").val(num5);
	}
	
	function createsubmit(){
		document.getElementById("jinsert").submit();
	}
	
	$("#selectpic1").change(function(){
		$("#pic1").empty();
		
		var result = document.getElementById("result1"); 
		var input = document.getElementById("selectpic1"); 
		var files = this.files 
		console.log(files.length)
		var i=0;
		$('#result1').empty();
		if(files.length>4){
			alert("請只能選擇四張照片")
		}else{
			
				var file=files[0];
				var reader = new FileReader(); 
				reader.readAsDataURL(file); 
				var j=1;
				reader.onload = function(e){ 
				result.innerHTML += '<img  height="180" width="220" src="'+this.result+'" id="img'+j+'" /><input type="hidden" name="picstring" value="['+this.result+']" />' 
				j++;
				} 		
				i++;
			}
		
	})
	
	function editEvent(num1,num2,num3,num4,num5,num6){
		$("[name='eno2']").val(num1);
		$("[name='type2']").val(num2);
		$("[name='title2']").val(num3);
		$("[name='content2']").val(num4);
		$("[name='address2']").val(num5);
		$("[name='imgNo']").val(num6);
		
		var img =document.createElement("img")
		img.src="${pageContext.request.contextPath}/GetImg?imgid="+num6;
		img.style.width="220px";
		img.style.height="180px";
		$('#result').empty();
		$("#pic").empty();
		$("#pic").append(img);
		
	}
	$("#selectpic").change(function(){
		$("#pic").empty();
		
		var result = document.getElementById("result"); 
		var input = document.getElementById("selectpic"); 
		var files = this.files 
		console.log(files.length)
		var i=0;
		$('#result').empty();
		if(files.length>4){
			alert("請只能選擇四張照片")
		}else{
			
				var file=files[0];
				var reader = new FileReader(); 
				reader.readAsDataURL(file); 
				var j=1;
				reader.onload = function(e){ 
				result.innerHTML += '<img  height="180" width="220" src="'+this.result+'" id="img'+j+'" /><input type="hidden" name="picstring" value="['+this.result+']" />' 
				j++;
				} 		
				i++;
			}
		
	})
	
	
	
	
// 	function sendImgNo(){
// 		document.getElementsByName("imgNo");
// 		$("[name='imgNo']").val();
// 	}
	
	function jsubmit(){
		document.getElementById("jupdate").submit();
	}
	function attend(xxxeno,xxx1,xxx2){
		$("[name='eno']").val(xxxeno);
 		$("[name='messageFrom']").val(xxx1);
 		$("[name='messageTo']").val(xxx2);
 		//$("[name='message']").val(xxx3);
	}
	
	function jmessage(){
		document.getElementById("jmessage").submit();
	}
	
	function openNewWindow(num){
		$("[name='eno']").val(num);
	}
	
	function searchsubmit(){
		document.getElementById("jsearch").submit();
	}

// 	function jcomment(){
// 		document.getElementById("jcomment").submit();
// 	}
	
	
	

// 	function show() {
// 		var box = document.getElementsByName("box");
// 		var text= [];
// 		var newBox= [];
// 		var btn= [];
// 		for(var i=0;i<box.length;i++){
// 			text[i] = box[i].innerHTML;
// 			newBox[i] = document.createElement("div");
// 			btn[i] = document.createElement("a");
// 			newBox[i].innerHTML = text[i].substring(0, 8);
// 			btn[i].innerHTML = text[i].length > 8 ? "...顯示全部" : "";
// 			btn[i].href = "###";
// 			btn[i].onclick = function() {
// 				if (this.innerHTML == "...顯示全部") {
// 					this.innerHTML = "收起";
// 					newBox[i].innerHTML = text[i];
// 				} else {
// 					this.innerHTML = "...顯示全部";
// 					newBox[i].innerHTML = text[i].substring(0, 10);
// 				}
// 			}
// 			box[i].innerHTML = "";
// 			box[i].appendChild(newBox[i]);
// 			box[i].appendChild(btn[i]);
// 		}

// 		}
// 	show();
</script>
</body>
</html>