package com.liziczh.app.sso.api.service;

import com.liziczh.app.sso.api.dto.user.param.LoginDTO;
import com.liziczh.base.common.service.BaseService;

public interface SsoTokenLoginService extends BaseService {
	/**
	 * 账号密码登录
	 * @param param 登录参数
	 * @param appKey appKey
	 * @return token
	 */
	String login(LoginDTO param, String appKey);
	/**
	 * 登录状态校验
	 * @param token token
	 * @param appKey appKey
	 * @return token
	 */
	boolean doAuthentication(String token, String appKey);
	/**
	 * 退出登录
	 * @param token token
	 */
	void logout(String token);
}
