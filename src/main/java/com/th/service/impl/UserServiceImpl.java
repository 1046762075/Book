package com.th.service.impl;

import com.th.dao.UserDao;
import com.th.entity.User;
import com.th.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao  userDao;

	public Integer add(User user) {
		return userDao.add(user);
	}

	public Integer update(User user) {
		return userDao.update(user);
	}

	public List<User> list(Map<String, Object> map) {
		return userDao.list(map);
	}

	public Integer getTotal(Map<String, Object> map) {
		return userDao.getTotal(map);
	}

	 
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	public Integer delete(Integer id) {
		return userDao.delete(id);
	}

	@Override
	public User findByNum(String num) {
		return userDao.findByNum(num);
	}
}
