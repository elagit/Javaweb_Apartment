package com.zhiyou100.servlet.lessee;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Lessee;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.service.impl.LesseeServiceImpl;
import com.zhiyou100.util.DSUtil;

@WebServlet("/lessee/add")
public class LesseeAddServlet extends HttpServlet{
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Lessee lessee = new Lessee();
		LesseeService service = new LesseeServiceImpl();
		DSUtil ds = new DSUtil();
		Date laddTime = ds.stringToDate(req.getParameter("laddTime"));
		
		lessee.setLaddTime(laddTime);
		lessee.setLidCard(req.getParameter("lidCard"));
		lessee.setLname(req.getParameter("lname"));
		lessee.setLnp(req.getParameter("lnp"));
		lessee.setLsex(Integer.parseInt(req.getParameter("lsex")));
		lessee.setLtel(req.getParameter("ltel"));
		
		service.lesseeAdd(lessee);
		
		req.getRequestDispatcher("/lessee/list").forward(req, resp);
		
	
	}

}
