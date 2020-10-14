package com.th.controller.admin;

import com.th.entity.Book;
import com.th.entity.PageBean;
import com.th.entity.Result;
import com.th.entity.User;
import com.th.entity.UserSub;
import com.th.service.BookService;
import com.th.service.CuiHaiService;
import com.th.service.UserSubService;
import com.th.util.ResponseUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/user/sub")
public class Admin_User_Sub__Controller {
	
	@Resource
	private UserSubService userSubService;
	@Resource
	private BookService  bookService;
	@Resource
	private CuiHaiService  cuiHaiService;
	
	/**
	 * /admin/user/sub/add
	 */
	@RequestMapping("/add")
	public String add(@RequestParam(value = "bookId", required = false) String bookId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		Book book = bookService.findById(Integer.parseInt(bookId));
		Result result = new Result();
		Gson gson = new Gson();
		
		if(book.getKucun()==0){
			result.setSuccess(false);
			result.setMsg("�����治��,�޷�����");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		User currentUser =	(User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		UserSub sub = new UserSub();
		sub.setBookId(book.getId());
		sub.setSubDateTime(new Date());
		sub.setUserId(currentUser.getId());
		sub.setType(1);
		
		int resultTotal = userSubService.add(sub);
		
		if (resultTotal > 0) {
			book.setKucun(book.getKucun()-1);
			bookService.update(book);
			
			result.setSuccess(true);
			result.setMsg("���ĳɹ�");
		} else {
			result.setSuccess(false);
			result.setMsg("����ʧ��");
		}
		
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
	/**
	 * /admin/user/sub/list
	 */
	@RequestMapping("/list")
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "limit", required = false) String rows,
			@RequestParam(value = "date1", required = false) String date1, 
			@RequestParam(value = "date2", required = false) String date2, 
			@RequestParam(value = "userId", required = false) String userId, 
			HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		map.put("date1", date1);
		map.put("date2", date2);
		map.put("userId", userId);
		
		List<UserSub> list = userSubService.list(map);
		Integer total = userSubService.getTotal(map);
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm").create();
		
		map.clear();
		map.put("data", list);
		map.put("count", total);
		map.put("code", 0);
		map.put("msg", "");
		ResponseUtil.write(response, gson.toJson(map));
		return null;
	}
	
	
	/**
	 * /admin/user/sub/return_
	 */
	@RequestMapping("/return_")
	public String return_(@RequestParam(value = "subId", required = false) String subId, HttpServletResponse response, HttpServletRequest request) throws Exception {
		
		Result result = new Result();
		Gson gson = new Gson();
		
		UserSub sub = userSubService.findById(Integer.parseInt(subId));
		if(sub.getReturnDateTime()!=null){
			result.setSuccess(false);
			result.setMsg("�ѹ黹����");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
		
		sub.setReturnDateTime(new Date());
		sub.setType(2);
		int resultTotal = userSubService.update(sub);
		
		if (resultTotal > 0) {
			Book book = bookService.findById(sub.getBookId());
			book.setKucun(book.getKucun()+1);
			bookService.update(book);
			
			//ɾ���߻���¼
			cuiHaiService.deleteBySubId(Integer.parseInt(subId));
			
			result.setSuccess(true);
			result.setMsg("�黹�ɹ�");
		} else {
			result.setSuccess(false);
			result.setMsg("�黹ʧ��");
		}
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
}
