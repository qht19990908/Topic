package com.qhit.servic.impl;

import java.sql.Connection;

import com.qhit.core.DBHelp;
import com.qhit.dao.UserDao;
import com.qhit.dao.impI.UserDaoimpl;
import com.qhit.entity.User;
import com.qhit.servic.UserService;

public class UserServiceimpl implements UserService{

	private Connection conn;
	
	public User checkUser(User u) {
		conn=DBHelp.getConn();
		UserDao dao=new UserDaoimpl(conn);
		User user=dao.checkUser(u);
		DBHelp.closeAll(null, null, conn);
		return user;
	}

}
