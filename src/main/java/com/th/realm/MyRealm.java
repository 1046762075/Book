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
 * �Զ���Realm
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private UserService userService;
	@Resource
	private TreeService treeService;

	/**
	 * Ϊ��ǰ�ĵ�¼���û���ɫ��Ȩ��
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		// ͨ���û�ȡ����Ӧ��ӵ�е�Ȩ��
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		// ���ý�ɫ ���� ���Ŀǰ�ò�����
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
		// Ȩ�޼���
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
	 * ��֤��ǰ��¼���û�
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
