package com.qhit.servic;

import java.util.List;

import com.qhit.entity.Comments;

public interface CommentsService {

	public int deleteComments(int cnid);
	
	public List<Comments> findCommentsByNid(int nid);

	public int addComments(Comments c);
	
	public List<Comments> findCommentsCid(int cid);

	public int updateComments(Comments c);
	
	public int deleteCommentCid(int cid);

}
