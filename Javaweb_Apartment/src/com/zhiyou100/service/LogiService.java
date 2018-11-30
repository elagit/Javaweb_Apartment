package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Logi;
import com.zhiyou100.util.PageUtil;

public interface LogiService {

	int count();

	List<Logi> findAll(PageUtil page, String searchContent);

	Logi findLogiDetailAll(int loid);

	void updateLogi(Logi logi);

	void insertLogi(Logi logi);


}
