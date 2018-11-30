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

@WebServlet("/rent/edit")
public class RentEditServlet extends HttpServlet{
	
	RentService service = new RentServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Rent rent = new Rent();
		int rid = Integer.parseInt(req.getParameter("rid"));
		
		rent = service.rentFindByRid(rid);
		req.setAttribute("rent", rent);
		req.getRequestDispatcher("/view/rent/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int rid = Integer.parseInt(req.getParameter("rid"));
		System.out.println(rid);
		Rent rent = new Rent();
		DSUtil ds = new DSUtil();
		Date date = ds.stringToDate(req.getParameter("rpayTime"));
		rent.setRid(rid);
		rent.setRpayTime(date);
		rent.setRhid(Integer.parseInt(req.getParameter("rhid")));
		rent.setRlid(Integer.parseInt(req.getParameter("rlid")));	
		rent.setRprice(Double.parseDouble(req.getParameter("rprice")));
		System.out.println("1" + rent);
		service.rentUpdate(rent);
		
		req.getRequestDispatcher("/rent/list").forward(req, resp);
	
	}

}
