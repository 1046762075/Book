package com.th.service.impl;

import com.th.dao.UserSubDao;
import com.th.entity.UserSub;
import com.th.service.UserSubService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("userSubService")
public class UserSubServiceImpl implements UserSubService {
	
	@Resource
	private UserSubDao  userSubDao;
		
	@Override
	public Integer add(UserSub userSub) {
		return userSubDao.add(userSub);
	}

	@Override
	public Integer update(UserSub userSub) {
		return userSubDao.update(userSub);
	}

	@Override
	public List<UserSub> list(Map<String, Object> map) {
		return userSubDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return userSubDao.getTotal(map);
	}

	@Override
	public UserSub findById(Integer id) {
		return userSubDao.findById(id);
	}
	
	@Override
	public Integer delete(Integer id) {
		return userSubDao.delete(id);
	}
}
