<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ReadXml</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script>!window.jQuery && document.write('<script src="scripts/jquery-2.1.4.min.js"><\/script>')</script>
<script src="https://ajax.googleapis.com/ajax/libs/prototype/1.7.2.0/prototype.js"></script>
<script src="scripts/jquery-ui.min.js"></script>
<script language="javascript">
</script>
</head>
<body> 

<p> 
<label>請選擇圖片：</label> 
<input type="file" id="file_input" accept="image/jpeg, image/png, image/gif, image/jpg"/> 
</p> 
<div id="result"></div>
<div id="div1"></div>

景點
<h1>36847f3f-deff-4183-a5bb-800737591de5</h1>
住宿
<h1>6f4e0b9b-8cb1-4b1d-a5c4-febd90f62469</h1>
	
    <s:form action="myAction"  method="post" >
		<s:textfield name="src" label="Rid" />
		<s:submit value="read" />
    </s:form> 
    
<script language="javascript">

(function($){
	$('#file_input').change(function(){
		var result = document.getElementById("result"); 
		var input = document.getElementById("file_input"); 
		var file = this.files[0]; 
		var reader = new FileReader(); 
		reader.readAsDataURL(file); 
		reader.onload = function(e){ 
			result.innerHTML = '<img src="'+this.result+'" id="img1" />' 
			console.log($('#img1').attr("src"))			
		} 		
	})	
})(jQuery)

</script>    
</body>
</html>