package com.zhiyou100.servlet.rent;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Rent;
import com.zhiyou100.service.RentService;
import com.zhiyou100.service.impl.RentServiceImpl;
import com.zhiyou100.util.DSUtil;

@WebServlet("/rent/add")
public class RentAddServlet extends HttpServlet{

	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Rent rent = new Rent();
		DSUtil ds = new DSUtil();
		Date date = ds.stringToDate(req.getParameter("rpayTime"));
		
		rent.setRpayTime(date);
		rent.setRhid(Integer.parseInt(req.getParameter("rhid")));
		rent.setRlid(Integer.parseInt(req.getParameter("rlid")));	
		rent.setRprice(Double.parseDouble(req.getParameter("rprice")));
		
		RentService service = new RentServiceImpl();
		service.rentAdd(rent);
		
		req.getRequestDispatcher("/rent/list").forward(req, resp);
		
	}
	
}
