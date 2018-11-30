package com.zhiyou100.model;

import java.util.Date;

public class Contract {
	private int cid;
	private String cnum;
	private int chid;
	private int clid;
	private Date ctime;
	private Date cstartTime;
	private Date cendTime;
	private Double ctotalMoney;
	private int cpayType;
	@Override
	public String toString() {
		return "Contract [cid=" + cid + ", cnum=" + cnum + ", chid=" + chid + ", clid=" + clid + ", ctime=" + ctime
				+ ", cstartTime=" + cstartTime + ", cendTime=" + cendTime + ", ctotalMoney=" + ctotalMoney
				+ ", cpayType=" + cpayType + "]";
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public int getChid() {
		return chid;
	}
	public void setChid(int chid) {
		this.chid = chid;
	}
	public int getClid() {
		return clid;
	}
	public void setClid(int clid) {
		this.clid = clid;
	}
	public Date getCtime() {
		return ctime;
	}
	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	public Date getCstartTime() {
		return cstartTime;
	}
	public void setCstartTime(Date cstartTime) {
		this.cstartTime = cstartTime;
	}
	public Date getCendTime() {
		return cendTime;
	}
	public void setCendTime(Date cendTime) {
		this.cendTime = cendTime;
	}
	public Double getCtotalMoney() {
		return ctotalMoney;
	}
	public void setCtotalMoney(Double ctotalMoney) {
		this.ctotalMoney = ctotalMoney;
	}
	public int getCpayType() {
		return cpayType;
	}
	public void setCpayType(int cpayType) {
		this.cpayType = cpayType;
	}
	
}
