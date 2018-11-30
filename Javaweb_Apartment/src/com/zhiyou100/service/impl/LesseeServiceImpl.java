package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.LesseeDao;
import com.zhiyou100.dao.impl.LesseeDaoImpl;
import com.zhiyou100.model.Lessee;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.util.PageUtil;

public class LesseeServiceImpl implements LesseeService{

	//创建数据层对象
	LesseeDao dao = new LesseeDaoImpl();
	
	
	@Override
	public List<Lessee> lesseeFindAll(PageUtil page) {
		
		List<Lessee> lessees= dao.findLesseeAll(page);
		
		
		return lessees;
	}


	@Override
	public int count() {
		int total = dao.count();
		return total;
		
	}


	@Override
	public Lessee lesseeFindByLid(int lid) {
		
		Lessee lessee = dao.lesseeFindByLid(lid);
		return lessee;
	}


	@Override
	public void lesseeAdd(Lessee lessee) {
		dao.lesseeAdd(lessee);
	}


	@Override
	public void lesseeUpdate(Lessee lessee) {
		dao.lesseeUpdate(lessee);
	}


}
