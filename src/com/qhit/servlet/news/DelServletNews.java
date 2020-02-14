package com.qhit.servlet.news;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.servic.NewsService;
import com.qhit.servic.impl.NewsServiceimpl;

public class DelServletNews extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String contextPath = request.getContextPath();// 根路径
		Logger logger=Logger.getLogger(DelServletNews.class.getName());
		NewsService ns = new NewsServiceimpl();
		String nid = request.getParameter("nid");
		int _nid = Integer.parseInt(nid);
		int flag = ns.deleteNews(_nid);
		if (flag == 0) {
			pw.write("<script type=\"text/javascript\">");
			pw.write("alert(\"新闻主题删除失败！\");");
			pw.write("location.href=\"" + contextPath + "/util/listServletNews\";");
			pw.write("</script>");
			logger.warn("新闻主题删除失败！");
		} else {
			pw.write("<script type=\"text/javascript\">");
			pw.write("alert(\"新闻主题删除成功！\");");
			pw.write("location.href=\"" + contextPath + "/util/listServletNews\";");
			pw.write("</script>");
			logger.info("新闻主题删除成功！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
