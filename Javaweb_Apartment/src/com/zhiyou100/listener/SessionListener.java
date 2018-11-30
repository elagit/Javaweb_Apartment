package com.zhiyou100.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
    
	public SessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("session已创建sessionId：" + se.getSession().getId());
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("session已销毁sessionId：" + se.getSession().getId());
    }
	
}
