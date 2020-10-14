package com.th.controller.houtai;

import com.th.entity.Config;
import com.th.service.ConfigService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/houtai/config")
public class HouTai_Config_Controller {
	
	@Resource
	private ConfigService configService;
	
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/config/config_manage");
		return mav;
	}
	
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value = "id", required = false) String id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Config config     = configService.findById(Integer.parseInt(id));
		mav.addObject("config", config);
		mav.addObject("btn_text", "ÐÞ¸Ä");
		mav.addObject("save_url", request.getContextPath() + "/admin/config/update?id=" + id);
		mav.setViewName("/admin/page/config/add_or_update");
		return mav;
	}
}
