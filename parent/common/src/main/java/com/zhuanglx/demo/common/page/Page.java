package com.zhuanglx.demo.common.page;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zhuanglinxiang
 * page
 * @param <T>
 */
public class Page<T1,T2> {
	private int pageSize = 20;
	private long pageNo = 1;
	private int resultSize = 0;
	private long pageTotal = 0;
	private long resultTotal = 0;
	private long startIndex = 0;
	private T1 query;
	private List<Order> orderBy = new ArrayList<Order>();
	private List<T2> result = new ArrayList<T2>();

	public Page() {
	}

	public Page(Page<T1,T2> page, List<T2> result, int PageNo) {
		super();
		setPageSize(page.getPageSize());
		setPageNo(PageNo);
		setPageTotal(page.getPageTotal());
		setResult(result);
	}

	public Page(Page<T1,T2> page, T1 query, List<T2> result, int PageNo) {
		super();
		setPageSize(page.getPageSize());
		setPageNo(PageNo);
		setPageTotal(page.getPageTotal());
		setResult(result);
	}
	
	public Page(int pageSize) {
		super();
		setPageSize(pageSize);
	}

	public Page(int pageSize, int pageNo) {
		super();
		setPageSize(pageSize);
		setPageNo(pageNo);
	}

	public Page(int pageNo, T1 query) {
		super();
		setPageNo(pageNo);
		setResult(result);

	}

	public Page(int pageNo, List<T2> result) {
		super();
		setPageNo(pageNo);
		setResult(result);

	}

	public Page(int pageNo, T1 query, List<T2> result) {
		super();
		setPageNo(pageNo);
		setResult(result);

	}
	
	public Page(int pageSize, int pageNo, int pageTotal) {
		super();
		setPageSize(pageSize);
		setPageNo(pageNo);
		setPageTotal(pageTotal);
	}

	public Page(int pageSize, int pageNo, int pageTotal, List<T2> result) {
		super();
		setPageSize(pageSize);
		setPageNo(pageNo);
		setPageTotal(pageTotal);
		setResult(result);
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 0) {
			pageSize = 0;
		}
		this.pageSize = pageSize;
	}

	public long getStartIndex() {
		this.startIndex = (this.pageNo - 1) * this.pageSize;
		return startIndex;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {

		if (pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}

		this.startIndex = (this.pageNo - 1) * this.pageSize;
	}

	public int getResultSize() {

		return resultSize;
	}

	/**
	 * 
	 * @param resultTotal
	 *            当页结果数
	 */
	public void setResultSize(int resultSize) {
		if (resultSize < 0) {
			resultSize = 0;
		}
		this.resultSize = resultSize;
	}

	public long getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(long pageTotal) {
		this.pageTotal = pageTotal;
	}

	public List<T2> getResult() {
		return result;
	}

	public long getResultTotal() {
		return resultTotal;
	}

	/**
	 * 
	 * @param resultTotal
	 *            总结果数
	 */
	public void setResultTotal(long resultTotal) {
		this.resultTotal = resultTotal;
		this.pageTotal = this.resultTotal / this.pageSize;
		if (this.resultTotal % this.pageSize > 0) {
			this.pageTotal = this.pageTotal + 1;
		}
		if (this.pageTotal < this.pageNo) {
			setPageNo(this.pageTotal);
		}
	}

	public void setResult(List<T2> result) {
		if (result == null) {
			setResultSize(0);
			this.result = new ArrayList<T2>();
		} else {
			setResultSize(result.size());
		}

		this.result = result;
	}

	public List<Order> getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(List<Order> orderBy) {
		this.orderBy = orderBy;
	}

	public T1 getQuery() {
		return query;
	}

	public void setQuery(T1 query) {
		this.query = query;
	}

	public void setStartIndex(long startIndex) {
		this.startIndex = startIndex;
	}

	@Override
	public String toString() {
		return "Page [pageSize=" + pageSize + ", pageNo=" + pageNo
				+ ", resultSize=" + resultSize + ", pageTotal=" + pageTotal
				+ ", resultTotal=" + resultTotal + ", startIndex=" + startIndex
				+ ", query=" + query + ", orderBy=" + orderBy + ", result="
				+ result + "]";
	}

}
