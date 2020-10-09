package com.firenay.service.impl;

import com.firenay.dao.BookDao;
import com.firenay.entity.Book;
import com.firenay.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("bookService")
public class BookServiceImpl implements BookService {

	@Resource
	private BookDao  bookDao;
	
	
	@Override
	public Integer add(Book book) {
		// TODO Auto-generated method stub
		return bookDao.add(book);
	}

	@Override
	public Integer update(Book book) {
		// TODO Auto-generated method stub
		return bookDao.update(book);
	}

	@Override
	public List<Book> list(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.getTotal(map);
	}

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		// TODO Auto-generated method stub
		return bookDao.delete(id);
	}

}
