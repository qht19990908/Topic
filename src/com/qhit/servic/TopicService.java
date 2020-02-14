package com.qhit.servic;

import java.util.List;

import com.qhit.entity.Topic;

public interface TopicService {
	public List<Topic> findAll();
	
	public Topic findTopicByTid(int tid);
	
	public Topic findTopicByName(String tnam);
	
	public int insertTopic(Topic t);
	
	public int updateTopic(Topic t);
	
	public int deleteTopic(int tid);

	
}
