package com.th.controller.admin;

import com.th.entity.CuiHai;
import com.th.entity.PageBean;
import com.th.entity.Result;
import com.th.entity.UserSub;
import com.th.service.CuiHaiService;
import com.th.service.UserSubService;
import com.th.util.ResponseUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/cuihai")
public class Admin_CuiHai_Controller {
	
	@Resource
	private UserSubService userSubService;
	@Resource
	private CuiHaiService cuiHaiService;
	 
	/**
	 *   /admin/cuihai/add
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(value = "userSubId", required = false) String userSubId, HttpServletResponse response) throws Exception {
		UserSub userSub = userSubService.findById(Integer.parseInt(userSubId));
		CuiHai cuiHai = cuiHaiService.findBySubId(Integer.parseInt(userSubId));
		Result result = new Result();
		Gson gson = new Gson();
		
		if(cuiHai!=null){
			result.setSuccess(false);
			result.setMsg("已在催还列表");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		cuiHai = new CuiHai();
		cuiHai.setCreateDateTime(new Date());
		cuiHai.setBookId(userSub.getBookId());
		cuiHai.setUserSubId(userSub.getId());
		cuiHai.setJieyuerenId(userSub.getUserId());
		
		int resultTotal = cuiHaiService.add(cuiHai);
		
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("已添加到催还列表");
		} else {
			result.setSuccess(false);
			result.setMsg("借阅失败");
		}
		
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	
	/**
	 * /admin/cuihai/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "userId", required = false) String userId, 
			HttpServletResponse response) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("jieyuerenId", userId);
		
		List<CuiHai> list = cuiHaiService.list(map);
		Integer total = cuiHaiService.getTotal(map);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		
		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}
}
