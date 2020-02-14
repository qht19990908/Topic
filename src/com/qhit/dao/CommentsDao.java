package com.qhit.dao;

import java.util.List;

import com.qhit.entity.Comments;

public interface CommentsDao {
	
	public int deleteCommentsByNid(int cnid);
	
	public List<Comments> findCommentsByNid(int nid);
	
	public int addComments(Comments c);
	
	public List<Comments> findCommentsCid(int cid);
	
	public int updateComments(Comments c);
	
	public int deleteCommentCid(int cid);

}
