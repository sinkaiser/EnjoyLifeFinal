<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<link rel='stylesheet' href='../../css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show All Members</title>
</head>
<body>

<div align="center">
			<p>${result}</p>
		    <c:forEach var="mem" varStatus="statusX" items="${AllComments}">
                   <c:if test="${statusX.first}" >
                        <c:out value="<table border='1' cellspacing='5' cellpadding='5' >" escapeXml="false"/>
      		          	    <tr bgcolor="CCCC00">
			                    <td  colspan='7' ALIGN='CENTER'>會員基本資料</td>
			                </tr>
			                <tr  bgcolor="CCCC00">
			                    <th>檢舉編號</th><th>內文</th><th>被檢舉活動編號</th><th>日期</th><th>會員ID</th>
			                </tr>
                    </c:if>		         
                    <c:choose>
                             <c:when test="${ statusX.count % 2 == 0 }">
                                  <c:set var="colorVar" value="99ddff" />
                             </c:when>
                             <c:otherwise>
                                  <c:set var="colorVar" value="88dd00" />
                             </c:otherwise>
                   </c:choose>
                    <fmt:formatDate value="${mem.commentDate}" var="formattedDate" type="date" pattern="yyyy年M月d日 H:mm" />
                    <tr bgcolor="${colorVar}">
                         
                         <td>${mem.commentNo} </td>
                         <td>${mem.commentContent} </td>
                         <td>${mem.eventNo}</td>
                         <td>${formattedDate}</td>
                         <td>${mem.memberId}</td>

							<c:if test="${mem.closed==1}">
                         	<td><a href="comment/CommentHandle?handle=delete"+${mem.commentNo}><input type="button" name="delete" value="刪除"></a></td>
							</c:if>
							
                         	<c:if test="${mem.closed!=1}">
                         	<td><a href="comment/CommentHandle?handle=update"+${mem.commentNo}><input type="button" name="update" value="處理"></a></td>
                    		</c:if>
                    </tr>
                     <c:if test="${statusX.last}" >
                        <c:out value="</table>" escapeXml="flase" />
                    </c:if>		                      
		    </c:forEach>
</div>


</body>
</html>