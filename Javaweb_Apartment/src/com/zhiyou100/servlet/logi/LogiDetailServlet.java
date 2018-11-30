package com.zhiyou100.servlet.logi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.House;
import com.zhiyou100.model.Logi;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.LogiService;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.service.impl.LogiServiceImpl;

@WebServlet("/logi/detail")
public class LogiDetailServlet extends HttpServlet{

	
	LogiService service = new LogiServiceImpl();
	Logi logi = new Logi();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int loid = Integer.parseInt(req.getParameter("loid"));
		logi = service.findLogiDetailAll(loid);
		req.setAttribute("logi",logi);
		req.getRequestDispatcher("/view/logi/detail.jsp").forward(req, resp);
	}
	
}
