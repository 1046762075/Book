package com.firenay.service;


import com.firenay.entity.UserSub;

import java.util.List;
import java.util.Map;


public interface UserSubService {
	
	
	 Integer add(UserSub userSub);
	
	 Integer update(UserSub userSub);
	
	 List<UserSub> list(Map<String,Object> map);
	
	 Integer getTotal(Map<String,Object> map);
	
	 UserSub findById(Integer id);
	
	 Integer delete(Integer id);
	
	
}
