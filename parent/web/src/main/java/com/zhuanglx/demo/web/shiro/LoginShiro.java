package com.zhuanglx.demo.web.shiro;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhuanglx.demo.service.DbaService;

@Service
@Transactional
public class LoginShiro extends AuthorizingRealm {
	@Autowired
	private DbaService dbaService;

	/**
	 * 权限认证
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principalCollection) {
		// 获取登录时输入的用户名
		String loginName = (String) principalCollection.fromRealm(getName())
				.iterator().next();
		// 到数据库查是否有此对象 
		//User user=userService.findByName(loginName);
		//if (user != null) {
		if (true) {
			// 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			// 用户的角色集合
			Set<String> roleNames = new HashSet<String>();
			info.setRoles(roleNames);
			// 用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
			//List<Role> roleList = user.getRoleList();
			//for (Role role : roleList) {
			//	info.addStringPermissions(role.getPermissionsName());
			//}
			return info;
		}
		return null;
	}

	/**
	 * 登录认证;
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authenticationToken)
			throws AuthenticationException {
		// UsernamePasswordToken对象用来存放提交的登录信息
		UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
		// 查出是否有此用户
		//User user = userService.findByName(token.getUsername());
		//if (user != null) {
		if (true) {
			// 若存在，将此用户存放到登录认证info中
			//return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
			return new SimpleAuthenticationInfo("name", "password", getName());
		}
		return null;
	}
}
