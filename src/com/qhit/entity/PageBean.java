package com.qhit.entity;

import java.util.ArrayList;
import java.util.List;

public class PageBean {

	// 总页数
	private int totalPageCount = 0;
	// 页面大小，即每页显示记录数
	private int pageSize = 25;
	// 记录总数
	private int totalCount;
	// 当前页码
	private int currPageNo = 1;
	// 每页新闻集合
	private List<News> newsList;

	public int getCurrPageNo() { // 当前页码
		if (totalPageCount == 0) {
			return 0;
		}else if(currPageNo>totalPageCount){
			return totalPageCount;
		}else if(currPageNo<=0){
			return 1;
		}
		return currPageNo;
	}

	public void setCurrPageNo(int currPageNo) {
		if (currPageNo > 0)
			this.currPageNo = currPageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) { // 页面大小，即每页显示记录数
		if (pageSize > 0)
			this.pageSize = pageSize;
	}

	public int getTotalCount() {// 总页数
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			// 计算总页数
			totalPageCount = this.totalCount % pageSize == 0 ? (this.totalCount / pageSize)
					: (this.totalCount / pageSize + 1);
		}
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = (int) Math.ceil((double) totalCount / (double) pageSize);
	}

	public List<News> getNewsList() {
		return newsList;
	}

	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}
}
