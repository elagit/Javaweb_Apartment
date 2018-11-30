package com.zhiyou100.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;
import com.zhiyou100.service.impl.LoginServiceImpl;


	
@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	//创建业务层对象
	LoginService service = new LoginServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String upassword = req.getParameter("password");
		try {
			//调业务方法，传递数据
			User user = service.findUserByUsername(uname);
			HttpSession session = req.getSession();
			if(user == null) {
				session.setAttribute("error", "用户不存在");
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}else if(!user.getUpassword().equals(upassword)){
				session.setAttribute("error", "密码不正确");
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}else {
				//将对象信息放进session域，跳转首页，首页展示全部房源
				session.setAttribute("roid", user.getUroid());
				session.setAttribute("user",user);
				req.getRequestDispatcher("/WEB-INF/admin.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);//防止贼人 在地址栏get请求
	}
}
