package com.zhiyou100.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.zhiyou100.dao.LoginDao;
import com.zhiyou100.model.User;
import com.zhiyou100.util.C3P0Util;

public class LoginDaoImpl implements LoginDao {

	//根据用户名查找用户
	
	@Override
	public User findUserByUsername(String uname) {
		Connection conn = C3P0Util.getConnection();
		String sql = "select uid,uname,upassword,urealname,uroid,uaddTime from `user` where ustatus = 1 and uname= ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			if(rs.next()){
				user = new User();
				user.setUaddTime(rs.getDate("uaddTime"));
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpassword(rs.getString("upassword"));
				user.setUrealname(rs.getString("urealname"));
				user.setUroid(rs.getInt("uroid"));
			}else{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		C3P0Util.closeAll(rs, ps, conn);
		return user;
	}

}
