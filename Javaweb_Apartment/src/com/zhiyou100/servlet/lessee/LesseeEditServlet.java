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

@WebServlet("/lessee/edit")
public class LesseeEditServlet extends HttpServlet{

	Lessee lessee  = new Lessee();
	LesseeService service = new LesseeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int lid = Integer.parseInt(req.getParameter("lid"));
		lessee = service.lesseeFindByLid(lid);
		lessee.setLid(lid);
		req.setAttribute("lessee", lessee);
		req.getRequestDispatcher("/view/lessee/edit.jsp").forward(req, resp);;
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int lid = Integer.parseInt(req.getParameter("lid"));
		DSUtil ds = new DSUtil();
		Date laddTime = ds.stringToDate(req.getParameter("laddTime"));
		
		lessee.setLaddTime(laddTime);
		lessee.setLid(lid);
		lessee.setLidCard(req.getParameter("lidCard"));
		lessee.setLname(req.getParameter("lname"));
		lessee.setLnp(req.getParameter("lnp"));
		lessee.setLsex(Integer.parseInt(req.getParameter("lsex")));
		lessee.setLtel(req.getParameter("ltel"));
		service.lesseeUpdate(lessee);
		req.getRequestDispatcher("/lessee/list").forward(req, resp);
	
	
	}
	
}
