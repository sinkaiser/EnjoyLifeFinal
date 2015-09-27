package com.AttracHiber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.AttracModel.Cate2Bean;
import com.AttracModel.Cate2Dao;

public class Cate2DaoHiber implements Cate2Dao {
	private static final String URL = "jdbc:sqlserver://localhost:1433;database=Attractions";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "passw0rd";
	
	private static final String SELECT_ALL =
			"select * from cate2";
	@Override
	public List<Cate2Bean> selectall() {
		List<Cate2Bean> result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);) {			
			rset = stmt.executeQuery();
			result= new ArrayList<Cate2Bean>();
			while (rset.next()) {
				Cate2Bean bean = new Cate2Bean();
				bean.setCate2no(rset.getInt("cate2no"));
				bean.setCate2name(rset.getString("cate2name"));
				bean.setCate1no(rset.getInt("cate1no"));
				result.add(bean);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}
	
	private static final String SELECT_BY_ID =
			"select *  from cate2 where cate1no=?";	
	@Override
	public List<Cate2Bean> select(int id) {
		List<Cate2Bean> result = null;
		ResultSet rset = null;
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);) {	
			stmt.setInt(1, id);
			rset = stmt.executeQuery();
			result= new ArrayList<Cate2Bean>();
			while (rset.next()) {
				Cate2Bean bean = new Cate2Bean();
				bean.setCate2no(rset.getInt("cate2no"));
				bean.setCate2name(rset.getString("cate2name"));
				bean.setCate1no(rset.getInt("cate1no"));
				result.add(bean);
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}
		return result;
	}

	public static void main(String[] args) {
		Cate2DaoHiber dao=new Cate2DaoHiber();
		List<Cate2Bean> beans= new ArrayList<Cate2Bean>();
		beans=dao.select(20);
//		beans=distdao.selectall();
		for(Cate2Bean bean:beans){
			System.out.println(bean);
		}

	}

}
