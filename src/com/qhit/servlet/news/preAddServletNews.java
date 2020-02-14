package com.qhit.servlet.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.entity.Topic;
import com.qhit.servic.TopicService;
import com.qhit.servic.impl.TopicServiceimpl;

public class preAddServletNews extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		TopicService ts = new TopicServiceimpl();
		List<Topic> list = ts.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/newspages/news_add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
