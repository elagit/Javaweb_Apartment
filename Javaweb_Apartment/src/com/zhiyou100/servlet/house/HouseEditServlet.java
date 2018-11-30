package com.zhiyou100.servlet.house;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.House;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.impl.HouseServiceImpl;

@WebServlet("/house/edit")
public class HouseEditServlet extends HttpServlet{
	
	HouseService service = new HouseServiceImpl();
	House house = new House();
	Timestamp dateNow=new Timestamp(System.currentTimeMillis());
	int hid = 0;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		hid = Integer.parseInt(req.getParameter("hid"));
		house = service.findHouseDetailAll(hid);
		req.setAttribute("house",house);
		req.getRequestDispatcher("/view/house/edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		house.setHid(hid);
		house.setHaddress(req.getParameter("haddress"));
	    house.setHair(Integer.parseInt(req.getParameter("hair")));
	    house.setHarea(req.getParameter("harea"));
	    house.setHdeco(Integer.parseInt(req.getParameter("hdeco")));
	    house.setHdir(req.getParameter("hdir"));
	    house.setHfloor(req.getParameter("hfloor"));
	    house.setHprice(Double.parseDouble(req.getParameter("hprice")));
	    house.setHrentStatus(Integer.parseInt(req.getParameter("hrentStatus")));
	    house.setHroomNum(Integer.parseInt(req.getParameter("hroomNum")));
	    Date date = new Date();
	    house.setHupdateTime(date);
        service.updateHouse(house);
        
        req.getRequestDispatcher("/house/list").forward(req, resp);
        
	}
	
	
	
}
