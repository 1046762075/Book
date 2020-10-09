package com.firenay.service.impl;

import com.firenay.dao.ConfigDao;
import com.firenay.entity.Config;
import com.firenay.service.ConfigService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;
import javax.servlet.ServletContext;


@Service("configService")
public class ConfigServiceImpl implements ConfigService {
	
	@Resource
	private ConfigDao configDao;
	
	public Integer update(Config config) {
		int i =  configDao.update(config);
		config = configDao.findById(1);
		//Ë¢ÐÂ»º´æ
		WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();  
        ServletContext servletContext = webApplicationContext.getServletContext();
		config.setHeadStr(config.getHeadStr().replace("src=\"","src=\"" + servletContext.getContextPath()));
		config.setHeadStr(config.getHeadStr().replace("href=\"","href=\"" + servletContext.getContextPath()));
		config.setLayuiStr(config.getLayuiStr().replace("href=\"","href=\"" + servletContext.getContextPath()));
		config.setLayuiStr(config.getLayuiStr().replace("src=\"","src=\"" + servletContext.getContextPath()));
        servletContext.setAttribute("config", config);
		return i ;
	}
	
	public Config findById(Integer id) {
		// TODO Auto-generated method stub
		return configDao.findById(id);
	}
}
