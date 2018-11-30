package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.HouseDao;
import com.zhiyou100.dao.impl.HouseDaoImpl;
import com.zhiyou100.model.House;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.util.PageUtil;

public class HouseServiceImpl implements HouseService {
	//创建Dao层对象
	HouseDao dao = new HouseDaoImpl();
	
	@Override
	public List<House> findAll(PageUtil page,String searchContent,String filed) {
		//调用方法
		List<House> houses = dao.findAll(page,searchContent,filed);
	
		return houses;
	}
	
	@Override
	public House findHouseDetailAll(int hid) {
		House house = dao.findHouseDetailAll(hid);
		
		return house;
	}

	@Override
	public void updateHouse(House house) {
		dao.updateHouse(house);
	}

	@Override
	public void insertHouse(House house) {
		dao.insertHouse(house);
	}

	@Override
	public int count(String searchContent,String filed) {
		int total = dao.count(searchContent,filed);
		return total;
	}


}
