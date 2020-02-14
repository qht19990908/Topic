package com.qhit.entity;

import java.util.Date;

public class Comments {
	
	private int cid;
	private int cnid;
	private String ccontent;
	private Date cdate;
	private String cip;
	private String cauthor;

	public Comments() {
		super();
	}

	public Comments(int cid, int cnid, String ccontent, Date cdate, String cip, String cauthor) {
		super();
		this.cid = cid;
		this.cnid = cnid;
		this.ccontent = ccontent;
		this.cdate = cdate;
		this.cip = cip;
		this.cauthor = cauthor;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCnid() {
		return cnid;
	}

	public void setCnid(int cnid) {
		this.cnid = cnid;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCauthor() {
		return cauthor;
	}

	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}

	
}
