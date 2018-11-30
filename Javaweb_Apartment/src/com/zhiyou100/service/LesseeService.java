package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Lessee;
import com.zhiyou100.util.PageUtil;

public interface LesseeService {

	List<Lessee> lesseeFindAll(PageUtil page);

	int count();

	Lessee lesseeFindByLid(int lid);

	void lesseeAdd(Lessee lessee);

	void lesseeUpdate(Lessee lessee);

}
