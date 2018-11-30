package com.zhiyou100.servlet.lessee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.House;
import com.zhiyou100.model.Lessee;
import com.zhiyou100.service.LesseeService;
import com.zhiyou100.service.impl.LesseeServiceImpl;
import com.zhiyou100.util.PageUtil;
@WebServlet("/lessee/list")
public class LesseeListServlet extends HttpServlet{
	
		//创建业务层对象
		LesseeService service = new LesseeServiceImpl();
		List<Lessee> lessees = new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int total = service.count();
		String pageNo = req.getParameter("pageNo");
		if(pageNo == null) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		
		
		PageUtil page = new PageUtil(pageNow, total);
		
		//调用业务层方法
		lessees = service.lesseeFindAll(page);
		
		req.setAttribute("page", page);
		req.setAttribute("lessees", lessees);
		req.getRequestDispatcher("/view/lessee/list.jsp").forward(req, resp);;
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	
	}
	
	
	
	
}
