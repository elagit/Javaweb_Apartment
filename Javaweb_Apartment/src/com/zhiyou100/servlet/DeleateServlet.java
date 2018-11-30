package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.dao.DeleateDao;
import com.zhiyou100.service.DeleateService;
import com.zhiyou100.service.impl.DeleateServiceImpl;
import com.zhiyou100.util.SwitchUtil;

@WebServlet("/deleate")
public class DeleateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int caseNo = Integer.parseInt(req.getParameter("caseNo"));
		int id = Integer.parseInt(req.getParameter("id"));
		
		DeleateService service = new DeleateServiceImpl();
		
		service.deleate(caseNo,id);
		
		SwitchUtil su = new SwitchUtil();
		
		req.getRequestDispatcher(su.urlSwitch(caseNo)).forward(req, resp);;
	}

}
