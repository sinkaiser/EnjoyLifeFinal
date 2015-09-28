<%@page import="java.util.ArrayList"%>
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
String url = "jdbc:sqlserver://i7zjbwchx7.database.windows.net:1433;database=EnjoyLife";
String query2 = "select cate1no,cate1name from cate1 ";

String query = "select countyno,countyname from counties ";


try{
	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
	conn = DriverManager.getConnection(url, "sa", "sa123456");

	stmt = conn.prepareStatement(query2);
	 rs = stmt.executeQuery();

	 List  l1 = new LinkedList();
	 while (rs.next()) {
		 Map m1 = new HashMap();       
		 m1.put("cate1no",rs.getString("cate1no"));   
		 m1.put("cate1name", rs.getString("cate1name")); 	 
		 l1.add(m1);
	 }
	 stmt.close();
	 rs.close();
	 stmt = conn.prepareStatement(query);
	 rs = stmt.executeQuery();
	
	 while (rs.next()) {
		 Map m1 = new HashMap();       
		 m1.put("countyno",rs.getInt(1));   
		 m1.put("countyname", rs.getString(2)); 	 
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