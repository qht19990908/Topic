package com.qhit.entity;

public class Topic {
	private int tid;
	private String tnam;
	public Topic(int tid, String tnam) {
		super();
		this.tid = tid;
		this.tnam = tnam;
	}
	public Topic() {
		super();
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTnam() {
		return tnam;
	}
	public void setTnam(String tnam) {
		this.tnam = tnam;
	}
	
	

}
