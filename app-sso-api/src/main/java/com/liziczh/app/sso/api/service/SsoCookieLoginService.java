package com.liziczh.app.sso.api.service;

import com.liziczh.app.sso.api.dto.user.param.LoginDTO;
import com.liziczh.base.common.service.BaseService;

public interface SsoCookieLoginService extends BaseService {
	/**
	 * 账号密码登录
	 * @param param 登录
	 */
	String login(LoginDTO param);
	/**
	 * 登录状态校验
	 */
	void doAuthentication();
	/**
	 * 退出登录
	 */
	void logout();
}
