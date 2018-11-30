package com.zhiyou100.servlet.rent;

import java.io.IOException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Rent;
import com.zhiyou100.service.RentService;
import com.zhiyou100.service.impl.RentServiceImpl;
import com.zhiyou100.util.PageUtil;


@WebServlet("/rent/list")
public class RentListServlet extends HttpServlet{

	//创建业务层对象
	RentService service = new RentServiceImpl();
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}




	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		int total = service.count();
		
		String pageNo = req.getParameter("pageNo");
		if(pageNo == null) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		
		PageUtil page = new PageUtil(pageNow,total);
		
		
		
		List<Rent> rents = service.rentFindAll(page);
		req.setAttribute("page", page);
		req.setAttribute("rents", rents);
		req.getRequestDispatcher("/view/rent/list.jsp").forward(req, resp);
	}
	
}
