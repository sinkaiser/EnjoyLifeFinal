<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.LinkedHashMap"%> 
<%@page import="java.util.Map"%>  
<%@page import="java.util.HashMap"%>
<%@page import="java.util.LinkedList"%>  
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONValue"%>
<%@ page import="java.sql.*" %>

<%
response.setHeader("Access-Control-Allow-Origin", "*");

Connection conn = null;
PreparedStatement stmt = null;
ResultSet rs = null;
String url = "jdbc:sqlserver://localhost:1433;DatabaseName=Attractions";
String query = "select cate2no,cate2name from cate2 where cate1no=?";
String cate1no = request.getParameter("cate1no");
String countyno = request.getParameter("countyno");
String query2 = "select distno,distname from dist where countyno=?";
try{
	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	conn = DriverManager.getConnection(url, "sa", "passw0rd");

	stmt = conn.prepareStatement(query);
	stmt.setString(1,cate1no);
	rs = stmt.executeQuery();

	List  l1 = new LinkedList();
	while (rs.next()) {
		Map m1 = new HashMap();       
		m1.put("cate2no",rs.getInt(1));   
		m1.put("cate2name", rs.getString(2)); 
		l1.add(m1);
	}
	stmt.close();
	rs.close();
	stmt = conn.prepareStatement(query2);
	stmt.setString(1,countyno);
	rs = stmt.executeQuery();

	while (rs.next()) {
		Map m1 = new HashMap();       
		m1.put("distno",rs.getInt(1));   
		m1.put("distname", rs.getString(2)); 
		l1.add(m1);
	}
	
	String jsonString = JSONValue.toJSONString(l1);                    
	out.println(jsonString);
}
catch(SQLException e){
	out.println("Error:" + e.getMessage());
}
finally{
	if(rs != null){
	   rs.close();
	}
	if(stmt != null){
	 stmt.close();
	}
	if(conn != null){
	}
}

%>