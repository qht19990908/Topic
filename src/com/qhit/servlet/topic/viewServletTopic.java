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

public class viewServletTopic extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		TopicService ts = new TopicServiceimpl();
		String currPageNo = request.getParameter("currPageNo");
		request.getSession().invalidate();
		int page = 0;
		if (currPageNo == null) {
			page = 1;
		} else {
			page = Integer.parseInt(currPageNo);
		}
		NewsService ns = new NewsServiceimpl();
		List<News> list5 = ns.getLatestNews(4);
		Iterator<News> its = list5.iterator();
		List<News> list6 = new ArrayList<News>();
		while (its.hasNext()) {
			News news = its.next();
			int nid=news.getNid();
			String picpath = news.getNpicPath();
			String ntitle=news.getNtitle();
			String ncontent=news.getNcontent();
			// 获取图片的完整名称
			News newsForPic = new News();
			newsForPic.setNid(nid);
			newsForPic.setNpicPath(picpath);
			newsForPic.setNtitle(ntitle);
			newsForPic.setNcontent(ncontent);
			list6.add(newsForPic);
		}
		request.setAttribute("list5", list5);// 获取最近的4条新闻信息
		request.setAttribute("list6", list6);
		List<Topic> list = ts.findAll();
		request.setAttribute("list", list);
		PageBean pagebean = ns.findAll(page);
		request.setAttribute("page", pagebean);
		List<News> list1 = pagebean.getNewsList();
		List<News> list7 = new ArrayList<News>();
		List<News> list8 = new ArrayList<News>();
		List<News> list9 = new ArrayList<News>();
		for (News s : list1) {
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
		request.getRequestDispatcher("../index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
