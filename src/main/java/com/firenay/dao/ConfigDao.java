package com.firenay.dao;

import com.firenay.entity.Config;

public interface ConfigDao {

	 Integer update(Config config);

	 Config findById(Integer id);

}
