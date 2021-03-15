package com.liziczh.app.sso.service.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.LoginService;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.app.sso.redis.service.SessionRedisService;
import com.liziczh.base.common.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class LoginBySessionServiceImpl implements LoginService {
	@Autowired
	private TUserInfoMapper userInfoMapper;
	@Autowired
	private SessionRedisService sessionRedisService;

	@Override
	public String login(String username, String password) {
		// findUser
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getUsername, username).eq(TUserInfo::getPassword, DigestUtils.md5DigestAsHex(password));
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		// sessionId
		String uuid = UUID.randomUUID().toString().replace("-", "");
		String sessionId = userInfo.getId() + uuid;
		// login
		AuthInfoDTO dto = new AuthInfoDTO();
		dto.setUserId(String.valueOf(userInfo.getId()));
		dto.setExpireTime(24 * 60 * 60 * 1000);
		dto.setRefreshTime(System.currentTimeMillis());
		sessionRedisService.set(sessionId, dto);
		return sessionId;
	}
	@Override
	public AuthInfoDTO doAuthentication(String sessionId) {
		AuthInfoDTO dto = sessionRedisService.get(sessionId);
		if (dto == null) {
			return null;
		}
		// refresh
		if (System.currentTimeMillis() - dto.getRefreshTime() > dto.getExpireTime() / 2) {
			dto.setRefreshTime(System.currentTimeMillis());
		}
		return dto;
	}
	@Override
	public void logout(String sessionId) {
		// 移除Session会话信息
		sessionRedisService.remove(sessionId);
	}
}
