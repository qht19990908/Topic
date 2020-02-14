package com.qhit.dao;

import java.sql.SQLException;
import java.util.List;

import com.qhit.entity.News;
import com.qhit.entity.PageBean;

public interface NewsDao {
    
	public PageBean findAll(int pagebean);
	
	public int getNewsByTid(int tid);
	
	public int insertNews(News n);
	
	public int updateNews(News n);
	
	public int deleteNews(int nid);
	
	public News findNewsByNid(int nid);
	
    public List<News> getPageNewsList(int pageNo, int pageSize);

    public List<News> getAllnewsByTid(int tid);
    
    public List<News> getLatestNewsByTid(int tid, int limit);
    
    public List<News> getLatestNews(int limit);
    
}
