package com.dgd.lottery.util;

import java.io.Serializable;

/**
 * 分页对象
 * 对前台传入的数据进行封装
 * @author liushan
 * @version 2016-07-07
 *
 */
public class Page implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//请求的页码
	private Integer pageNum;
	//每页显示数
	private Integer pageSize;
	//排序字段
	private String sort;
	//排序方式
	private String order;

	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		if(pageNum != null && pageNum > 0) {
			this.pageNum = pageNum;
		}else {
			this.pageNum = 1;
		}
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		if(pageSize != null && pageSize > 0) {
			this.pageSize = pageSize;
		}else {
			pageSize = 20;
		}
	}


	public String getSort() {
		return sort;
	}


	public void setSort(String sort) {
		this.sort = sort;
	}


	public String getOrder() {
		return order;
	}


	public void setOrder(String order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", sort=" + sort + ", order=" + order + "]";
	}

}
