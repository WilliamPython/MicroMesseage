package com.imooc.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.imooc.db.DBAccess;
@WebListener("this is My Servlet 3.0 Listener")
public class MyServlet3ContextListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed.....");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized...配置文件已加载.."+DBAccess.getDBAccess());
	}

}
