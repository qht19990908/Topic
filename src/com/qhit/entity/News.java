package com.qhit.entity;

import java.util.Date;
import java.util.List;

public class News {
	
	private int nid;//新闻ID
	private int ntid;//主题ID
	private String tnam;
	private String ntitle;//标题
	private String nauthor;//作者
	private Date ncreateDate;//创建时间
	private String npicPath;//图片地址
	private String ncontent;//新闻内容
	private Date nmodifyDate;//更新时间
	private String nsummary;//摘要
	
	private List<Comments>list;

	public News(int nid, int ntid, String tnam, String ntitle, String nauthor, Date ncreateDate, String npicPath,
			String ncontent, Date nmodifyDate, String nsummary, List<Comments> list) {
		super();
		this.nid = nid;
		this.ntid = ntid;
		this.tnam = tnam;
		this.ntitle = ntitle;
		this.nauthor = nauthor;
		this.ncreateDate = ncreateDate;
		this.npicPath = npicPath;
		this.ncontent = ncontent;
		this.nmodifyDate = nmodifyDate;
		this.nsummary = nsummary;
		this.list = list;
	}

	public News() {
		super();
	}

	public int getNid() {
		return nid;
	}

	public void setNid(int nid) {
		this.nid = nid;
	}

	public int getNtid() {
		return ntid;
	}

	public void setNtid(int ntid) {
		this.ntid = ntid;
	}

	public String getTnam() {
		return tnam;
	}

	public void setTnam(String tnam) {
		this.tnam = tnam;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNauthor() {
		return nauthor;
	}

	public void setNauthor(String nauthor) {
		this.nauthor = nauthor;
	}

	public Date getNcreateDate() {
		return ncreateDate;
	}

	public void setNcreateDate(Date ncreateDate) {
		this.ncreateDate = ncreateDate;
	}

	public String getNpicPath() {
		return npicPath;
	}

	public void setNpicPath(String npicPath) {
		this.npicPath = npicPath;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public Date getNmodifyDate() {
		return nmodifyDate;
	}

	public void setNmodifyDate(Date nmodifyDate) {
		this.nmodifyDate = nmodifyDate;
	}

	public String getNsummary() {
		return nsummary;
	}

	public void setNsummary(String nsummary) {
		this.nsummary = nsummary;
	}

	public List<Comments> getList() {
		return list;
	}

	public void setList(List<Comments> list) {
		this.list = list;
	}
	

}
