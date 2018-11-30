package com.zhiyou100.servlet.house;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;

import com.zhiyou100.model.House;
import com.zhiyou100.service.HouseService;
import com.zhiyou100.service.impl.HouseServiceImpl;
import com.zhiyou100.util.PageUtil;

@WebServlet("/house/list")
public class HouseListServlet extends HttpServlet{
	
	HouseService service = new HouseServiceImpl();
	List<House> houses = new ArrayList<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//admin里 还有一个 a标签  要调过来
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchContent = req.getParameter("searchContent");
		String filed = req.getParameter("filed");
	
		req.setAttribute("searchContent", searchContent);		
		req.setAttribute("filed", filed);	
				
		if(searchContent == null) {
			searchContent = "";
			filed = "";
		}
		
		//调用业务层方法
		int total = service.count(searchContent,filed);
		// 获取当前页
		String pageNo = req.getParameter("pageNo");
		if(pageNo == null ) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		//利用分页工具 pageUtil
		PageUtil page = new PageUtil(pageNow, total);
				
		//调用业务层方法
		houses = service.findAll(page,searchContent,filed);
		//将数据放进请求域
		
		req.setAttribute("page", page);
		req.setAttribute("houses", houses);
		req.getRequestDispatcher("/view/house/list.jsp").forward(req, resp);
	}
	
}
