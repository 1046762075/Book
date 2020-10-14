package com.th.service.impl;

import com.th.dao.MessageDao;
import com.th.entity.Message;
import com.th.service.MessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("messageService")
public class MessageServiceImpl implements MessageService {
	
	@Resource
	private MessageDao  messageDao;
	
	@Override
	public Integer add(Message msg) {
		return messageDao.add(msg);
	}

	@Override
	public Integer update(Message msg) {
		return messageDao.update(msg);
	}

	@Override
	public List<Message> list(Map<String, Object> map) {
		return messageDao.list(map);
	}
	
	@Override
	public Integer getTotal(Map<String, Object> map) {
		return messageDao.getTotal(map);
	}
	
	@Override
	public Integer delete(Integer id) {
		return messageDao.delete(id);
	}

	@Override
	public Message findById(Integer id) {
		return messageDao.findById(id);
	}

}
