package com.firenay.quartz;


import com.firenay.service.ConfigService;
import com.firenay.service.PublicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Task {
	
	@Resource
	private PublicService publicService;
	@Resource
	private ConfigService configService;
}
