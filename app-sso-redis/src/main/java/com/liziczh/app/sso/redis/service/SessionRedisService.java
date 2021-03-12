package com.liziczh.app.sso.redis.service;

/**
 * @author zhehao.chen
 */
public interface SessionRedisService {
	/**
	 * 添加会话
	 * @param sessionId 键
	 * @param value 值
	 * @param expireTime 过期时间
	 * @return
	 */
	boolean put(String sessionId, String value, Long expireTime);
	/**
	 * 移除会话
	 * @param sessionId
	 */
	void remove(String sessionId);
}
