package com.liziczh.app.sso.service.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;
import com.liziczh.app.sso.api.dto.token.TokenPayload;
import com.liziczh.app.sso.api.dto.user.param.LoginDTO;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.SsoTokenLoginService;
import com.liziczh.app.sso.api.utils.JwtUtils;
import com.liziczh.app.sso.api.utils.TokenUtils;
import com.liziczh.app.sso.internal.service.UserService;
import com.liziczh.app.sso.redis.service.SessionRedisService;
import com.liziczh.base.common.exception.BizInfoException;
import com.liziczh.base.common.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class SsoTokenLoginServiceImpl implements SsoTokenLoginService {
	@Autowired
	private UserService userService;
	@Autowired
	private SessionRedisService sessionRedisService;
	public static final int SESSION_EXPIRE_TIME = 24 * 60 * 60 * 1000;

	@Override
	public String login(LoginDTO param, String appId) {
		// findUser
		TUserInfo userInfo = userService.getUserByUsername(param.getUsername());
		// check password
		if (!userInfo.getPassword().equals(DigestUtils.md5DigestAsHex(param.getPassword()))) {
			throw new BizInfoException("400", "密码不正确");
		}
		// secret
		String secret = "";
		// token
		Map<String, String> map = new HashMap<>();
		map.put("USER_ID", String.valueOf(userInfo.getId()));
		String token = JwtUtils.createToken(map, secret);
		// session
		AuthInfoDTO dto = new AuthInfoDTO();
		dto.setUserId(String.valueOf(userInfo.getId()));
		dto.setExpireTime(SESSION_EXPIRE_TIME);
		dto.setRefreshTime(System.currentTimeMillis());
		sessionRedisService.set(token, dto);
		return token;
	}
	@Override
	public boolean doAuthentication(String token, String appId) {
		// secret
		String secret = "";
		// check token
		TokenPayload payload = TokenUtils.getPayload(token, secret);
		return payload != null;
	}
	@Override
	public void logout(String token) {
		// TODO Token失效
	}
}
