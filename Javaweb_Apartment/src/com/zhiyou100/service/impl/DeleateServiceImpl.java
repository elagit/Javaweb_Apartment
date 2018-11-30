package com.zhiyou100.service.impl;

import com.zhiyou100.dao.DeleateDao;
import com.zhiyou100.dao.impl.DeleateDaoImpl;
import com.zhiyou100.service.DeleateService;

public class DeleateServiceImpl implements DeleateService {

	DeleateDao dao = new DeleateDaoImpl();
	
	@Override
	public void deleate(int caseNo, int id) {
		dao.deleate(caseNo, id);
	}

}
