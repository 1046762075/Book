package com.th.controller.admin;

import com.th.service.TreeService;
import com.th.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/admin/tree")
public class AdminTreeController {

	@Resource
	private TreeService treeService;
	
	@Resource
	private UserService userService;
	
	/**
	 * /admin/tree/update
	 * ���� �û�����
	 */
	@RequestMapping("/update")
	public String update(
			@RequestParam(value="id",required=false)String id,
			@RequestParam(value="treeids",required=false)String treeids,
			HttpServletRequest requset,HttpServletResponse response)throws Exception{
		return null ;
	}
}
