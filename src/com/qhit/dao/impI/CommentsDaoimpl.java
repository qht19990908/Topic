package com.qhit.dao.impI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.core.DBHelp;
import com.qhit.dao.BaseDao;
import com.qhit.dao.CommentsDao;
import com.qhit.entity.Comments;

public class CommentsDaoimpl extends BaseDao implements CommentsDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public CommentsDaoimpl(Connection conn) {
		super(conn);
	}

	public int deleteCommentsByNid(int cnid) {
		int result;
		String sql="DELETE FROM COMMENTS WHERE CNID=?";
		result=executeUpdate(sql, cnid);
		DBHelp.closeAll(rs, null, null);
		return result;
	}

	public List<Comments> findCommentsByNid(int nid) {
		List<Comments>list=new ArrayList<Comments>();
		String sql="SELECT * FROM COMMENTS WHERE CNID=? ORDER BY CDATE DESC";
		try {
			rs=executeQuery(sql, nid);
			Comments c=null;
			while(rs.next()){
			c=new Comments();
			c.setCid(rs.getInt("cid"));
            c.setCnid(rs.getInt("cnid"));
            c.setCauthor(rs.getString("cauthor"));
            c.setCip(rs.getString("cip"));
            c.setCcontent(rs.getString("ccontent"));
            c.setCdate(rs.getTimestamp("cdate"));
            list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}

	public int addComments(Comments c) {
		int result;
		String sql="INSERT INTO COMMENTS VALUES(NULL,?,?,?,?,?)";
		result=executeUpdate(sql, c.getCnid(),c.getCcontent(),c.getCdate(),c.getCid(),c.getCauthor());
		return result;
	}

	public List<Comments> findCommentsCid(int cid) {
		List<Comments> list=new ArrayList<Comments>();
		String sql="SELECT * FROM COMMENTS WHERE CNID=?";
		Comments c=null;
		try {
			rs=executeQuery(sql, cid);
			while(rs.next()){
				c=new Comments();
				c.setCid(rs.getInt("cid"));
				c.setCnid(rs.getInt("cnid"));
				c.setCcontent(rs.getString("ccontent"));
				c.setCdate(rs.getTimestamp("cdate"));
				c.setCip(rs.getString("cip"));
				c.setCauthor(rs.getString("cauthor"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}

	public int updateComments(Comments c) {
		int result;
		String sql="UPDATE COMMENTS SET CNID=?,CCONTENT=?,CDATE=?,CIP=?,CAUTHOR=? WHERE CID=?";
		result=executeUpdate(sql, c.getCnid(),c.getCcontent(),c.getCdate(),c.getCip(),c.getCauthor(),c.getCid());
		return result;
	}

	public int deleteCommentCid(int cid) {
		int result;
		String sql="DELETE FROM COMMENTS WHERE CID=?";
		result=executeUpdate(sql, cid);
		DBHelp.closeAll(rs, null, null);
		return result;
	}

}
