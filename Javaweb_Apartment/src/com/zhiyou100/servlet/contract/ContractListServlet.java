package com.zhiyou100.servlet.contract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Contract;
import com.zhiyou100.service.ContractService;
import com.zhiyou100.service.impl.ContractServiceImpl;
import com.zhiyou100.util.PageUtil;

@WebServlet("/contract/list")
public class ContractListServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		doGet(req, resp);
	}

	//创建业务层对象
	ContractService service = new ContractServiceImpl();
	
	List<Contract> contracts = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//分页
		//获取总条数
		int total = service.count();
		//获取当前页
		String pageNo = req.getParameter("pageNo");
		
		if(pageNo == null) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		
		//利用分页工具，pageUtil
		PageUtil page = new PageUtil(pageNow, total);
		
		//调用业务层方法
		contracts = service.findContractAll(page);
		
		req.setAttribute("page", page);
		req.setAttribute("contracts", contracts);
		req.getRequestDispatcher("/view/contract/list.jsp").forward(req, resp);;
		
	}

}
