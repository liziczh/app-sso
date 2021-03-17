package com.liziczh.app.sso.api.service;

import com.liziczh.base.common.service.BaseService;

public interface SsoTokenLoginService extends BaseService {
	/**
	 * 账号密码登录
	 * @param username 用户名
	 * @param password 密码
	 * @return token
	 */
	String login(String username, String password);
	/**
	 * 登录状态校验
	 * @param token token
	 * @return token
	 */
	boolean doAuthentication(String token);
	/**
	 * 退出登录
	 * @param token token
	 */
	void logout(String token);
}
