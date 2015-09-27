<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>

<title>搜尋會員</title>
 <style>
  .ui-helper-hidden-accessible { display:none; }
  </style>
</head>
<body>

<!-- <h3>Welcome -->
<%-- <img src="${pageContext.request.contextPath}/GetImg?imgid=${member.picture}" height="30" width="30" onerror="this.style.display='none'">  --%>
<%-- ${member.memberName} --%>
<!-- </h3>	 -->
		<form name="myData" class="form-inline " role="search" action="${pageContext.request.contextPath}/searchMember.do">
  			 <div class="form-group">
  				 <div class="col-xs-3">
  				 	<div class="input-group">
   					 <input type="text" id="Search" class="form-control" id="Search" name="Search" placeholder="會員查詢" autocomplete="off"> 
   					 </div>
   				</div>				  				
 			 </div>
 			 <div class="form-group"> 
 			 	<div class="col-sm-offset-2 col-sm-10">				
  					<button type="submit" class="btn btn-success" data-toggle="modal" data-target="#myModal" onclick="button" >送出</button>
  					<label>${ErrorMsg.search}</label>  
  				</div>			
  			</div>
  			<div id="div1"></div> 
		</form>
</body>
<script> 
    $( function () { 
      $( "#Search" ).autocomplete( { 
    	  
        source: function ( request, callback ) { 
          var data = { term: request.term }; 
          $.ajax( { 
            url: "${pageContext.request.contextPath}/searchMemberAjax", 
            type: "GET", 
            data: data, 
            async: false, 
            complete: function ( xhr, result ) { 
              var lists = JSON.parse( xhr.responseText ); 
              callback( lists ); 
            } 
          } ); 
        }
      } ) 
    } ); 
  </script> 
</html>