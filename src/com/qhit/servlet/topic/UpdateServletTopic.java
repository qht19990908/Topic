package com.qhit.servlet.topic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.entity.Topic;
import com.qhit.servic.TopicService;
import com.qhit.servic.impl.TopicServiceimpl;

public class UpdateServletTopic extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		Logger logger=Logger.getLogger(UpdateServletTopic.class.getName());
		PrintWriter pw=response.getWriter();
		String contextPath=request.getContextPath();//根路径
		TopicService ts = new TopicServiceimpl();
		String tid=request.getParameter("tid");
		int _tid=Integer.parseInt(tid);
		String tnam=request.getParameter("tnam");
		Topic t=new Topic();
		t.setTid(_tid);
		t.setTnam(tnam);
		int flag=ts.updateTopic(t);
		if(flag==-1){
			pw.write("<script type=\"text/javascript\">");
			pw.write("alert(\"新闻主题已经存在,请重新输入！\");");
			pw.write("location.href=\""+contextPath +"/newspages/topic_update.jsp?tid="+tid+"&tnam="+tnam+"\";");
			pw.write("</script>");
			logger.warn("新闻主题已经存在！");
		}else{
			pw.write("<script type=\"text/javascript\">");
			pw.write("alert(\"新闻主题修改成功！\");");
			pw.write("location.href=\""+contextPath +"/util/listServletTopic\";");
			pw.write("</script>");
			logger.info("新闻主题修改成功！");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
