package com.zhiyou100.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	//通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
    //从连接池中取用一个连接
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
            
        } catch (Exception e) {
            System.out.println("数据库连接出错!");         
            return null;
        }
    }    
    //释放连接回连接池
     public static void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){  
            if(rs!=null){  
                try {  
                    rs.close();  
                } catch (SQLException e) {  
                	System.out.println("数据库释放资源 "+rs+" 出错!");         
                }  
            }  
            if(ps!=null){  
                try {  
                    ps.close();  
                } catch (SQLException e) {  
                	System.out.println("数据库释放资源 "+ps+" 出错!");         
                }  
            }  
      
            if(conn!=null){  
                try {  
                    conn.close();  
                } catch (SQLException e) {  
                	System.out.println("数据库释放资源 "+conn+" 出错!");         
                }  
            }  
        }  
}
