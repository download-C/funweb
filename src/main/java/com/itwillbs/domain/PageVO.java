package com.itwillbs.domain;

public class PageVO {
	
	private String pageNum;
	private int pageSize;
	private int pageBlock;
	private int CurrentPage;
	private int startPage;
	private int endPage;
	private int pageCount;
	private int startRow;
	private int endRow;
	
	// 검색어
	private String search;

	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getPageNum() {
		return pageNum;
	}
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getCurrentPage() {
		return CurrentPage;
	}
	public void setCurrentPage(int currentPage) {
		CurrentPage = currentPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	@Override
	public String toString() {
		return "PageVO [pageNum=" + pageNum + ", pageSize=" + pageSize + ", pageBlock=" + pageBlock + ", CurrentPage="
				+ CurrentPage + ", startPage=" + startPage + ", endPage=" + endPage + ", pageCount=" + pageCount
				+ ", startRow=" + startRow + ", endRow=" + endRow + "]";
	}
	
}
