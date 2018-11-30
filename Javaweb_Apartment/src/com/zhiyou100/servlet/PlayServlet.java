package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

@WebServlet("/root")
public class PlayServlet extends HttpServlet{
	
	int num = 0;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		num++;
		System.out.println("NUM:" + num);
		session.setAttribute("num",num);
		if(num >= 10) {
			session.invalidate();
			num = 0;
		}
		
		resp.sendRedirect(req.getContextPath() + "/Root.jsp");
	
	}
	
}
