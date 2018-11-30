package com.zhiyou100.model;

import java.util.Date;

public class Rent {
	private int rid;
	private int rhid;
	private int rlid;
	private double rprice;
	private Date rpayTime;
	@Override
	public String toString() {
		return "Rent [rid=" + rid + ", rhid=" + rhid + ", rlid=" + rlid + ", rprice=" + rprice + ", rpayTime="
				+ rpayTime + "]";
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public int getRhid() {
		return rhid;
	}
	public void setRhid(int rhid) {
		this.rhid = rhid;
	}
	public int getRlid() {
		return rlid;
	}
	public void setRlid(int rlid) {
		this.rlid = rlid;
	}
	public double getRprice() {
		return rprice;
	}
	public void setRprice(double rprice) {
		this.rprice = rprice;
	}
	public Date getRpayTime() {
		return rpayTime;
	}
	public void setRpayTime(Date rpayTime) {
		this.rpayTime = rpayTime;
	}
}
