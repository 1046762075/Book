package com.firenay.service.impl;

import com.firenay.dao.TreeDao;
import com.firenay.entity.Tree;
import com.firenay.service.TreeService;
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
		// TODO Auto-generated method stub
		return treeDao.getTreesByFatherOrIds(map);
	}
 
}
