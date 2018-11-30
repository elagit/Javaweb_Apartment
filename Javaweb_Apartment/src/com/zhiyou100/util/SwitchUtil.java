package com.zhiyou100.util;

import java.sql.SQLClientInfoException;

public class SwitchUtil {
	
	public String deleateSqlSwitch(int caseNo){
		String sql = "";
		switch (caseNo) {
		case 1:
			sql = "UPDATE house set hstatus = 0 WHERE hid = ?";
			break;
		case 2:
			sql = "UPDATE lessee set lstatus = 0 WHERE lid = ?";
			break;
		case 3:
			sql = "UPDATE rent set rstatus = 0 WHERE rid = ?";
			break;
		case 4:
			sql = "UPDATE contract set cstatus = 0 WHERE cid = ?";
			break;
		default:
			break;
		}
		return sql;
	}
	public String urlSwitch(int caseNo) {
		String url = "";
		switch (caseNo) {
		case 1:
			url = "/house/list";
			break;
		case 2:
			url = "/lessee/list";
			break;
		case 3:
			url = "/rent/list";
			break;
		case 4:
			url = "/contract/list";
			break;
		default:
			break;
		}
		return url;
	}
	
	
}
