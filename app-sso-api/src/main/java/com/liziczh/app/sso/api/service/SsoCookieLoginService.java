package com.liziczh.app.sso.api.service;

import com.liziczh.base.common.service.BaseService;

public interface SsoCookieLoginService extends BaseService {
	/**
	 * 账号密码登录
	 * @param username 用户名
	 * @param password 密码
	 * @param ifRemember ifRemember
	 */
	String login(String username, String password, boolean ifRemember);
	/**
	 * 登录状态校验
	 */
	void doAuthentication();
	/**
	 * 退出登录
	 */
	void logout();
}