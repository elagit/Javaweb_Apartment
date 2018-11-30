package com.zhiyou100.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/apartment";
	private static final String username = "root";
	private static final String password = "root";
	private static Connection conn;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("���������쳣");
		}
	}
	
	// ������Ӷ���
	public static Connection getConnection(){
		try {
			conn = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���Connection�����쳣");
		}
		
		return conn;
	}
	// ��ȫ��������
	public static void closeAll(ResultSet rs,Statement statement,Connection conn){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(statement != null){
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
