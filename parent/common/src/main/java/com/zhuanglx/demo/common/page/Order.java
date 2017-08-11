package com.zhuanglx.demo.common.page;
/**
 * 
 * @author zhuanglinxiang
 *
 */
public class Order {
	private String columnName;
	private boolean asc;

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public boolean isAsc() {
		return asc;
	}

	public void setAsc(boolean asc) {
		this.asc = asc;
	}

	@Override
	public String toString() {
		return "Order [columnName=" + columnName + ", asc=" + asc + "]";
	}

}
