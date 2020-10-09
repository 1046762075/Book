package com.firenay.service.impl;

import com.firenay.dao.CuiHaiDao;
import com.firenay.entity.CuiHai;
import com.firenay.service.CuiHaiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@Service("cuiHaiService")
public class CuiHaiServiceImpl implements CuiHaiService {
	

	@Resource
	private CuiHaiDao  cuiHaiDao;
	
	@Override
	public Integer add(CuiHai cuihai) {
		// TODO Auto-generated method stub
		return cuiHaiDao.add(cuihai);
	}

	@Override
	public Integer update(CuiHai cuihai) {
		// TODO Auto-generated method stub
		return cuiHaiDao.update(cuihai);
	}

	@Override
	public List<CuiHai> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cuiHaiDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return cuiHaiDao.getTotal(map);
	}

	@Override
	public CuiHai findById(Integer id) {
		// TODO Auto-generated method stub
		return cuiHaiDao.findById(id);
	}
	
	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return cuiHaiDao.delete(id);
	}
	
	@Override
	public CuiHai findBySubId(Integer subId) {
		// TODO Auto-generated method stub
		return cuiHaiDao.findBySubId(subId);
	}
	
	@Override
	public Integer deleteBySubId(Integer subId) {
		// TODO Auto-generated method stub
		return cuiHaiDao.deleteBySubId(subId);
	}
}
