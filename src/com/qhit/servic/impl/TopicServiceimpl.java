package com.qhit.servic.impl;

import java.io.DataOutput;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.qhit.core.DBHelp;
import com.qhit.dao.NewsDao;
import com.qhit.dao.TopicDao;
import com.qhit.dao.impI.NewsDaoimpl;
import com.qhit.dao.impI.TopicDaoimpl;
import com.qhit.entity.Topic;
import com.qhit.servic.TopicService;

public class TopicServiceimpl implements TopicService{
	
	private Connection conn;

	public List<Topic> findAll() {
		conn=DBHelp.getConn();
		TopicDao dao=new TopicDaoimpl(conn);
		List<Topic>list=null;
		list=dao.findAll();
		DBHelp.closeAll(null, null, conn);
		return list;
	}
	
	public Topic findTopicByName(String tnam){
		conn=DBHelp.getConn();
		TopicDao dao=new TopicDaoimpl(conn);
		Topic t=null;
		t=dao.findTopicByName(tnam);
		DBHelp.closeAll(null, null, conn);
		return t;
	}
	
	
	public Topic findTopicByTid(int tid) {
		conn=DBHelp.getConn();
		TopicDao dao=new TopicDaoimpl(conn);
		Topic t=null;
		t=dao.findTopicByTid(tid);
		DBHelp.closeAll(null, null, conn);
		return t;
	}
	
	public int insertTopic(Topic t) {
		int result;
		conn=DBHelp.getConn();
		TopicDao dao=new TopicDaoimpl(conn);
		if(dao.findTopicByName(t.getTnam())==null){
			result=dao.insertTopic(t);
		}else{
			result=-1;
		}
		DBHelp.closeAll(null, null, conn);
		return result;
	}

	public int updateTopic(Topic t) {
		int result;
		conn=DBHelp.getConn();
		TopicDao dao=new TopicDaoimpl(conn);
		if(dao.findTopicByName(t.getTnam())==null){
			result=dao.updateTopic(t);
		}else{
			result=-1;
		}
		DBHelp.closeAll(null, null, conn);
		return result;
	}

	public int deleteTopic(int tid) {
		int result;
		conn=DBHelp.getConn();
		TopicDao dao=new TopicDaoimpl(conn);
		NewsDao nd=new NewsDaoimpl(conn);
		if(nd.getNewsByTid(tid)==0){			
			result=dao.deleteTopic(tid);
		}else{
			result =-1;
		}
		DBHelp.closeAll(null, null, conn);
		return result;
	}

}
