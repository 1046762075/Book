package com.th.controller.houtai;

import com.th.entity.User;
import com.th.service.CuiHaiService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/houtai/cuihai")
public class HouTai_CuiHai_Controller {
	
	@Resource
	private CuiHaiService cuiHaiService;

	/**
	 * /houtai/cuihai/manage
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/manage")
	public ModelAndView manage(@RequestParam(value = "isUser", required = false) String isUser, HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("table_url", request.getContextPath() + "/admin/cuihai/list");
		mav.setViewName("/admin/page/cuihai/cuihai_manage");
		return mav;
	}
	
	
	/**
	 * /houtai/cuihai/my
	 */
	@RequestMapping("/my")
	public ModelAndView my(@RequestParam(value = "isUser", required = false) String isUser, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		mav.addObject("table_url", request.getContextPath() + "/admin/cuihai/list?userId="+user.getId());
		mav.setViewName("/admin/page/cuihai/my_cuihai_manage");
		return mav;
	}
}
