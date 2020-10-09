package com.firenay.controller.houtai;


import com.firenay.entity.User;
import com.firenay.service.PublicService;
import com.firenay.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/houtai/user")
public class HouTai_User_Controller {
	
	@Resource
	private UserService  userService;
	@Resource
	private PublicService  publicService;

	/**
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pageTitle", "�û�����");
		mav.addObject("title", "�û�����");
		mav.setViewName("/admin/page/user/user_manage");
		return mav;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		
		User user = userService.findById(Integer.parseInt(id));
		
		mav.addObject("user", user);
		mav.addObject("btn_text", "�޸�");
		mav.addObject("save_url", request.getContextPath() + "/admin/user/update?id="+id);
		
		mav.setViewName("/admin/page/user/add_or_update");
		return mav;
	}
	
	@RequestMapping("/setPersm")
	public ModelAndView setPersm(@RequestParam(value = "id", required = false) String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.setViewName("admin/page/user/set_persm");
		return mav;
	}
	
	@RequestMapping("/setPassword")
	public ModelAndView setPassword(@RequestParam(value = "id", required = false) String id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("userId", id);
		mav.addObject("save_url", request.getContextPath() + "/admin/user/update?id="+id);
		mav.setViewName("admin/page/user/set_password");
		return mav;
	}
}


