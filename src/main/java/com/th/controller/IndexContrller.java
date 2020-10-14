package com.th.controller;

import com.th.service.PublicService;
import com.th.util.MyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class IndexContrller {

	private Logger log = LoggerFactory.getLogger(IndexContrller.class);

	@Resource
	private PublicService publicService;
	
	/**
	 * /wap/laws/index
	 */
	@RequestMapping({"/index","/index.html"})
	public ModelAndView index(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		String UserAgent = req.getHeader("User-Agent");
		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/login/login");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		
		String UserAgent = req.getHeader("User-Agent");

		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/login/login");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}
	
	@RequestMapping("/reg")
	public ModelAndView reg(HttpServletResponse  res,HttpServletRequest req){
		ModelAndView mav = new ModelAndView();
		
		String UserAgent = req.getHeader("User-Agent");

		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/pc/reg/reg");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}
	
	@RequestMapping("/admin/main")
	public ModelAndView admin_main(HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		publicService.addLeftMenu(mav);

		log.info("\nµÇÂ½ÕßIP: " + MyUtil.getRemoteAddress(req));
		String UserAgent = req.getHeader("User-Agent");
		if(MyUtil.checkUserAgent(UserAgent)){
			mav.setViewName("/admin/main");
		}else{
			mav.setViewName("/admin/common/s_mode");
		}
		return mav;
	}
}
