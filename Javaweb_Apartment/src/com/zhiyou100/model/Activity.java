package com.zhiyou100.model;

import java.util.Date;

public class Activity {
	private int aid;
	private Date atime;
	private String asubject;
	private String aintr;
	private String aaddress;
	private double aprice;
	@Override
	public String toString() {
		return "Activity [aid=" + aid + ", atime=" + atime + ", asubject=" + asubject + ", aintr=" + aintr
				+ ", aaddress=" + aaddress + ", aprice=" + aprice + "]";
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Date getAtime() {
		return atime;
	}
	public void setAtime(Date atime) {
		this.atime = atime;
	}
	public String getAsubject() {
		return asubject;
	}
	public void setAsubject(String asubject) {
		this.asubject = asubject;
	}
	public String getAintr() {
		return aintr;
	}
	public void setAintr(String aintr) {
		this.aintr = aintr;
	}
	public String getAaddress() {
		return aaddress;
	}
	public void setAaddress(String aaddress) {
		this.aaddress = aaddress;
	}
	public double getAprice() {
		return aprice;
	}
	public void setAprice(double aprice) {
		this.aprice = aprice;
	}
}
