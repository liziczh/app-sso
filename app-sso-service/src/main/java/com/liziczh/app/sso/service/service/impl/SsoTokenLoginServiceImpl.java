package com.liziczh.app.sso.service.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.token.TokenHeader;
import com.liziczh.app.sso.api.dto.token.TokenPayload;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.SsoTokenLoginService;
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
	public String login(String username, String password) {
		// findUser
		TUserInfo userInfo = userService.getUserByUsernameAndPassword(username, password);
		// secret
		String secret = "";
		// token
		long currentTime = System.currentTimeMillis();
		// TokenHeader
		TokenHeader tokenHeader = new TokenHeader();
		tokenHeader.setTyp(TokenUtils.TYPE);
		tokenHeader.setAlg(TokenUtils.ALGORITHM);
		// TokenPayload
		TokenPayload tokenPayload = new TokenPayload();
		tokenPayload.setJid(String.valueOf(UUID.randomUUID()));
		tokenPayload.setIss(TokenUtils.ISSUER);
		tokenPayload.setIat(String.valueOf(currentTime));
		tokenPayload.setNbf(String.valueOf(currentTime));
		tokenPayload.setExp(String.valueOf(currentTime + 24 * 60 * 60 * 1000L));
		tokenPayload.setSub("主题");
		tokenPayload.setAud("受众");
		return TokenUtils.createToken(tokenHeader, tokenPayload, secret);
	}
	@Override
	public boolean doAuthentication(String token) {
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
