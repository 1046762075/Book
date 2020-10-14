package com.th.service.impl;

import com.th.dao.TreeDao;
import com.th.entity.Tree;
import com.th.service.TreeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("treeService")
public class TreeServiceImpl implements TreeService {

	@Resource
	private TreeDao  treeDao;

	public Tree findById(Integer id) {
		return treeDao.findById(id);
	}
	
	public List<Tree> getTreesByFatherOrIds(Map<String, Object> map) {
		return treeDao.getTreesByFatherOrIds(map);
	}
}
