package com.liziczh.app.sso.internal.service;

import com.liziczh.app.sso.api.entity.TUserInfo;

public interface UserService {
	/**
	 * 账号密码查询
	 * @param username 账号
	 * @param password 密码
	 * @return com.liziczh.app.sso.api.entity.TUserInfo
	 * @date 2021/3/16 15:45
	 */
	TUserInfo getUserByUsernameAndPassword(String username, String password);
	/**
	 * 手机号密码查询
	 * @param mobile 手机号
	 * @param password 密码
	 * @return com.liziczh.app.sso.api.entity.TUserInfo
	 * @date 2021/3/16 15:45
	 */
	TUserInfo getUserByMobileAndPassword(String mobile, String password);
	/**
	 * 邮箱密码查询
	 * @param email 邮箱
	 * @param password 验证码
	 * @return com.liziczh.app.sso.api.entity.TUserInfo
	 * @date 2021/3/16 15:45
	 */
	TUserInfo getUserByEmailAndPassword(String email, String password);
	/**
	 * 手机号查询
	 * @param mobile 手机号
	 * @return com.liziczh.app.sso.api.entity.TUserInfo
	 * @date 2021/3/16 15:45
	 */
	TUserInfo getUserByMobile(String mobile);
	/**
	 * 邮箱查询
	 * @param email 邮箱
	 * @return com.liziczh.app.sso.api.entity.TUserInfo
	 * @date 2021/3/16 15:45
	 */
	TUserInfo getUserByEmail(String email);
}
