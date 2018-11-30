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
	
	//����ҵ������
	LoginService service = new LoginServiceImpl();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("username");
		String upassword = req.getParameter("password");
		try {
			//��ҵ�񷽷�����������
			User user = service.findUserByUsername(uname);
			HttpSession session = req.getSession();
			if(user == null) {
				session.setAttribute("error", "�û�������");
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}else if(!user.getUpassword().equals(upassword)){
				session.setAttribute("error", "���벻��ȷ");
				resp.sendRedirect(req.getContextPath() + "/index.jsp");
			}else {
				//��������Ϣ�Ž�session����ת��ҳ����ҳչʾȫ����Դ
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
		doPost(req, resp);//��ֹ���� �ڵ�ַ��get����
	}
}