package com.th.service;

import com.th.entity.Message;

import java.util.List;
import java.util.Map;

public interface MessageService {

	 Integer  add(Message  msg);

	 Integer  update(Message  msg);

	 List<Message> list(Map<String,Object> map);

	 Integer getTotal(Map<String,Object> map);

	 Integer delete(Integer id);

	 Message findById(Integer id);
}
