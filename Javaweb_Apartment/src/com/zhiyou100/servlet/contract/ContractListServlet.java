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

	//����ҵ������
	ContractService service = new ContractServiceImpl();
	
	List<Contract> contracts = new ArrayList<>();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//��ҳ
		//��ȡ������
		int total = service.count();
		//��ȡ��ǰҳ
		String pageNo = req.getParameter("pageNo");
		
		if(pageNo == null) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		
		//���÷�ҳ���ߣ�pageUtil
		PageUtil page = new PageUtil(pageNow, total);
		
		//����ҵ��㷽��
		contracts = service.findContractAll(page);
		
		req.setAttribute("page", page);
		req.setAttribute("contracts", contracts);
		req.getRequestDispatcher("/view/contract/list.jsp").forward(req, resp);;
		
	}

}
