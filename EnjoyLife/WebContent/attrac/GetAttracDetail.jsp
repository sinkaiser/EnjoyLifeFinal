<%@page import="java.io.Console"%>
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
ResultSet rset = null;
PreparedStatement stmt=null;
String url2 = "jdbc:sqlserver://i7zjbwchx7.database.windows.net:1433;database=EnjoyLife";
String query=null;	
String query2=null;	
String attracno = request.getParameter("attracno");
	try {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection conn = DriverManager.getConnection(url2, "enjoylife", "P@ssw0rd");
 		if(attracno!=null){
			query2="select * FROM photos  where AttracNo=?";
			stmt = conn.prepareStatement(query2);
			stmt.setString(1, attracno);
			rset = stmt.executeQuery();
			List  phtotdata = new LinkedList();
			List  phtotname = new LinkedList();
			while(rset.next()) {	
				phtotdata.add(rset.getString("photodata"));
				phtotname.add(rset.getString("photoname"));
			} 
			stmt.close();
 			rset.close();
 			query="SELECT  *  FROM  attrac full join cate1 on attrac.cate1no=cate1.cate1no full join cate2 on attrac.cate2no=cate2.cate2no where AttracNo=?";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, attracno);
			rset = stmt.executeQuery();
			List  l1 = new LinkedList();
			if(rset.next()) {			
					Map m1 = new HashMap(); 
					m1.put("attracNo",rset.getString("AttracNo")); 
					m1.put("stitle", rset.getString("stitle"));
					m1.put("cate1name",rset.getString("cate1name"));
					m1.put("cate2name",rset.getString("cate2name"));
					m1.put("info",rset.getString("info"));
					m1.put("xbody",rset.getString("xbody"));
					m1.put("address",rset.getString("addr"));
					m1.put("time",rset.getString("time"));
					m1.put("mrt",rset.getString("mrt"));
					m1.put("photoname",phtotname); 
					m1.put("photodata", phtotdata);		
					l1.add(m1);
			} 
			stmt.close();
 			rset.close();		
			String jsonString = JSONValue.toJSONString(l1);                    
			 out.println(jsonString);
 		}

	} catch (SQLException e) {
		out.println("Error:" + e.getMessage());
	} finally {
		if(rset != null){
			   rset.close();
		}
		if(stmt!=null){
			stmt.close();
		}
	}

%>