package com.zhiyou100.servlet.logi;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Logi;
import com.zhiyou100.service.LogiService;
import com.zhiyou100.service.impl.LogiServiceImpl;

@WebServlet("/logi/edit")
public class LogiEditServlet extends HttpServlet{
	
	LogiService service = new LogiServiceImpl();
	Logi logi = new Logi();
	Timestamp dateNow=new Timestamp(System.currentTimeMillis());
	int loid = 0;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		loid = Integer.parseInt(req.getParameter("loid"));
		logi = service.findLogiDetailAll(loid);
		req.setAttribute("logi",logi);
		req.getRequestDispatcher("/view/logi/edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logi.setLoid(Integer.parseInt(req.getParameter("loid")));
		logi.setLoname(req.getParameter("loname"));
		logi.setLoidCard(req.getParameter("loidCard"));
		logi.setLotel(req.getParameter("lotel"));
		logi.setLosex(Integer.parseInt(req.getParameter("losex")));
		logi.setLosalary(Double.parseDouble(req.getParameter("losalary")));
	    Date date = new Date();
	    logi.setLoaddTime(date);
        service.updateLogi(logi);
        
        req.getRequestDispatcher("/logi/list").forward(req, resp);
        
	}
	
	
	
}
