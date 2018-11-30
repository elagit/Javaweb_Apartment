package com.zhiyou100.dao;

import com.zhiyou100.model.User;

public interface LoginDao {
	
	User findUserByUsername(String uname);
}
