package com.th.controller.houtai;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/houtai/book/sub")
public class HouTai_Book_Sub_Controller {
	
	/**
	 * /houtai/book/sub/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/book_sub/book_sub_manage");
		return mav;
	}
}
