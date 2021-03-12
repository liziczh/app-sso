package com.liziczh.app.sso.redis.service.impl;

import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

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
	public boolean put(String key, String value, Long expireTime) {
		long time = expireTime - System.currentTimeMillis();
		if (time <= 0) {
			return false;
		}
		return redisTemplate.opsForValue().setIfAbsent(key, key, time, TimeUnit.MILLISECONDS);
	}
	@Override
	public void remove(String key) {
		redisTemplate.delete(key);
	}
}
