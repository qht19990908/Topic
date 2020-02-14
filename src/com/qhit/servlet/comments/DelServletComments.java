package com.qhit.servlet.comments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.servic.CommentsService;
import com.qhit.servic.impl.CommentsServiceimpl;
import com.qhit.servlet.news.AddServletNews;

public class DelServletComments extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw=response.getWriter();
		String contextPath=request.getContextPath();//��·��
		Logger logger=Logger.getLogger(DelServletComments.class.getName());
		CommentsService cs=new CommentsServiceimpl();
		String nid=request.getParameter("nid");
		String cid=request.getParameter("cid");
		int _cid=Integer.parseInt(cid);
		int flag=cs.deleteCommentCid(_cid);
		if(flag==-1){
		pw.write("<script type=\"text/javascript\">");
		pw.write("alert(\"��������ɾ��ʧ�ܣ�\");");
		pw.write("location.href=\""+contextPath +"/newspages/news_update.jsp\";");
		pw.write("</script>");
		logger.warn("��������ɾ��ʧ�ܣ�");
		}else{
		pw.write("<script type=\"text/javascript\">");
		pw.write("alert(\"��������ɾ���ɹ���\");");
		pw.write("location.href=\""+contextPath +"/util/news?opr=preUpdate&nid="+nid+"\";");
		pw.write("</script>");
		logger.info("��������ɾ���ɹ���");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
