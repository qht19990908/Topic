package com.qhit.servlet.comments;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.qhit.entity.Comments;
import com.qhit.servic.CommentsService;
import com.qhit.servic.impl.CommentsServiceimpl;
import com.qhit.servlet.news.AddServletNews;

public class AddServletComments extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter pw=response.getWriter();
		String contextPath=request.getContextPath();//根路径
		Logger logger=Logger.getLogger(AddServletComments.class.getName());
		CommentsService cs=new CommentsServiceimpl();
		String nid=request.getParameter("nid");
		String ccontent=request.getParameter("ccontent");
		String cdate=request.getParameter("cdate");
		String cip=request.getParameter("cip");
		String cauthor=request.getParameter("cauthor");
		Comments c=new Comments();
		c.setCnid(Integer.parseInt(nid));
		c.setCcontent(ccontent);
		c.setCdate(new java.util.Date());
		c.setCip(cip);
		c.setCauthor(cauthor);
		int flag=cs.addComments(c);
		pw.write("<script type=\"text/javascript\">");
		pw.write("alert(\"新闻评论创建成功！\");");
		pw.write("location.href=\"" + contextPath + "/util/readServletComments?nid="+Integer.parseInt(nid)+"\";");
		pw.write("</script>");
		logger.info("新闻评论创建成功！");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
