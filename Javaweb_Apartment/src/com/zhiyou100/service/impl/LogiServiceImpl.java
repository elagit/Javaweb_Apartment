package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.HouseDao;
import com.zhiyou100.dao.LogiDao;
import com.zhiyou100.dao.impl.HouseDaoImpl;
import com.zhiyou100.dao.impl.LogiDaoImpl;
import com.zhiyou100.model.House;
import com.zhiyou100.model.Logi;
import com.zhiyou100.service.LogiService;
import com.zhiyou100.util.PageUtil;

public class LogiServiceImpl implements LogiService {

	//����Dao�����
		LogiDao dao = new LogiDaoImpl();
		
		@Override
		public List<Logi> findAll(PageUtil page,String searchContent) {
			//���÷���
			List<Logi> logis = dao.findAll(page,searchContent);
		
			return logis;
		}
		
		@Override
		public Logi findLogiDetailAll(int loid) {
			Logi logi = dao.findLogiDetailAll(loid);
			
			return logi;
		}

		@Override
		public void updateLogi(Logi logi) {
			dao.updateLogi(logi);
		}

		@Override
		public void insertLogi(Logi logi) {
			dao.insertLogi(logi);
		}

		@Override
		public int count() {
			int total = dao.count();
			return total;
		}

}
