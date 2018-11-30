package com.zhiyou100.servlet.contract;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Contract;
import com.zhiyou100.service.ContractService;
import com.zhiyou100.service.impl.ContractServiceImpl;

@WebServlet("/contract/edit")
public class ContractEditServlet extends HttpServlet{
	
	int cid;
	Contract contract = new Contract();
	ContractService service = new ContractServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		cid = Integer.parseInt(req.getParameter("cid"));
		
		contract = service.contractFindByCid(cid);
		req.setAttribute("contract", contract);
		req.getRequestDispatcher("/view/contract/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		contract.setCid(cid);
		contract.setChid(Integer.parseInt(req.getParameter("chid")));
		contract.setClid(Integer.parseInt(req.getParameter("clid")));
		contract.setCnum(req.getParameter("cnum"));
		contract.setCpayType(Integer.parseInt(req.getParameter("cpayType")));
		contract.setCtotalMoney(Double.parseDouble(req.getParameter("ctotalMoney")));
		
		service.contractUpdate(contract);
		
		req.getRequestDispatcher("/contract/list").forward(req, resp);
	}

}
