package com.th.service;

import com.th.entity.Config;

public interface ConfigService {

	Integer update(Config config);

	Config findById(Integer id);
}
