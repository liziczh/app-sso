package com.liziczh.app.sso.api.service;

import com.liziczh.base.common.service.BaseService;

public interface LoginService extends BaseService {
	/**
	 * 账号密码登录
	 * @param username 用户名
	 * @param password 密码
	 * @return token
	 */
	String login(String username, String password);
	/**
	 * 退出登录
	 * @param sessionId sessionId
	 */
	void logout(String sessionId);
}
