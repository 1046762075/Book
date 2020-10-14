package com.th.quartz;


import com.th.service.ConfigService;
import com.th.service.PublicService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Task {
	
	@Resource
	private PublicService publicService;
	@Resource
	private ConfigService configService;
}
