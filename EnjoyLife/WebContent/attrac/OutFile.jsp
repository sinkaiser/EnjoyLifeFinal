<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

	table {
		
		border:2px solid black;
		font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
		font-size: 16px;
	 	margin: 45px auto; 
		width: 1000px;
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
		border-top:2px solid black;; 
		border-bottom: 2px solid black;:
	}

	tr:hover td {
		background: #d0dafd;
		color: #339;
	}
	#title{text-align:center; border:2px solid black;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<s:form action="myAction2" namespace="/myNamespace" >
		<s:submit value="Upload to SQL" />
</s:form>  

<s:iterator value="bean.beans">
	<div >
		<table >
		<tr>
			<td id="title" >編號
			<td></td>
			<td style="text-align: center"  ><s:property value="rownumber"/>
			</td>
			<td align="right">
			<s:hidden name="Attracno" value="%{rownumber}" />
			</td>
		</tr>
		
		<tr>
		<td id="title">標題
			<td colspan="3"><s:property value="stitle"/></td>
		</tr>
		
		<tr>
		<td id="title">分類一
			<td colspan="3"><s:property value="cat1"/></td>
		</tr>
		
		<tr>
		<td id="title">分類二
			<td colspan="3"><s:property value="cat2"/></td>
		</tr>

		<s:if test="%{time!='null'}">
			<tr>
			<td id="title">開放時間
				<td colspan="3"><s:property value="time"/></td>
			</tr>
		</s:if>
		<s:if test="%{xbody!='null'}">
			<tr>
			<td id="title">內容
			<td colspan="3"><s:property value="xbody"/></td>
			</tr>
		</s:if>
		
			<tr>
			<td id="title">縣市
			<td colspan="3"><s:property value="county" />						
			</td>
			</tr>
					
			<tr>
			<td id="title">區鄉鎮
			<td colspan="3"><s:property value="dist" />	
			</td>
			</tr> 
	
			<tr>
			<td id="title">地址
			<td colspan="3"><s:property value="address" />
			</td>
			</tr>

		<s:if test="%{info!='null'}">		
			<tr>
			<td id="title">簡介
			<td colspan="3"><s:property value="info"/></td>
			</tr>
		</s:if>
		<s:if test="%{mrt!='null'}">		
			<tr>
			<td id="title">捷運
			<td colspan="3"><s:property value="mrt"/></td>
			</tr>
		</s:if>
		<s:if test="%{file.size>0 }">
			<tr>
			<td id="title">照片
			<td colspan="3">
				<s:iterator value="file">
					<img height="300" width="400" src="<s:property />">
				</s:iterator>
			</td>
			</tr>
		</s:if>
		</table>
	</div>
</s:iterator>

</body>
</html>