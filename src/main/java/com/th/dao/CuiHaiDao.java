package com.th.dao;

import com.th.entity.CuiHai;

import java.util.List;
import java.util.Map;


public interface CuiHaiDao {
	
	 Integer add(CuiHai cuihai);
	
	 Integer update(CuiHai cuihai);
	
	 List<CuiHai> list(Map<String,Object> map);
	
	  Integer getTotal(Map<String,Object> map);
	
	 CuiHai findById(Integer id);
	
	 Integer delete(Integer id);
	
	 CuiHai findBySubId(Integer subId);
	
	 Integer deleteBySubId(Integer subId);
}
