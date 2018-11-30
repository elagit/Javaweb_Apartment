package com.zhiyou100.servlet.house;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.House;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.impl.HouseServiceImpl;

@WebServlet("/house/add")
public class HouseAddServlet extends HttpServlet{

	
	HouseService service = new HouseServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		House house = new House();
		Date date = new Date();
		house.setHaddress(req.getParameter("haddress"));
	    house.setHair(Integer.parseInt(req.getParameter("hair")));
	    house.setHarea(req.getParameter("harea"));
	    house.setHdeco(Integer.parseInt(req.getParameter("hdeco")));
	    house.setHdir(req.getParameter("hdir"));
	    house.setHfloor(req.getParameter("hfloor"));
	    house.setHprice(Double.parseDouble(req.getParameter("hprice")));
	    house.setHrentStatus(Integer.parseInt(req.getParameter("hrentStatus")));
	    house.setHroomNum(Integer.parseInt(req.getParameter("hroomNum")));
	    house.setHupdateTime(date);
	    house.setHaddTime(date);
        service.insertHouse(house);
        
        req.getRequestDispatcher("/house/list").forward(req, resp);
	}

	
	
}
