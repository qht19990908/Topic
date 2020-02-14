package com.qhit.servlet.news;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qhit.entity.PageBean;
import com.qhit.servic.NewsService;
import com.qhit.servic.impl.NewsServiceimpl;

public class listServletNews extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewsService ns = new NewsServiceimpl();
		String currPageNo = request.getParameter("currPageNo");
		int page = 0;
		if (currPageNo == null) {
			page = 1;
		} else {
			page = Integer.parseInt(currPageNo);
		}
		PageBean pagebean = ns.findAll(page);
		request.setAttribute("page", pagebean);
		request.getRequestDispatcher("/newspages/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
