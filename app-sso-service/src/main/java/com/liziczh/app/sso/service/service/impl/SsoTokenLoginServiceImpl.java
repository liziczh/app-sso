package com.liziczh.app.sso.service.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.token.TokenPayload;
import com.liziczh.app.sso.api.dto.user.param.LoginDTO;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.SsoTokenLoginService;
import com.liziczh.app.sso.api.utils.JwtUtils;
import com.liziczh.app.sso.api.utils.TokenUtils;
import com.liziczh.app.sso.internal.service.UserService;

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

	@Override
	public String login(LoginDTO param, String appKey) {
		// findUser
		TUserInfo userInfo = userService.getUserByUsernameAndPassword(param.getUsername(), param.getPassword());
		// secret
		String secret = "";
		// token
		long currentTime = System.currentTimeMillis();
		Map<String, String> map = new HashMap<>();
		map.put("USER_ID", String.valueOf(userInfo.getId()));
		String token = JwtUtils.createToken(map, secret);
		return token;
	}
	@Override
	public boolean doAuthentication(String token, String appKey) {
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
