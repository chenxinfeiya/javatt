package com.woniu.bean;

public class Page {
	private Integer pageNum;
	private Integer pageRow;
	private Integer countNum;
	private Integer countRow;
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getPageRow() {
		return pageRow;
	}
	public void setPageRow(Integer pageRow) {
		this.pageRow = pageRow;
	}
	public Integer getCountNum() {
		return countNum;
	}
	public void setCountNum(Integer countNum) {
		this.countNum = countNum;
	}
	public Integer getCountRow() {
		return countRow;
	}
	public void setCountRow(Integer countRow) {
		this.countRow = countRow;
	}
	public User(Integer pageNum, Integer pageRow, Integer countNum, Integer countRow) {
		super();
		this.pageNum = pageNum;
		this.pageRow = pageRow;
		this.countNum = countNum;
		this.countRow = countRow;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [pageNum=" + pageNum + ", pageRow=" + pageRow + ", countNum=" + countNum + ", countRow=" + countRow
				+ "]";
	}
   
}
