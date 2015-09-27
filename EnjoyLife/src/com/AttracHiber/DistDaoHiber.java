package com.AttracHiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AttracModel.DistBean;
import com.AttracModel.DistDao;

public class DistDaoHiber implements DistDao {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=Attractions";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	
	
	private static final String SELECT_BY_ID =
			"select *  from dist where countyno=?";	
	@Override
	public List<DistBean> select(int id) {
		List<DistBean> result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {	
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			result= new ArrayList<DistBean>();
			while (rset.next()) {
				DistBean bean = new DistBean();
				bean.setDistno(rset.getInt("distno"));
				bean.setDistname(rset.getString("distname"));
				bean.setCountyno(rset.getInt("countyno"));
				result.add(bean);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	private static final String SELECT_ALL =
			"select * from dist";
	@Override
	public List<DistBean> selectall() {
		List<DistBean> result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {			
			rset = stmt.executeQuery();
			result= new ArrayList<DistBean>();
			while (rset.next()) {
				DistBean bean = new DistBean();
				bean.setDistno(rset.getInt("distno"));
				bean.setDistname(rset.getString("distname"));
				bean.setCountyno(rset.getInt("countyno"));
				result.add(bean);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public static void main(String[] args) {
		DistDaoHiber distdao=new DistDaoHiber();
		List<DistBean> beans= new ArrayList<DistBean>();
		beans=distdao.select(10);
//		beans=distdao.selectall();
		for(DistBean bean:beans){
			System.out.println(bean);
		}
	}
	
}
