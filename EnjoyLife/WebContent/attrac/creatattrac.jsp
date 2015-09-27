<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="scripts/jquery-2.1.4.min.js"></script>
<script src="scripts/jquery-ui.js"></script>
<script src="scripts/jquery-ui.min.js"></script>
<link rel="stylesheet" href="scripts/bootstrap.min.css">
<script src="scripts/bootstrap.min.js"></script>
<style type="text/css">

	table {		
		border:2px double black;
		font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
		font-size: 20px;
	 	margin: 0px auto; 
		width: 600px;
		text-align: left;
		border-collapse: collapse;
		position: relative;
	 	table-layout:fixed; 
	}
	td {
		font-size: 16px;
		padding: 8px; 
		background: #e8edff; 
		color: #669;
		border-top:2px double black; 
		border-bottom: 2px double black;
	}

	tr:hover td {
		background: #d0dafd;
		color: #339;
	}

	.input{
		width: 450px;
	}
	.xbody{height:100px;width:450px;resize:none;overflow:auto;}
	#title{text-align:center; border:2px double black;font-size: 22px;width:130px;}
	.form-control{width:130px;font-size: 18px;height:4ex}
</style>
</head>
<body>
<button id="butt1" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" value="creat">
新增景點
</button>
<button id="butt2" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal" value="updata">
修改景點
</button>

  <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" ">
  <div class="modal-dialog" role="document" id="doc">
    <div class="modal-content" style="width:700px;">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
      </div>
      <div  class="modal-body" style="width:700px;">
        <s:form action="myAction3" namespace="/myNamespace" method="post">
		<table >	
		<tr>
		<td id="title">標題
			<input  type="hidden" name="picmode" />			
			<td colspan="3"><input type="text" class="input" name="bean.stitle"></td>
		</tr>	
		<tr>
		<td id="title">分類一
			<td colspan="3"><select id="select1" class="form-control"  name="bean.cat1no"></select></td>
		</tr>		
		<tr>
		<td id="title">分類二
			<td colspan="3"><select id="select2" class="form-control"  name="bean.cat2no"></select></td>
		</tr>
		<tr>
		<td id="title">開放時間
			<td colspan="3"><input type="text" class="input" name="bean.time"></td>
		</tr>
		<tr>
		<td id="title">地址
		<td colspan="3"><input type="text" class="input" name="bean.address"></td>
		</tr>		
		<tr>
		<td id="title">捷運
		<td colspan="3"><input type="text" class="input" name="bean.mrt"></td>
		</tr>
		<tr>
		<td id="title">簡介
		<td colspan="3"><input type="text" class="input" name="bean.info"></td>
		</tr>	
		<tr>
		<td id="title">內容
		<td colspan="3"><textarea class="xbody" name="bean.xbody"></textarea></td>
		</tr>	 	
		<tr>
		<td id="title">照片
		<td colspan="3" >
			<input type="file" id="file_input" accept="image/jpeg, image/png, image/gif, image/jpg"  multiple style="width:80px;height:30px;font-size:15px"/>  
			<div  id="result" style="height:200px;overflow:auto;"></div>
		</td>
		</tr>
		</table>
		<div class="modal-footer">
	        <input type="button" id="cancelbut" class="btn btn-default" value="取消" data-dismiss="modal" style="width:80px;height:30px;font-size:15px">
			<input type="submit" class="btn btn-primary" value="確定" style="width:80px;height:30px;font-size:15px;" >
		</div>
		</s:form> 		
      </div>
    </div>
  </div>
</div>

<script src="myNamespace/scripts/attraccreat.js"></script>
<script type="text/javascript">
(function($){
	
	$("#cancelbut").click(function(){
		$(":text").val("");
		$(".xbody").val("");
		$("#result").empty();
	})	
})(jQuery)

</script>
</body>
</html>