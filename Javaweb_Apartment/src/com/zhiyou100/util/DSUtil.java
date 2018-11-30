package com.zhiyou100.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DSUtil {
	public Date stringToDate(String str) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	public String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		String str = sdf.format(date);
		
		return str;
		
	}
	
	
	
}
