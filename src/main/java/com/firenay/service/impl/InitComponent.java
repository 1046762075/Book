package com.firenay.service.impl;


import com.firenay.entity.Config;
import com.firenay.service.ConfigService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class InitComponent implements ServletContextListener, ApplicationContextAware{
	
	private static ApplicationContext applicationContext;

	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application=sce.getServletContext();
		ConfigService configService = (ConfigService) applicationContext.getBean("configService");

		//把config  初始到全局缓存中
		Config config = configService.findById(1);
		config.setHeadStr(config.getHeadStr().replace("src=\"","src=\"" + applicationContext.getApplicationName()));
		config.setHeadStr(config.getHeadStr().replace("href=\"","href=\"" + applicationContext.getApplicationName()));
		config.setLayuiStr(config.getLayuiStr().replace("href=\"","href=\"" + applicationContext.getApplicationName()));
		config.setLayuiStr(config.getLayuiStr().replace("src=\"","src=\"" + applicationContext.getApplicationName()));
		//保存到 缓存中
		application.setAttribute("config", config);
	}
	
	public void contextDestroyed(ServletContextEvent sce) {
	}
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}
}
