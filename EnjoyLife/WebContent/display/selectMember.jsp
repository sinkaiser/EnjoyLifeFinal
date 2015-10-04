<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"> 
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css"> 
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
<style type="text/css">
.ui-helper-hidden-accessible { display:none; }
 label { float: left;}  
</style>
<title>會員資料</title>
</head>
<body>
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
		<br>
		<br>		
<fieldset>
			<legend >會員資料</legend>
			<div class="form-group">
				<label for="memberId" class="col-sm-1 control-label">帳號(*)：</label>
				<p> ${search.memberId}</p>
			</div>
			<div class="form-group">
				<label for="memberName" class="col-sm-1 control-label">姓名(*)：</label>
				<p> ${search.memberName}</p>		
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-1 control-label">E-mail(*)：</label>
				<p> ${search.email}</p>	
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-1 control-label">姓別：</label>
				<p> ${search.sex}</p>
			</div>
			<div class="form-group">
				<label for="birthday" class="col-sm-1 control-label">生日：</label>
				<p> ${search.birthday}</p>	
			</div>
			<div class="form-group">
				<label for="picture" class="col-sm-1 control-label">大頭貼：</label>
				<p><img src="${pageContext.request.contextPath}/GetImg?imgid=${search.picture}" class="img-circle" style="height:65px;width:60px;box-shadow:0px 0px 10px 7px #F5FAFF;"></p>
			</div>
		</fieldset>	
		
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