package com.qhit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.core.DBHelp;

public class BaseDao {
	
	private Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public BaseDao(Connection conn){
		this.conn=conn;
	}
	
	public ResultSet executeQuery(String sql,Object... obj){
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public int executeUpdate(String sql,Object... obj){
		int flag=0;
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			flag=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
	}

}
