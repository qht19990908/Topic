package com.qhit.dao.impI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qhit.core.DBHelp;
import com.qhit.dao.BaseDao;
import com.qhit.dao.TopicDao;
import com.qhit.entity.Topic;

public class TopicDaoimpl extends BaseDao implements TopicDao{
	
	private PreparedStatement ps=null;
	private ResultSet rs=null;

	public TopicDaoimpl(Connection conn) {
		super(conn);
	}
	public List<Topic> findAll(){
		List<Topic>list=new ArrayList<Topic>();
		try {
			String sql="SELECT * FROM TOPIC";
			rs=executeQuery(sql);
			while(rs.next()){
				Topic t=new Topic();
				t.setTid(rs.getInt("tid"));
				t.setTnam(rs.getString("tnam"));
				list.add(t);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			DBHelp.closeAll(rs, null, null);
		}
		return list;
	}
	
	public Topic findTopicByTid(int tid){
		String sql="SELECT * FROM TOPIC WHERE TID=?";
		Topic t=null;
		try {
			rs=executeQuery(sql, tid);
			while(rs.next()){
				t=new Topic();
				t.setTid(rs.getInt("tid"));
				t.setTnam(rs.getString("tnam"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelp.closeAll(rs, null, null);
		}
		return t;
	}
	
	public Topic findTopicByName(String tnam) {
		String sql="SELECT * FROM TOPIC WHERE TNAM=?";
		Topic t=null;
		try {
			rs=executeQuery(sql, tnam);
			while(rs.next()){
				t=new Topic();
				t.setTid(rs.getInt("tid"));
				t.setTnam(rs.getString("tnam"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBHelp.closeAll(rs, null, null);
		}
		return t;
	}
	
	public int insertTopic(Topic t){
		int result;
		String sql="INSERT INTO TOPIC(tnam) VALUES(?)";
		result=executeUpdate(sql,t.getTnam());
		return result;
	}
	public int updateTopic(Topic t){
		int result;
		String sql="UPDATE TOPIC SET TNAM=? WHERE TID=?";
		result=executeUpdate(sql, t.getTnam(),t.getTid());
		return result;
	}
	public int deleteTopic(int tid){
		int result;
		String sql="DELETE FROM TOPIC WHERE TID=?";
		result=executeUpdate(sql, tid);
		return result;
	}
	
	public static void main(String[] args) {
		Connection conn=null;
		conn=DBHelp.getConn();
		TopicDaoimpl td=new TopicDaoimpl(conn);
		List<Topic>list=td.findAll();
		for(Topic t : list){
			System.out.println("新闻ID：" + t.getTid() + ",新闻名称是" + t.getTnam());
		}
	}	

}
