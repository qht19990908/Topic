package com.qhit.servlet.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.entity.User;
import com.qhit.servic.UserService;
import com.qhit.servic.impl.UserServiceimpl;
import com.qhit.servlet.news.AddServletNews;

public class loginServlet extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Logger logger=Logger.getLogger(loginServlet.class.getName());
		UserService us = new UserServiceimpl();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		User u = new User();
		u.setUname(uname);
		u.setUpwd(upwd);
		User user = null;
		user = us.checkUser(u);
		if (user != null) {
			request.getSession().setAttribute("name", uname);
			response.sendRedirect("../util/listServletTopic");
			logger.info("登陆成功！");
		} else {
			response.sendRedirect("../index1.jsp");
			logger.warn("用户名或密码错误，登录失败！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
