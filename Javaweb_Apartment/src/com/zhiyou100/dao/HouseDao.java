package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.House;
import com.zhiyou100.util.PageUtil;

public interface HouseDao {

	List<House> findAll(PageUtil page, String searchContent, String filed);
	
	House findHouseDetailAll(int hid);

	void updateHouse(House house);

	void insertHouse(House house);

	int count(String searchContent, String filed);

}
