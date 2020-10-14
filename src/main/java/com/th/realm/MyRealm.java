package com.th.realm;

import com.th.entity.Tree;
import com.th.entity.User;
import com.th.service.TreeService;
import com.th.service.UserService;
import com.th.util.CryptographyUtil;
import com.th.util.MyUtil;
import com.th.util.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 自定义Realm
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	@Resource
	private TreeService treeService;

	/**
	 * 为当前的登录的用户角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// 通过用户取得他应该拥有的权限
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// 设置角色 集合 这个目前用不到。
		// authorizationInfo.setRoles(roles);
		User user = (User) SecurityUtils.getSubject().getSession().getAttribute("currentUser");
		if (user == null) return null;

		user = userService.findById(user.getId());

		Map<String, Object> map = new HashMap<String, Object>();
		List<Integer> ids = MyUtil.Str_ids_To_ListInteger_ids(user.getMenuIds());
		map.put("ids", ids);
		if (ids.size() > 0) {
		} else {
			return authorizationInfo;
		}

		List<Tree> treeList = treeService.getTreesByFatherOrIds(map);
		// 权限集合
		Set<String> stringPermissions = new HashSet<>();
		for (Tree tree : treeList) {
			if (StringUtil.isNotEmpty(tree.getPermissions())) {
				stringPermissions.add(tree.getPermissions());
			}
		}
		authorizationInfo.setStringPermissions(stringPermissions);
		return authorizationInfo;
	}

	/**
	 * 验证当前登录的用户
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

		String login_type = (String) SecurityUtils.getSubject().getSession().getAttribute("login_type");
		switch (login_type) {
			case "wx_login":
				String openid = (String) token.getPrincipal();
				if (openid != null) {
					AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(openid, CryptographyUtil.md5(openid, "chenhao"), "xxx");
					return authcInfo;
				} else {
				}
				break;
			case "user_login":
				String num = (String) token.getPrincipal();
				User user = userService.findByNum(num);
				if (user != null) {
					AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getNum_(), user.getPassword(), "xxx");
					return authcInfo;
				} else {
				}
				break;
		}
		return null;
	}
}
