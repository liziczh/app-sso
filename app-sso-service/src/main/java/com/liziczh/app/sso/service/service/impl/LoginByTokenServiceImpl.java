package com.liziczh.app.sso.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;
import com.liziczh.app.sso.api.service.LoginByTokenService;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.app.sso.redis.service.SessionRedisService;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class LoginByTokenServiceImpl implements LoginByTokenService {
	@Autowired
	private TUserInfoMapper tUserInfoMapper;
	@Autowired
	private SessionRedisService sessionRedisService;

	@Override
	public String login(String username, String password) {
		return null;
	}
	@Override
	public AuthInfoDTO doAuthentication(String sessionId) {
		return null;
	}
	@Override
	public void logout(String token) {
		// TODO Token失效
	}
}
