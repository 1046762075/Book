package com.firenay.service;

import com.firenay.entity.Config;

public interface ConfigService {

	Integer update(Config config);

	Config findById(Integer id);
	
}
