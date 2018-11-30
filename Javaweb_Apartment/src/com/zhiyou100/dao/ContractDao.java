package com.zhiyou100.dao;

import java.util.List;

import com.zhiyou100.model.Contract;
import com.zhiyou100.util.PageUtil;

public interface ContractDao {


	List<Contract> findContractAll(PageUtil page);
	
	Contract findContractByCid(int cid);
	
	int count();

	void contractAdd(Contract contract);

	void contractUpdate(Contract contract);
}
