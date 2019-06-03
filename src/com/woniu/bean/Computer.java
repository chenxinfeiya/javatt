package com.woniu.bean;

public class Computer {
	private int cid;
	private String cname;
	private String cimg;
	private Double cprice;
	
	public Computer() {
		super();
	}
	public Computer(int cid, String cname, String cimg, Double cprice) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.cimg = cimg;
		this.cprice = cprice;
	}
	@Override
	public String toString() {
		return "Computer [cid=" + cid + ", cname=" + cname + ", cimg=" + cimg + ", cprice=" + cprice + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public Double getCprice() {
		return cprice;
	}
	public void setCprice(Double cprice) {
		this.cprice = cprice;
	}
	
}
