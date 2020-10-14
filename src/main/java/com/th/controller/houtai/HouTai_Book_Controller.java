package com.th.controller.houtai;


import com.th.entity.Book;
import com.th.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/houtai/book")
public class HouTai_Book_Controller {
	
	@Resource
	private BookService bookService;
	
	/**
	 * /houtai/book/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/book/book_manage");
		return mav;
	}

	/**
	 * /houtai/book/add
	 */
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "Ìí¼Ó");
		mav.addObject("save_url", request.getContextPath() + "/admin/book/add");
		mav.setViewName("/admin/page/book/add_or_update");
		return mav;
	}

	/**
	 * /houtai/book/edit?id=22
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Book book = bookService.findById(Integer.parseInt(id));
		mav.addObject("book", book);
		mav.addObject("btn_text", "±à¼­");
		mav.addObject("save_url", request.getContextPath() + "/admin/book/update?id="+id);
		mav.setViewName("/admin/page/book/add_or_update");
		return mav;
	}
}