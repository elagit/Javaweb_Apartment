package com.zhiyou100.servlet.rent;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Rent;
import com.zhiyou100.service.RentService;
import com.zhiyou100.service.impl.RentServiceImpl;

@WebServlet("/rent/detail")
public class RentDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		RentService service = new RentServiceImpl();
		
		int rid = Integer.parseInt(req.getParameter("rid"));
		
		Rent rent = service.rentFindByRid(rid);
		
		req.setAttribute("rent", rent);
		req.getRequestDispatcher("/view/rent/detail.jsp").forward(req, resp);
	
	}

}
