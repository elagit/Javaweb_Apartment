package com.zhiyou100.servlet.house;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.House;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.impl.HouseServiceImpl;

@WebServlet("/house/detail")
public class HouseDetailServlet extends HttpServlet{

	
	HouseService service = new HouseServiceImpl();
	House house = new House();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hid = Integer.parseInt(req.getParameter("hid"));
		house = service.findHouseDetailAll(hid);
		req.setAttribute("house",house);
		req.getRequestDispatcher("/view/house/detail.jsp").forward(req, resp);
	}
	
}
