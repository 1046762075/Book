package com.th.controller;


import com.google.gson.Gson;
import com.th.entity.Result;
import com.th.entity.User;
import com.th.service.UserService;
import com.th.util.CryptographyUtil;
import com.th.util.ResponseUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@Value("${salt}")
	private String salt;

	/**
	 * /user/add
	 */
	@RequestMapping("/add")
	public String add(User user, HttpServletResponse response) throws Exception {
		user.setPassword(CryptographyUtil.md5(user.getPassword(), salt));
		user.setCreateDateTime(new Date());
		user.setRemark(user.getTrueName());
		user.setMenuIds("17,171000,171005,171009,171011,171010");
		int resultTotal = userService.add(user);
		Result result = new Result();
		Gson gson = new Gson();
		if (resultTotal > 0) {
			result.setSuccess(true);
			result.setMsg("��ӳɹ�");
		} else {
			result.setSuccess(false);
			result.setMsg("���ʧ��");
		}
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}

	/**
	 * /user/login
	 * ���Ե�½
	 */
	@RequestMapping("/login")
	public String login(User user, HttpServletResponse response) throws Exception {
		Result result = new Result();
		Gson gson = new Gson();
		Subject subject = SecurityUtils.getSubject();

		SecurityUtils.getSubject().getSession().setAttribute("login_type", "user_login");

		UsernamePasswordToken token = new UsernamePasswordToken(user.getNum_(), CryptographyUtil.md5(user.getPassword(), salt));
		try {
			subject.login(token);
			//�����½�ɹ� �Ͳ��ᱨ��  ������ǵ�½ʧ����
			user = userService.findByNum(user.getNum_());
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", user);
			result.setSuccess(true);
			result.setMsg("��½�ɹ�");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			result.setSuccess(false);
			result.setMsg("�ʺŻ��������");
			ResponseUtil.write(response, gson.toJson(result));
			return null;
		}
	}

	/**
	 * /user/logout
	 *
	 * @throws Exception
	 */
	@RequestMapping("/logout")
	public String logout() {
		SecurityUtils.getSubject().logout(); //shiro���˳�
		return "redirect:/login";
	}
}
