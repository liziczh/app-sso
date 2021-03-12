package com.liziczh.app.sso.api.service;

import com.liziczh.app.sso.api.dto.user.param.RegisterParam;
import com.liziczh.base.common.service.BaseService;

public interface RegisterService extends BaseService {
	/**
	 * 注册用户
	 * @param param 注册参数
	 * @return 用户ID
	 */
	String register(RegisterParam param);
}
