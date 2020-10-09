package com.firenay.controller.houtai;

import com.firenay.entity.Message;
import com.firenay.service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/houtai/message")
public class HouTai_Message_Controller {
	
	@Resource
	private MessageService messageService;
	
	/**
	 * /houtai/message/manage
	 */
	@RequestMapping("/manage")
	public ModelAndView manage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/message/message_manage");
		return mav;
	}

	/**
	 * /houtai/message/my
	 */
	@RequestMapping("/my")
	public ModelAndView my() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/admin/page/message/my_message_manage");
		return mav;
	}

	/**
	 * /houtai/message/add
	 */
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("btn_text", "Ìí¼Ó");
		mav.addObject("save_url", request.getContextPath() + "/admin/message/add");
		mav.setViewName("/admin/page/message/add_or_update");
		return mav;
	}
	
	
	/**
	 * /houtai/message/edit?id=22
	 */
	@RequestMapping("/edit")
	public ModelAndView edit(@RequestParam(value="id",required=false)String id,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Message message = messageService.findById(Integer.parseInt(id));
		mav.addObject("message", message);
		mav.addObject("btn_text", "ÐÞ¸Ä");
		mav.addObject("save_url", request.getContextPath() + "/admin/message/update?id="+id);
		mav.setViewName("/admin/page/message/add_or_update");
		return mav;
	}
}
