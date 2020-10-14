package com.th.controller;


import com.google.gson.Gson;
import com.th.entity.Result;
import com.th.util.DateUtil;
import com.th.util.FileUtil;
import com.th.util.QRcodeUtil;
import com.th.util.ResponseUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;

@Controller
@RequestMapping("/qrcode")
public class QRcodeController {
	/**
	 * /qrcode/create
	 * @param content
	 * @param requset
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping("/create")
	public String getQRCode(@RequestParam(value = "content", required = false) String content,
			HttpServletRequest requset, HttpServletResponse response) throws Exception {
		
		BufferedImage bufImg = QRcodeUtil.qRCodeCommon(content, "jpg", QRcodeUtil.getSize(content));
		String fileName = DateUtil.formatDate(new Date(), "yyyyMMddHHmmssSSS");
		String path = requset.getSession().getServletContext().getRealPath("");
		String file_path = "/static/images/QRcode/";
		
		path = path +file_path ;
		FileUtil.makeDirs(path);
		try {
			ImageIO.write(bufImg, "jpg", new File(path + fileName + ".jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg(file_path+fileName + ".jpg");
		Gson gson = new Gson();
		ResponseUtil.write(response, gson.toJson(result));
		return null;
	}
	
}
