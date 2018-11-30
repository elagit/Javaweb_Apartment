package com.zhiyou100.servlet.contract;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Contract;
import com.zhiyou100.service.ContractService;
import com.zhiyou100.service.impl.ContractServiceImpl;
import com.zhiyou100.util.DSUtil;

@WebServlet("/contract/add")
public class ContractAddServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Contract contract = new Contract();
		DSUtil ds = new DSUtil();
		Date cendTime = ds.stringToDate(req.getParameter("cendTime"));
		Date ctime = ds.stringToDate(req.getParameter("ctime"));
		Date cstartTime = ds.stringToDate(req.getParameter("cstartTime"));
		
		contract.setCendTime(cendTime);
		contract.setCstartTime(cstartTime);
		contract.setCtime(ctime);
		
		contract.setChid(Integer.parseInt(req.getParameter("chid")));
		contract.setClid(Integer.parseInt(req.getParameter("clid")));
		contract.setCnum(req.getParameter("cnum"));
		contract.setCpayType(Integer.parseInt(req.getParameter("cpayType")));
		contract.setCtotalMoney(Double.parseDouble(req.getParameter("ctotalMoney")));
		
		
		ContractService service = new ContractServiceImpl();
		
		service.contractAdd(contract);
		
		req.getRequestDispatcher("/contract/list").forward(req, resp);;
		
	}
	
	
	
	
	
}
