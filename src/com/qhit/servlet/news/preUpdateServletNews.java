package com.qhit.servlet.news;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.entity.Comments;
import com.qhit.entity.News;
import com.qhit.entity.Topic;
import com.qhit.servic.CommentsService;
import com.qhit.servic.NewsService;
import com.qhit.servic.TopicService;
import com.qhit.servic.impl.CommentsServiceimpl;
import com.qhit.servic.impl.NewsServiceimpl;
import com.qhit.servic.impl.TopicServiceimpl;

public class preUpdateServletNews extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		NewsService ns = new NewsServiceimpl();
		TopicService ts = new TopicServiceimpl();
		CommentsService cs = new CommentsServiceimpl();
		String id = request.getParameter("nid");
		News news = ns.findNewsByNid(Integer.parseInt(id));// 查询新闻的具体内容
		List<Topic> list = ts.findAll();// 查询新闻列表---topic
		List<Comments> comments = cs.findCommentsCid(Integer.parseInt(id));
		request.setAttribute("comments", comments);
		request.setAttribute("news", news);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/newspages/news_update.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
