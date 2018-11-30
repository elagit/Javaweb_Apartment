package com.zhiyou100.service;

import com.zhiyou100.model.User;

public interface LoginService {

	User findUserByUsername(String uname);
	
}
