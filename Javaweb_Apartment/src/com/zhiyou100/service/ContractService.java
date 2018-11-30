package com.zhiyou100.service;

import java.util.List;

import com.zhiyou100.model.Contract;
import com.zhiyou100.util.PageUtil;

public interface ContractService {

	Contract contractFindByCid(int cid);
	
	List<Contract> findContractAll(PageUtil page);

	int count();

	void contractAdd(Contract contract);

	void contractUpdate(Contract contract);
}
