package com.th.controller.houtai;


import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.th.entity.User;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/houtai/user/sub")
public class HouTai_User_Sub_Controller {
	
	/**
	 * /houtai/user/sub/manage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "isUser", required = false) String isUser, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table_url", request.getContextPath() + "/admin/user/sub/list");
		mav.setViewName("/admin/page/user_sub/user_sub_manage");
		return mav;
	}

	
	/**
	 * /houtai/user/sub/my
	 * �ҵĽ��� ��¼
	 */
	@RequestMapping("/my")
	public ModelAndView my(@RequestParam(value = "isUser", required = false) String isUser, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("table_url", request.getContextPath() + "/admin/user/sub/list?userId="+user.getId());
		mav.setViewName("/admin/page/user_sub/my_sub_manage");
		return mav;
	}
}
