package com.qhit.servlet.topic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.entity.News;
import com.qhit.entity.PageBean;
import com.qhit.entity.Topic;
import com.qhit.servic.NewsService;
import com.qhit.servic.TopicService;
import com.qhit.servic.impl.NewsServiceimpl;
import com.qhit.servic.impl.TopicServiceimpl;

public class nameServletTopic extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		NewsService ns = new NewsServiceimpl();
		List<News> list5 = ns.getLatestNews(4);
		Iterator<News> its = list5.iterator();
		List<News> list6 = new ArrayList<News>();
		while (its.hasNext()) {
			News news = its.next();
			String picpath = news.getNpicPath();
			// 获取图片的完整名称
			News newsForPic = new News();
			newsForPic.setNpicPath(picpath);
			list6.add(newsForPic);
		}
		request.setAttribute("list5", list5);// 获取最近的4条新闻信息
		request.setAttribute("list6", list6);
		
		int page = 0;
		PageBean pagebean = ns.findAll(page);
		List<News> list2 = pagebean.getNewsList();
		List<News> list7 = new ArrayList<News>();
		List<News> list8 = new ArrayList<News>();
		List<News> list9 = new ArrayList<News>();
		for (News s : list2) {
			if (list7.size() < 3) {
				if (s.getNtid() == 4) {
					list7.add(s);
				}
			}
			if (list8.size() < 3) {
				if (s.getNtid() == 2) {
					list8.add(s);
				}
			}
			if (list9.size() < 3) {
				if (s.getNtid() == 5) {
					list9.add(s);
				}
			}
		}
		request.setAttribute("list7", list7);
		request.setAttribute("list8", list8);
		request.setAttribute("list9", list9);
		
		TopicService ts = new TopicServiceimpl();
		List<Topic> list = ts.findAll();
		request.setAttribute("list", list);
		String tid = request.getParameter("tid");
		List<News> list1 = ns.findAllNewsByTid(Integer.parseInt(tid));
		PageBean page1 = new PageBean();
		page1.setNewsList(list1);
		request.setAttribute("page", page1);
		request.getRequestDispatcher("../index.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
