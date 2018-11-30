package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Logi;
import com.zhiyou100.util.PageUtil;

public interface LogiDao {

	List<Logi> findAll(PageUtil page, String searchContent);

	Logi findLogiDetailAll(int loid);

	void updateLogi(Logi logi);

	void insertLogi(Logi logi);

	int count();

}
