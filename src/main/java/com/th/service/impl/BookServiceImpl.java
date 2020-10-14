package com.th.service.impl;

import com.th.dao.BookDao;
import com.th.entity.Book;
import com.th.service.BookService;
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
		return bookDao.add(book);
	}

	@Override
	public Integer update(Book book) {
		return bookDao.update(book);
	}

	@Override
	public List<Book> list(Map<String, Object> map) {
		return bookDao.list(map);
	}

	@Override
	public Integer getTotal(Map<String, Object> map) {
		return bookDao.getTotal(map);
	}

	@Override
	public Book findById(Integer id) {
		return bookDao.findById(id);
	}

	@Override
	public Integer delete(Integer id) {
		return bookDao.delete(id);
	}

}
