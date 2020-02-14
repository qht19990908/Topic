package com.qhit.servlet.topic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.servic.TopicService;
import com.qhit.servic.impl.TopicServiceimpl;

public class DelServletTopic extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		Logger logger=Logger.getLogger(DelServletTopic.class.getName());
		PrintWriter pw=response.getWriter();
		String contextPath=request.getContextPath();//��·��
		TopicService ts = new TopicServiceimpl();
		String tid=request.getParameter("tid");
		int _tid=Integer.parseInt(tid);
		int flag=ts.deleteTopic(_tid);
		if(flag==-1){
		pw.write("<script type=\"text/javascript\">");
		pw.write("alert(\"����������������,����ɾ����\");");
		pw.write("location.href=\""+contextPath +"/util/listServletTopic\";");
		pw.write("</script>");
		logger.warn("��������ɾ��ʧ�ܣ�");
		}else{
		pw.write("<script type=\"text/javascript\">");
		pw.write("alert(\"��������ɾ���ɹ���\");");
		pw.write("location.href=\""+contextPath +"/util/listServletTopic\";");
		pw.write("</script>");
		logger.info("��������ɾ���ɹ���");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
