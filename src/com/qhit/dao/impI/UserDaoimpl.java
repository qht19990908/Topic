package com.qhit.dao.impI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qhit.dao.BaseDao;
import com.qhit.dao.UserDao;
import com.qhit.entity.User;

public class UserDaoimpl extends BaseDao implements UserDao{

	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDaoimpl(Connection conn) {
		super(conn);
	}

	public User checkUser(User u) {
		String sql="SELECT * FROM NEWS_USERS WHERE UNAME=? AND UPWD=?";
		User user=null;
		try {
			rs=executeQuery(sql, u.getUname(),u.getUpwd());
			while(rs.next()){
				user=new User();
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
