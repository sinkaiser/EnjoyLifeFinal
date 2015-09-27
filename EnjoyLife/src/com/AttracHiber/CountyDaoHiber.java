package com.AttracHiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.AttracModel.CountyBean;
import com.AttracModel.CountyDao;

public class CountyDaoHiber implements CountyDao{
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=Attractions";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	public static void main(String[] args) {
		List<CountyBean> beans =new ArrayList<CountyBean>();
		CountyDaoHiber dao =new CountyDaoHiber();
		beans=dao.selectall();
		for(CountyBean bean:beans){
			System.out.println(bean);
		}
	}
	
	private static final String SELECT_ALL =
			"select * from counties";
	@Override
	public List<CountyBean> selectall() {
		List<CountyBean> result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {			
			rset = stmt.executeQuery();
			result= new ArrayList<CountyBean>();
			while (rset.next()) {
				CountyBean bean = new CountyBean();
				bean.setCountyno(rset.getInt("countyno"));
				bean.setCountyname(rset.getString("countyname"));
				result.add(bean);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	

}
