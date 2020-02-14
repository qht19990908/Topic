package com.qhit.servic;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.qhit.entity.News;
import com.qhit.entity.PageBean;

public interface NewsService {

	public PageBean findAll(int pagebean);
	
	public List<News> findAllNewsByTid(int tid);
	
	public int insertNews(News n);
	
	public int updateNews(News n);
	
	public int deleteNews(int nid);

	public int getNewsByTid(int tid);
	
	public News findNewsByNid(int nid);
    
	public List<News> getLatestNews(int limit);
    
}
