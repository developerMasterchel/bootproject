/**
 * 文件名    ： PageMyInfo.java
 * 版权       : XX科技有限公司。
 * 描述       : <描述>
 * 修改时间：2016年11月6日
 * 修改内容：<修改内容>
 */
package com.commons.page;

import java.io.Serializable;

public class Page implements Serializable{

	/**   */
	private static final long serialVersionUID = 1972586782191277586L;
	/** 每页显示多少条   */
	private int pageSize =10;  
	/** 当前是第几页   */
	private int index = 0;
	/** 共有多少页   */
    private int totlePage;  
    /** 总共的数据量   */
    private int totle;  
	/**
	 * @return the totle
	 */
	public int getTotle() {
		return totle;
	}
	/**
	 * @param totle the totle to set
	 */
	public void setTotle(int totle) {
		this.totle = totle;
	}
	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}
	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 10;
		}
		this.pageSize = pageSize;
	}
	/**
	 * @return the totlePage
	 */
	public int getTotlePage() {
		return totlePage;
	}
	/**
	 * @param totlePage the totlePage to set
	 */
	public void setTotlePage(int totlePage) {
		this.totlePage = totlePage;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
