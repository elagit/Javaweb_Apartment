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

@WebServlet("/contract/detail")
public class ContractDetailServlet extends HttpServlet{

	ContractService service = new ContractServiceImpl();
	
	Contract contract = new Contract();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cid = Integer.parseInt(req.getParameter("cid"));
		
		System.out.println(cid);
		contract = service.contractFindByCid(cid);
		
		
		//DEBUG
		System.out.println(contract);
		
		req.setAttribute("contract", contract);
		req.getRequestDispatcher("/view/contract/detail.jsp").forward(req, resp);
		
	}

}
