package com.th.dao;

import com.th.entity.Book;

import java.util.List;
import java.util.Map;


public interface BookDao {
	
	 Integer add(Book book);
	
	 Integer update(Book book);
	
	 List<Book> list(Map<String,Object> map);
	
	 Integer getTotal(Map<String,Object> map);
	
	 Book findById(Integer id);
	
	 Integer delete(Integer id);
}
