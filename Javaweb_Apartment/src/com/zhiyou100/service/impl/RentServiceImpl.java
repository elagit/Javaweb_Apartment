package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.RentDao;
import com.zhiyou100.dao.impl.RentDaoImpl;
import com.zhiyou100.model.Rent;
import com.zhiyou100.service.RentService;
import com.zhiyou100.util.PageUtil;

public class RentServiceImpl implements RentService {

	RentDao dao = new RentDaoImpl();
	
	@Override
	public List<Rent> rentFindAll(PageUtil page) {
		
		List<Rent> rents = dao.rentFindAll(page);
		
		return rents;
	}


	@Override
	public int count() {
		int total = dao.count();
		
		return total;
	}


	@Override
	public Rent rentFindByRid(int rid) {
		Rent rent = dao.rentFindByRid(rid);
		
		return rent;
	}


	@Override
	public void rentAdd(Rent rent) {
		dao.rentAdd(rent);
	}


	@Override
	public void rentUpdate(Rent rent) {
		dao.rentUpdate(rent);
		
	}

}
