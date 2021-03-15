package com.liziczh.app.sso.redis.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;
import com.liziczh.app.sso.redis.service.SessionRedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Slf4j
@Service
public class SessionRedisServiceImpl implements SessionRedisService {
	@Resource(name = "redisCustomTemplate")
	private RedisTemplate redisTemplate;

	@Override
	public void set(String sessionId, AuthInfoDTO dto) {
		long time = dto.getExpireTime() - System.currentTimeMillis();
		redisTemplate.opsForValue().set(sessionId, dto, time, TimeUnit.MILLISECONDS);
	}
	@Override
	public AuthInfoDTO get(String sessionId) {
		return (AuthInfoDTO) redisTemplate.opsForValue().get(sessionId);
	}
	@Override
	public void remove(String key) {
		redisTemplate.delete(key);
	}
}
