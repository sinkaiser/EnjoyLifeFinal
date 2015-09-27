<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
  #txtSearch{width:300px;}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<a href="ShowAllCommentServlet">查詢所有檢舉留言(看不到已處理closed=1的檢舉留言)</a>
	<hr>
	
	<a href="ShowAllByAdminCommentServlet">管理員查詢所有檢舉留言</a>
	<hr>	
	
	<center>  
	<h3>輸入找伴事件編號列出該編號目前的被檢舉留言</h3>
	<form name="insertMemberFormC" action="FindCommentByNoServlet" method="POST">
	<table border="1" >
	<tbody >
	<tr bgcolor='tan' >
	    <td width="120" height="40">事件編號:</td>
	    <td width="600" height="40" align="left" >
	    <input id='num' style="text-align:left" name="eno" type="text" size="14">
	    <input type="submit" value="送出" >
	</tr>
	</tbody>
	</table>
	</form>
	</center>
	<hr>
	<br>
	
	<center>  
	<form name="insertMemberFormA" action="NewCommentServlet" method="POST">
	<table border="1" >
	<thead>
	<tr bgcolor='tan' ><th height="60" colspan="2" align="center">新增留言</th></tr>
	</thead>
	<tbody >

	<tr bgcolor='tan' >
	    <td width="120" height="40">檢舉事件編號:</td>
	    <td width="600" height="40" align="left" >
	         <input name="eno" type="text" size="54" value="${param.t}">
	    </td>
	</tr>
	<tr bgcolor='tan' >
	    <td width="120" height="40">內文:</td>
	    <td width="600" height="40" align="left" >
	         <input name="content" type="text" size="54">
	    </td>
	</tr>
	<tr bgcolor='tan' >
	    <td height="50" colspan="2" align="center">
	       <input type="submit" value="送出" >
	    </td>
	</tr>
	</tbody>
	</table>
	</form>
	</center>
	<hr>
	<br>
	
</body>
</html>