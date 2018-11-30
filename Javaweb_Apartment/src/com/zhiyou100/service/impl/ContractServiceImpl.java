package com.zhiyou100.service.impl;

import java.util.List;

import com.zhiyou100.dao.ContractDao;
import com.zhiyou100.dao.impl.ContractDaoImpl;
import com.zhiyou100.model.Contract;
import com.zhiyou100.service.ContractService;
import com.zhiyou100.util.PageUtil;

public class ContractServiceImpl implements ContractService {

	Contract contract = new Contract();
	ContractDao dao = new ContractDaoImpl();
	
	
	@Override
	public Contract contractFindByCid(int cid) {
		
		contract = dao.findContractByCid(cid);
		
		
		return contract;
	}

	@Override
	public List<Contract> findContractAll(PageUtil page) {
		
		List<Contract> contracts= dao.findContractAll(page);		
		
		return contracts;
	}

	@Override
	public int count() {
		int total = dao.count();
		
		return total;
	}

	@Override
	public void contractAdd(Contract contract) {
		dao.contractAdd(contract);
	}

	@Override
	public void contractUpdate(Contract contract) {
		dao.contractUpdate(contract);
	}
}
