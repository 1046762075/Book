package com.th.dao;

import com.th.entity.Config;

public interface ConfigDao {

	 Integer update(Config config);

	 Config findById(Integer id);
}
