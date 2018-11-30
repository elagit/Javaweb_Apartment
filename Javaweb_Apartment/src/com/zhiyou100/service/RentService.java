package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Rent;
import com.zhiyou100.util.PageUtil;

public interface RentService {

	List<Rent> rentFindAll(PageUtil page);

	int count();

	Rent rentFindByRid(int rid);

	void rentAdd(Rent rent);

	void rentUpdate(Rent rent);

}
