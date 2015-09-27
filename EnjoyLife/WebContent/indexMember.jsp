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

<title>Home</title>
 <style>
  .ui-helper-hidden-accessible { display:none; }
  </style>
</head>
<body>

<h3>Welcome
<img src="${pageContext.request.contextPath}/GetImg?imgid=${member.picture}" height="30" width="30" onerror="this.style.display='none'"> 
${member.memberName}
</h3>
	<c:choose>
	<c:when test="${empty member}">
		<a href="${pageContext.request.contextPath}/secure/login.jsp">登入</a><br>
		<a href="${pageContext.request.contextPath}/display/register.jsp">註冊</a><br>
		<a href="${pageContext.request.contextPath}/display/forgetpassword.jsp">忘記密碼</a><br>
	</c:when>
	<c:otherwise>		
		<form name="myData" class="navbar-form " role="search" action="searchMember.do">
  			 <div class="form-group">
   				 <input type="text" id="Search" class="form-control" id="Search" name="Search" placeholder="會員查詢" autocomplete="off">  				  				
 			 </div>
 			 
  			<button type="submit" class="btn btn-default" data-toggle="modal" data-target="#myModal" onclick="button" >送出</button>
  				<label>${ErrorMsg.search}</label>
  			<div id="div1"></div> 
		</form>
		<p><a href="${pageContext.request.contextPath}/secure/logout.jsp">登出</a></p>
		<p><a href="${pageContext.request.contextPath}/display/regisChange.jsp">修改個人資料</a></p>
		<p><a href="${pageContext.request.contextPath}/display/changePassword.jsp">修改密碼</a></p>
		<p><a href="${pageContext.request.contextPath}/friend/friend.jsp">好友功能</a></p>
		<p><a href="${pageContext.request.contextPath}/message/message.jsp">訊息功能</a></p>
	</c:otherwise>
	</c:choose>
	
</body>

<script> 
    $( function () { 
      $( "#Search" ).autocomplete( { 
    	  
        source: function ( request, callback ) { 
          var data = { term: request.term }; 
          $.ajax( { 
            url: "searchMemberAjax", 
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