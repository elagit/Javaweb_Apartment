package com.zhiyou100.service.impl;

import com.zhiyou100.dao.LoginDao;
import com.zhiyou100.dao.impl.LoginDaoImpl;
import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	//�������ݷ��ʲ����
	LoginDao dao = new LoginDaoImpl();

	@Override
	public User findUserByUsername(String uname) {
		User user = dao.findUserByUsername(uname);
		return user;
	}
	
	
}
