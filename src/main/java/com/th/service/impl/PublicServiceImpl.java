package com.th.service.impl;

import com.th.entity.Tree;
import com.th.entity.User;
import com.th.service.PublicService;
import com.th.service.TreeService;
import com.th.service.UserService;
import com.th.util.MyUtil;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("publicService")
public class PublicServiceImpl implements PublicService {
	
	@Resource
	private TreeService treeService;
	@Resource
	private UserService userService;

	@Resource
	private HttpServletRequest request;
	
	public void addLeftMenu(ModelAndView mav) {
		
		mav.addObject("leftPage", "/admin/common/left_menu.jsp");
		
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		currentUser = userService.findById(currentUser.getId());
		
		Map<String, Object> map = new HashMap<String, Object>();
		String menuIds = currentUser.getMenuIds();
		if(menuIds==null){
			menuIds = "";
		}
		List<Integer> ids =MyUtil.Str_ids_To_ListInteger_ids(menuIds);  
		map.put("father", -1);
		map.put("ids", ids);
		
		if(ids.size()>0){
		}else{
			mav.addObject("treeList", null);
		}
		try {
			List<Tree> treeList = getTreesByParentId(map);
			mav.addObject("treeList", treeList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Tree> getTreesByParentId(Map<String,Object> map) {
		List<Tree> list = treeService.getTreesByFatherOrIds(map);
		for(Tree tree : list){
			if("open".equals(tree.getState())){
				continue;
			}else{
				map.put("father", tree.getId()+"");
				tree.setChildren(getTreesByParentId(map));
			}
		}
		return list;
	}
}
