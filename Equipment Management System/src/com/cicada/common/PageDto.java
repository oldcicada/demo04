package com.cicada.common;

import java.util.List;

public class PageDto<T> {
	/**
	 * 用于向前端传递数据。
	 */
	private int pageIndex;//当前页下标
	private int pageSize;//每页容量
	private int pageTotal;//总页数
	private int count;//总记录数
	private List<T> list;//每页数据
	
	
	public void setList(List<T> list) {
		this.list = list;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public List<T> getList() {
		return list;
	}
}
