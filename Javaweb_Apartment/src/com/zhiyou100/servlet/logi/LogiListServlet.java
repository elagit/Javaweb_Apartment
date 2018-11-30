package com.zhiyou100.servlet.logi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.Logi;
import com.zhiyou100.service.LogiService;
import com.zhiyou100.service.impl.LogiServiceImpl;
import com.zhiyou100.util.PageUtil;

@WebServlet("/logi/list")
public class LogiListServlet extends HttpServlet{
	
	LogiService service = new LogiServiceImpl();
	List<Logi> logis = new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//admin里 还有一个 a标签  要调过来
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String searchContent = req.getParameter("searchContent");
		
		//调用业务层方法
		int total = service.count();
		// 获取当前页
		String pageNo = req.getParameter("pageNo");
		if(pageNo == null ) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		//利用分页工具 pageUtil
		PageUtil page = new PageUtil(pageNow, total);
				
		//调用业务层方法
		logis = service.findAll(page,searchContent);
		//将数据放进请求域
		req.setAttribute("page", page);
		req.setAttribute("houses", logis);
		req.getRequestDispatcher("/view/logi/list.jsp").forward(req, resp);
	}
	
}
