package com.th.service.impl;

import com.th.dao.CuiHaiDao;
import com.th.entity.CuiHai;
import com.th.service.CuiHaiService;
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
		return cuiHaiDao.add(cuihai);
	}

	@Override
	public Integer update(CuiHai cuihai) {
		return cuiHaiDao.update(cuihai);
	}

	@Override
	public List<CuiHai> list(Map<String, Object> map) {
		return cuiHaiDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return cuiHaiDao.getTotal(map);
	}

	@Override
	public CuiHai findById(Integer id) {
		return cuiHaiDao.findById(id);
	}
	
	@Override
	public Integer delete(Integer id) {
		return cuiHaiDao.delete(id);
	}
	
	@Override
	public CuiHai findBySubId(Integer subId) {
		return cuiHaiDao.findBySubId(subId);
	}
	
	@Override
	public Integer deleteBySubId(Integer subId) {
		return cuiHaiDao.deleteBySubId(subId);
	}
}
