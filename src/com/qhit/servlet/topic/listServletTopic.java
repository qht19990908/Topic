package com.qhit.servlet.topic;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.entity.Topic;
import com.qhit.servic.TopicService;
import com.qhit.servic.impl.TopicServiceimpl;
import com.qhit.servlet.news.DelServletNews;

public class listServletTopic extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw = response.getWriter();
		String contextPath = request.getContextPath();// 根路径
		Logger logger=Logger.getLogger(DelServletNews.class.getName());
		if(request.getSession().getAttribute("name")==null){
			pw.write("<script type=\"text/javascript\">");
			pw.write("alert(\"非法用户！\");");
			pw.write("location.href=\""+contextPath +"/index1.jsp\";");
			pw.write("</script>");
			logger.warn("非法用户！");
		}else{
			TopicService ts = new TopicServiceimpl();
			List<Topic> list = ts.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/newspages/topic_list.jsp").forward(request, response);
	}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
