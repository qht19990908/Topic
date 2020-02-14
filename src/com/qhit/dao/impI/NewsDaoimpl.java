package com.qhit.dao.impI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;

import com.qhit.core.DBHelp;
import com.qhit.dao.BaseDao;
import com.qhit.dao.NewsDao;
import com.qhit.entity.Comments;
import com.qhit.entity.News;
import com.qhit.entity.PageBean;

public class NewsDaoimpl extends BaseDao implements NewsDao {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public NewsDaoimpl(Connection conn) {
		super(conn);
	}

	public PageBean findAll(int pagebean) {
		List<News> list = new ArrayList<News>();
		PageBean page=null;
		try {
			String sql = "SELECT * FROM NEWS LIMIT ?,?";
			String sql1 = "SELECT COUNT(NID) FROM NEWS";
			int count = -1;
			rs = executeQuery(sql1);
			rs.next();
			page = new PageBean();
			count = rs.getInt(1);
			page.setTotalCount(count);
			page.setCurrPageNo(pagebean);
			rs = executeQuery(sql, (page.getCurrPageNo() - 1) * page.getPageSize(), page.getPageSize());
			while (rs.next()) {
				News n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtid(rs.getInt("ntid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcreateDate(rs.getTimestamp("ncreateDate"));
				n.setNpicPath(rs.getString("npicPath"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNmodifyDate(rs.getTimestamp("nmodifyDate"));
				n.setNsummary(rs.getString("nsummary"));
				list.add(n);
				page.setNewsList(list);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, null, null);
		}
		return page;
	}

	public List<News> getLatestNewsByTid(int tid, int limit) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT NID,NTID,NTITLE FROM NEWS WHERE NTID=? ORDER BY NCREATEDATE DESC LIMIT ?";
		try {
			rs = executeQuery(sql, tid, limit);
			News n = null;
			while (rs.next()) {
				n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtid(rs.getInt("ntid"));
				n.setNtitle(rs.getString("ntitle"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}

	public int getNewsByTid(int tid) {
		int count = 0;
		String sql = "SELECT COUNT(NTID) FROM NEWS WHERE NTID=?";
		try {
			rs = executeQuery(sql, tid);
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, null, null);
		}

		return count;
	}

	public News findNewsByNid(int nid) {
		String sql = "SELECT * FROM NEWS WHERE NID=?";
		News n = null;
		try {
			rs = executeQuery(sql, nid);
			while (rs.next()) {
				n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtid(rs.getInt("ntid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcreateDate(rs.getDate("ncreateDate"));
				n.setNpicPath(rs.getString("npicPath"));
				n.setNcontent(rs.getString("ncontent"));
				n.setNmodifyDate(rs.getDate("nmodifyDate"));
				n.setNsummary(rs.getString("nsummary"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelp.closeAll(rs, null, null);
		}
		return n;
	}
	
	public Comments findCommentsByCid(int cid){
		String sql="SELECT * FROM COMMENTS WHERE CID=?";
		Comments c=null;
		try {
			rs=executeQuery(sql, cid);
			while(rs.next()){
				c=new Comments();
				c.setCid(rs.getInt("cid"));
				c.setCnid(rs.getInt("cnid"));
				c.setCcontent(rs.getString("ccontent"));
				c.setCdate(rs.getDate("cdate"));
				c.setCip(rs.getString("cip"));
				c.setCauthor(rs.getString("cauthor"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelp.closeAll(rs, null, null);
		}
		return c;
	}

	public int insertNews(News n) {
		Date date=new Date();
		SimpleDateFormat si=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		int result;
		String sql = "INSERT INTO NEWS(NTID,NTITLE,NAUTHOR,ncreateDate,NPICPATH,NCONTENT,NSUMMARY) VALUES(?,?,?,?,?,?,?);";
		result = executeUpdate(sql, n.getNtid(), n.getNtitle(), n.getNauthor(),si.format(date), n.getNpicPath(), n.getNcontent(),
				n.getNsummary());
		return result;
	}

	public int updateNews(News n) {
		int result;
		String sql = "UPDATE NEWS SET NTID=?,NTITLE=?,NAUTHOR=?,NPICPATH=?,NCONTENT=?,NSUMMARY=? WHERE NID=?";
		result = executeUpdate(sql, n.getNtid(), n.getNtitle(), n.getNauthor(), n.getNpicPath(), n.getNcontent(),
				n.getNsummary(), n.getNid());
		return result;
	}

	public int deleteNews(int nid) {
		int result;
		String sql = "DELETE FROM NEWS WHERE NID=?";
		result = executeUpdate(sql, nid);
		return result;
	}

	public List<News> getAllnewsByTid(int tid) {
		List<News> list = new ArrayList<News>();
		ResultSet rs = null;
		String sql = "SELECT * FROM news,topic WHERE news.`ntid`"
				+ "=topic.`tid` AND news.`ntid`=? ORDER BY ncreateDate DESC";
		try {
			rs = executeQuery(sql, tid);
			News n = null;
			while (rs.next()) {
				n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtid(rs.getInt("ntid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcreateDate(rs.getTimestamp("ncreateDate"));
				n.setNsummary(rs.getString("nsummary"));
				n.setTnam(rs.getString("tnam"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}

	public List<News> getPageNewsList(int pageNo, int pageSize) {
		List<News> list = new ArrayList<News>();
		String sql = "SELECT nid,ntid,ntitle,nauthor,ncreateDate,nsummary,"
				+ "tnam FROM news,topic WHERE news.`ntid`=topic.`tid` " + "ORDER BY ncreateDate DESC LIMIT ?,?";
		try {
			rs = executeQuery(sql, (pageNo - 1) * pageSize, pageSize);
			News n = null;
			while (rs.next()) {
				n = new News();
				n.setNid(rs.getInt("nid"));
				n.setNtid(rs.getInt("ntid"));
				n.setNtitle(rs.getString("ntitle"));
				n.setNauthor(rs.getString("nauthor"));
				n.setNcreateDate(rs.getDate("ncreateDate"));
				n.setNsummary(rs.getString("nsummary"));
				n.setTnam(rs.getString("tnam"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}

	public List<News> getLatestNews(int limit) {
		List<News>list=new ArrayList<News>();
		String sql="SELECT * FROM NEWS ORDER BY NCREATEDATE DESC LIMIT ?";
		try {
			rs=executeQuery(sql, limit);
			News n=null;
			while(rs.next()){
				  n=new News();
			      n.setNid(rs.getInt("nid"));
	              n.setNtid(rs.getInt("ntid"));
	              n.setNtitle(rs.getString("ntitle"));
	              n.setNauthor(rs.getString("nauthor"));
	              n.setNcreateDate(rs.getTimestamp("ncreateDate"));
	              n.setNpicPath(rs.getString("npicPath"));
	              n.setNcontent(rs.getString("ncontent"));
	              n.setNsummary(rs.getString("nsummary"));
	              list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}

}
