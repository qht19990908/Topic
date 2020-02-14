package com.qhit.servlet.comments;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.entity.Comments;
import com.qhit.entity.News;
import com.qhit.entity.PageBean;
import com.qhit.servic.CommentsService;
import com.qhit.servic.NewsService;
import com.qhit.servic.impl.CommentsServiceimpl;
import com.qhit.servic.impl.NewsServiceimpl;

public class readServletComments extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentsService cs=new CommentsServiceimpl();
		NewsService ns=new NewsServiceimpl();
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
		String nid=request.getParameter("nid");
		List<Comments> list=cs.findCommentsByNid(Integer.parseInt(nid));
		News n=ns.findNewsByNid(Integer.parseInt(nid));//查看新闻
		request.setAttribute("list", list);
		request.setAttribute("n", n);
		request.getRequestDispatcher("../newspages/news_read.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
