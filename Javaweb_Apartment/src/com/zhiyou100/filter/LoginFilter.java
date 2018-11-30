package com.zhiyou100.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

@WebFilter(urlPatterns={"/house/*","/contract/*","/lessee/*","/rent/*","/deleate","*.jsp"})
public class LoginFilter implements Filter{

	public static Logger logger = Logger.getLogger(LoginFilter.class);
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String requestURI = req.getRequestURI();
		
		if("/Javaweb_Apartment/index.jsp".equals(requestURI) || "/Javaweb_Apartment/".equals(requestURI)) {
			logger.debug("��ת��¼����");
			chain.doFilter(req, resp);
			return;
		}else if(session.getAttribute("user") != null && session.getAttribute("roid").equals(1) && "/ZyApartment/deleate".equals(requestURI)) {
			logger.debug("ɾ������");
			chain.doFilter(req, resp);
			return;
		}else if(session.getAttribute("user") != null && !"/Javaweb_Apartment/deleate".equals(requestURI)) {
			logger.debug("��������������ҳ");
			chain.doFilter(req, resp);
			return;
		}else if(session.getAttribute("user") != null && "/Javaweb_Apartment/deleate".equals(requestURI) && !session.getAttribute("roid").equals(1)) {
			resp.sendRedirect(req.getContextPath()+"/Root.jsp");
			logger.debug("�Բ�����û��Ȩ��ɾ��");
		}else {
			logger.debug(session.getAttribute("roid"));
			logger.debug("û�е�¼");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	
}
