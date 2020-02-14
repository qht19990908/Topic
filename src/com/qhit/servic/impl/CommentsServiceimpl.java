package com.qhit.servic.impl;

import java.sql.Connection;
import java.util.List;

import com.qhit.core.DBHelp;
import com.qhit.dao.CommentsDao;
import com.qhit.dao.impI.CommentsDaoimpl;
import com.qhit.entity.Comments;
import com.qhit.servic.CommentsService;

public class CommentsServiceimpl implements CommentsService{

	private Connection conn;
	
	public int deleteComments(int cnid) {
		int result;
		conn=DBHelp.getConn();
		CommentsDao dao=new CommentsDaoimpl(conn);
		result=dao.deleteCommentsByNid(cnid);
		DBHelp.closeAll(null, null, conn);
		return result;
	}

	public List<Comments> findCommentsByNid(int nid) {
		conn=DBHelp.getConn();
		CommentsDao dao=new CommentsDaoimpl(conn);
		List<Comments>list=dao.findCommentsByNid(nid);
		return list;
	}

	public int addComments(Comments c) {
		int result;
		conn=DBHelp.getConn();
		CommentsDao dao=new CommentsDaoimpl(conn);
		result=dao.addComments(c);
		DBHelp.closeAll(null, null, conn);
		return result;
	}

	public List<Comments> findCommentsCid(int cid) {
		conn=DBHelp.getConn();
		CommentsDao dao=new CommentsDaoimpl(conn);
		Comments c=null;
		List<Comments> list=dao.findCommentsCid(cid);
		DBHelp.closeAll(null, null, conn);
		return list;
	}

	public int updateComments(Comments c) {
		int result;
		conn=DBHelp.getConn();
		CommentsDao dao=new CommentsDaoimpl(conn);
		result=dao.updateComments(c);
        DBHelp.closeAll(null, null, conn);
		return result;
	}

	public int deleteCommentCid(int cid) {
		int result;
		conn=DBHelp.getConn();
		CommentsDao dao=new CommentsDaoimpl(conn);
		result=dao.deleteCommentCid(cid);
		DBHelp.closeAll(null, null, conn);
		return result;
	}

}
