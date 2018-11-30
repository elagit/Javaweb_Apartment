package com.zhiyou100.servlet.lessee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Lessee;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.service.impl.LesseeServiceImpl;

@WebServlet("/lessee/detail")
public class LesseeDetailServlet extends HttpServlet{
	
	
	LesseeService service = new LesseeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int lid = Integer.parseInt(req.getParameter("lid")) ;
		
		Lessee lessee = service.lesseeFindByLid(lid);
		
		
		System.out.println(lessee.getLidCard());
		req.setAttribute("lessee", lessee);
		req.getRequestDispatcher("/view/lessee/detail.jsp").forward(req, resp);
	
	}

}
