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
String option=null;
String attracno = request.getParameter("attracno");
String cate1no = request.getParameter("cate1no");
String cate2no = request.getParameter("cate2no");
String countyno = request.getParameter("countyno");
String distno = request.getParameter("distno");
String offset=request.getParameter("offset");
int crossdistno=0;
int firstno=0;
if(offset!=null){
	crossdistno=Integer.parseInt(countyno)/10;
	firstno=Integer.parseInt(offset);
}
String cross=crossdistno+"";
	try {
		DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Connection conn = DriverManager.getConnection(url2, "enjoylife", "P@ssw0rd");
 		if(attracno!=null){
			query="select  attrac.AttracNo,stitle,addr,photoname,photodata from( select AttracNo ,photodata, photoname ,sort from ( select  AttracNo ,photodata, photoname ,row_number() over (partition by AttracNo order by photoname asc)as sort from photos )APS where sort=1)APS1 full join attrac "+
					 "on APS1.AttracNo=attrac.AttracNo where attrac.AttracNo=? and show=1";
			stmt = conn.prepareStatement(query);
			stmt.setString(1, attracno);
			rset = stmt.executeQuery();
			List  l1 = new LinkedList();
			if(rset.next()) {
				Map m1 = new HashMap(); 
				m1.put("attracNo",rset.getString("AttracNo")); 
				m1.put("stitle", rset.getString("stitle"));
				m1.put("address",rset.getString("addr"));
				m1.put("photoname",rset.getString("photoname")); 
				m1.put("photodata", rset.getString("photodata"));
				l1.add(m1);
			} 
			stmt.close();
			rset.close();
			String jsonString = JSONValue.toJSONString(l1);                    
			 out.println(jsonString);
 		}
 		if(attracno==null){
			if((cate2no.equalsIgnoreCase("10")||cate2no.equalsIgnoreCase("200"))
	 				&&countyno.equalsIgnoreCase("10")){
				System.out.println("00000");
				query="select  AttracNo,stitle from attrac where cate1no=? and show=1 order by AttracNo OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY ";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, cate1no);
				stmt.setInt(2, firstno);			
			}else if((cate2no.equalsIgnoreCase("10")||cate2no.equalsIgnoreCase("200"))
					&&distno.equalsIgnoreCase(cross)){
				System.out.println("11111"+cate1no+countyno);			
				query="select  AttracNo,stitle from attrac where cate1no=? and countyno=? and show=1 order by AttracNo OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, cate1no);
				stmt.setString(2, countyno);
				stmt.setInt(3, firstno);	
			}else if(countyno.equalsIgnoreCase("10")){
				System.out.println("22222");
				query="select  AttracNo,stitle from attrac where cate1no=? and cate2no =? and show=1 order by AttracNo OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, cate1no);
				stmt.setString(2, cate2no);
				stmt.setInt(3, firstno);	
			}else if((cate2no.equalsIgnoreCase("10")||cate2no.equalsIgnoreCase("200"))
					&&!countyno.equalsIgnoreCase("10")){
				System.out.println("33333");
				query="select  AttracNo,stitle from attrac where cate1no=? and countyno=? and distno=? and show=1 order by AttracNo OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, cate1no);
				stmt.setString(2, countyno);
				stmt.setString(3, distno);
				stmt.setInt(4, firstno);
			}else if(distno.equalsIgnoreCase(cross)){
				System.out.println("44444");
				query="select  AttracNo,stitle from attrac where cate1no=? and cate2no = ? and countyno=? and show=1 order by AttracNo OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, cate1no);
				stmt.setString(2, cate2no);
				stmt.setString(3, countyno);
				stmt.setInt(4, firstno);
			}else{
				System.out.println("55555");
				query="select  AttracNo,stitle from attrac where cate1no=? and cate2no = ? and countyno=? and distno=? and show=1 order by AttracNo OFFSET ? ROWS FETCH NEXT 20 ROWS ONLY";
				stmt = conn.prepareStatement(query);
				stmt.setString(1, cate1no);
				stmt.setString(2, cate2no);
				stmt.setString(3, countyno);
				stmt.setString(4, distno);
				stmt.setInt(5, firstno);
			}	
			
			rset = stmt.executeQuery();
			List  l1 = new LinkedList();

			while(rset.next()) {
					Map m1 = new HashMap(); 
					m1.put("attracNo",rset.getString("AttracNo")); 
					m1.put("stitle", rset.getString("stitle"));
					l1.add(m1);
			} 
			
			
			String jsonString = JSONValue.toJSONString(l1);
			firstno+=20; 
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