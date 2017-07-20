package com.dgd.lottery.util;

import java.util.List;

/**
 * 分页封装类
 * @author liushan
 * @version 2016-07-07
 */
public class Pagenation {

	//当前页码
	private int pageNum;
	//记录总数
	private Long totalCount;
	//每页显示多少条记录
	private int pageSize;
	//总页数
	private int pageTotal;
	//分页容器
	@SuppressWarnings("rawtypes")
	private List list;
	//该页从第几条开始
	private int startRowNum;
	//该页在第几条结束
	private int endRowNum;
	//第一页
	private int first = 1;
	//前一页
	private int previous;
	//后一页
	private int next;
	//最后一页
	private int last;
	//显示页码的第一页
	private int navStartNum;
	//显示页码的最后一页
	private int navEndNum;
	//共显示几页
	private int navPageSize = 10;
	public Pagenation() {
	}
	public Pagenation(String pageNumStr, Long totalCount, Integer pageSize) {
		this.totalCount = totalCount;
		if(pageSize == null) {
			//设置每页默认显示15条数据
			this.pageSize = 15;
		}else {
			this.pageSize = pageSize.intValue();
		}
		
		//Math.ceil(double d)表示向上取舍，即25/4=6.25 取值为7
		this.pageTotal = (int) (Math.ceil(this.totalCount / this.pageSize));
		this.pageNum = (pageNumStr == null) ? 1 : Integer.parseInt(pageNumStr);
		//Math.Max(x,...)表示取最大值
		this.pageNum = Math.max(this.pageNum, 1);
		//this.pageNum = Math.min(this.pageNum, this.pageTotal);
		this.startRowNum = (this.pageNum - 1) * this.pageSize + 1;
		this.endRowNum = this.startRowNum + this.pageSize - 1 ;
		this.previous = (this.pageNum == 1) ? 1 : (this.pageNum - 1);
		this.next = (this.pageNum == this.pageTotal) ? this.pageTotal : (this.pageNum + 1);
		this.last = this.pageTotal;
		/*不懂*/
		this.navStartNum = (this.pageNum - this.navPageSize / 2 <= 0 ? 1 : this.pageNum - this.navPageSize / 2 + 1);
        this.navEndNum = Math.min(this.navStartNum + this.navPageSize - 1, this.last);
        if (this.navEndNum - this.navStartNum < this.navPageSize - 1) {
            this.navStartNum = Math.max(this.navEndNum - this.navPageSize + 1, 1);
        }
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public Long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
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
	@SuppressWarnings("rawtypes")
	public List getList() {
		return list;
	}
	@SuppressWarnings("rawtypes")
	public void setList(List list) {
		this.list = list;
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum(int startRowNum) {
		this.startRowNum = startRowNum;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum(int endRowNum) {
		this.endRowNum = endRowNum;
	}
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public int getPrevious() {
		return previous;
	}
	public void setPrevious(int previous) {
		this.previous = previous;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	public int getNavStartNum() {
		return navStartNum;
	}
	public void setNavStartNum(int navStartNum) {
		this.navStartNum = navStartNum;
	}
	public int getNavEndNum() {
		return navEndNum;
	}
	public void setNavEndNum(int navEndNum) {
		this.navEndNum = navEndNum;
	}
	public int getNavPageSize() {
		return navPageSize;
	}
	public void setNavPageSize(int navPageSize) {
		this.navPageSize = navPageSize;
	}
}
