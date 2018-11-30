package com.zhiyou100.servlet.logi;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Logi;
import com.zhiyou100.service.LogiService;
import com.zhiyou100.service.impl.LogiServiceImpl;

@WebServlet("/logi/add")
public class LogiAddServlet extends HttpServlet{

	
	LogiService service = new LogiServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Logi logi = new Logi();
		Date date = new Date();
		logi.setLoid(Integer.parseInt(req.getParameter("loid")));
		logi.setLoname(req.getParameter("loname"));
		logi.setLoidCard(req.getParameter("loidCard"));
		logi.setLotel(req.getParameter("lotel"));
		logi.setLosex(Integer.parseInt(req.getParameter("losex")));
		logi.setLosalary(Double.parseDouble(req.getParameter("losalary")));
	    logi.setLoaddTime(date);
        service.insertLogi(logi);
        
        req.getRequestDispatcher("/house/list").forward(req, resp);
	}

	
	
}
