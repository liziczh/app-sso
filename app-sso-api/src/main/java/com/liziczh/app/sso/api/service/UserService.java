package com.liziczh.app.sso.api.service;

import com.liziczh.app.sso.api.dto.user.UserRegisterParam;
import com.liziczh.base.common.service.BaseService;

public interface UserService extends BaseService {
	/**
	 * 注册
	 * @param param 注册参数
	 * @return 用户ID
	 */
	String register(UserRegisterParam param);
	/**
	 * 账号密码登录
	 * @param username 用户名
	 * @param password 密码
	 * @return token
	 */
	String login(String username, String password);
	/**
	 * 退出
	 * @param userId 用户ID
	 * @param token token
	 */
	void logout(String userId, String token);
}
