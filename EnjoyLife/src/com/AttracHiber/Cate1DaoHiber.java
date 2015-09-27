package com.AttracHiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.AttracModel.Cate1Bean;
import com.AttracModel.Cate1Dao;

public class Cate1DaoHiber implements Cate1Dao {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=Attractions";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";

	private static final String SELECT_ALL =
			"select * from cate1";
	@Override
	public List<Cate1Bean> selectall() {
		List<Cate1Bean> result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {			
			rset = stmt.executeQuery();
			result= new ArrayList<Cate1Bean>();
			while (rset.next()) {
				Cate1Bean bean = new Cate1Bean();
				bean.setCate1no(rset.getInt("cate1no"));
				bean.setCate1name(rset.getString("cate1name"));
				result.add(bean);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}


	private static final String SELECT_BY_ID =
			"select * from cate1 where cate1no=?";
	@Override
	public Cate1Bean select(int id) {
		Cate1Bean result=null;
		ResultSet rset = null;		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);){			
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			if (rset.next()) {
				result = new Cate1Bean();
				result.setCate1no(rset.getInt("cate1no"));
				result.setCate1name(rset.getString("cate1name"));			
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}


	public static void main(String[] args) {
		List<Cate1Bean> result = new ArrayList<Cate1Bean>();
		Cate1DaoHiber dao=new Cate1DaoHiber();
		result=dao.selectall();
		for(Cate1Bean bean:result){
			System.out.println(bean);
		}
	}
}
