package com.liziczh.app.sso.redis.service;

import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;

/**
 * @author zhehao.chen
 */
public interface SessionRedisService {
	/**
	 * 添加会话
	 * @param sessionId 键
	 * @param dto 值
	 */
	void set(String sessionId, AuthInfoDTO dto);
	/**
	 * 获取用户信息
	 * @param sessionId 键
	 * @return
	 */
	AuthInfoDTO get(String sessionId);
	/**
	 * 移除session
	 * @param sessionId
	 */
	void remove(String sessionId);
}
