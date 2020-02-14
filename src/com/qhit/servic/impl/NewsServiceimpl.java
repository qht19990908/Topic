package com.qhit.servic.impl;

import java.sql.Connection;
import java.util.List;

import com.qhit.core.DBHelp;
import com.qhit.dao.CommentsDao;
import com.qhit.dao.NewsDao;
import com.qhit.dao.impI.CommentsDaoimpl;
import com.qhit.dao.impI.NewsDaoimpl;
import com.qhit.entity.Comments;
import com.qhit.entity.News;
import com.qhit.entity.PageBean;
import com.qhit.servic.NewsService;

public class NewsServiceimpl implements NewsService {
	
	private Connection conn;

	public PageBean findAll(int page) {
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		PageBean pagebean=dao.findAll(page);
		DBHelp.closeAll(null, null, conn);
		return pagebean;
	}
	
	public int getNewsByTid(int tid) {
		int result;
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		result=dao.getNewsByTid(tid);
		DBHelp.closeAll(null, null, conn);
		return result;
	}
	
	public News findNewsByNid(int nid) {
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		News n=null;
		n=dao.findNewsByNid(nid);
		DBHelp.closeAll(null, null, conn);
		return n;
	}
	
	public List<News> findAllNewsByTid(int tid) {
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		List<News> list=dao.getAllnewsByTid(tid);
		DBHelp.closeAll(null, null, conn);
		return list ;
	}
	
	public int insertNews(News n) {
		int result;
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		result=dao.insertNews(n);
        DBHelp.closeAll(null, null, conn);
		return result;
	}

	public int updateNews(News n) {
		int result;
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		result=dao.updateNews(n);
        DBHelp.closeAll(null, null, conn);
		return result;
	}

	public int deleteNews(int nid) {
		int result;
		conn=DBHelp.getConn();
		NewsDao nd=new NewsDaoimpl(conn);
		CommentsDao cd=new CommentsDaoimpl(conn);
		if(cd.deleteCommentsByNid(nid)==0){
			result=nd.deleteNews(nid);
		}else{
			result=-1;
		}
        DBHelp.closeAll(null, null, conn);
		return result;
		
	}

	public List<News> getLatestNews(int limit) {
		conn=DBHelp.getConn();
		NewsDao dao=new NewsDaoimpl(conn);
		List<News> list=dao.getLatestNews(limit);
		DBHelp.closeAll(null, null, conn);
		return list;
	}

}
