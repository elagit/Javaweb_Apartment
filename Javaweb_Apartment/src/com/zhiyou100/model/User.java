package com.zhiyou100.model;

import java.util.Date;

public class User {
	private int uid;
	private String uname;
	private String upassword;
	private String urealname;
	private int uroid;
	private Date uaddTime;
	private int ustatus;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
	public String getUrealname() {
		return urealname;
	}
	public void setUrealname(String urealname) {
		this.urealname = urealname;
	}
	public Date getUaddTime() {
		return uaddTime;
	}
	public void setUaddTime(Date uaddTime) {
		this.uaddTime = uaddTime;
	}
	public int getUstatus() {
		return ustatus;
	}
	public void setUstatus(int ustatus) {
		this.ustatus = ustatus;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getUroid() {
		return uroid;
	}
	public void setUroid(int uroid) {
		this.uroid = uroid;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upassword=" + upassword + ", urealname=" + urealname
				+ ", uroid=" + uroid + ", uaddTime=" + uaddTime + ", ustatus=" + ustatus + "]";
	}
	
	
}
