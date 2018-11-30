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
		//admin�� ����һ�� a��ǩ  Ҫ������
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String searchContent = req.getParameter("searchContent");
		
		//����ҵ��㷽��
		int total = service.count();
		// ��ȡ��ǰҳ
		String pageNo = req.getParameter("pageNo");
		if(pageNo == null ) {
			pageNo = "1";
		}
		int pageNow = Integer.parseInt(pageNo);
		//���÷�ҳ���� pageUtil
		PageUtil page = new PageUtil(pageNow, total);
				
		//����ҵ��㷽��
		logis = service.findAll(page,searchContent);
		//�����ݷŽ�������
		req.setAttribute("page", page);
		req.setAttribute("houses", logis);
		req.getRequestDispatcher("/view/logi/list.jsp").forward(req, resp);
	}
	
}
