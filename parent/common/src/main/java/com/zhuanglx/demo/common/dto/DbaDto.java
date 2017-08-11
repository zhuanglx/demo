package com.zhuanglx.demo.common.dto;

public class DbaDto {
	private Integer id;
	private String xxx;
	private String yyy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getXxx() {
		return xxx;
	}

	public void setXxx(String xxx) {
		this.xxx = xxx;
	}

	public String getYyy() {
		return yyy;
	}

	public void setYyy(String yyy) {
		this.yyy = yyy;
	}

	@Override
	public String toString() {
		return "Dba [id=" + id + ", xxx=" + xxx + ", yyy=" + yyy + "]";
	}

}
