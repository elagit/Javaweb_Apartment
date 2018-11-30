package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou100.model.User;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{
	//a标签点击   走的时get请求
	User user = null;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		user = (User)session.getAttribute("user");
		if(user != null) {
			session.invalidate();
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}else {
			resp.sendRedirect(req.getContextPath() + "/index.jsp");
		}
	}
}
