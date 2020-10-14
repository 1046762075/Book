package com.th.dao;

import com.th.entity.UserSub;

import java.util.List;
import java.util.Map;

public interface UserSubDao {
	
	 Integer add(UserSub userSub);
	
	 Integer update(UserSub userSub);
	
	 List<UserSub> list(Map<String,Object> map);
	
	 Integer getTotal(Map<String,Object> map);
	
	 UserSub findById(Integer id);
	
	 Integer delete(Integer id);
}
