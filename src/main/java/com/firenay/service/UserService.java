package com.firenay.service;

import com.firenay.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	 Integer add(User user);

	 Integer update(User user);

	 List<User> list(Map<String, Object > map);

	 Integer getTotal(Map<String, Object > map);

	 User findByNum(String num);

	 User findById(Integer id);

	 Integer delete(Integer id);
}
