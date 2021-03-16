package com.liziczh.app.sso.service.service.impl;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.LoginBySessionService;
import com.liziczh.app.sso.api.utils.CookieUtils;
import com.liziczh.app.sso.internal.service.UserService;
import com.liziczh.app.sso.redis.service.SessionRedisService;
import com.liziczh.base.common.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class LoginBySessionServiceImpl implements LoginBySessionService {
	public static final String COOKIE_SESSION_ID = "SESSION_ID";
	public static final String COOKIE_PATH = "/";
	public static final int COOKIE_MAX_AGE = Integer.MAX_VALUE;
	public static final int COOKIE_AGE = -1;
	public static final int SESSION_EXPIRE_TIME = 24 * 60 * 60 * 1000;
	@Autowired
	private UserService userService;
	@Autowired
	private SessionRedisService sessionRedisService;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

	@Override
	public String login(String username, String password, boolean ifRemember) {
		// findUser
		TUserInfo userInfo = userService.getUserByUsernameAndPassword(username, password);
		// sessionId
		String sessionId = DigestUtils.md5DigestAsHex(userInfo.getId() + UUID.randomUUID().toString());
		// session
		AuthInfoDTO dto = new AuthInfoDTO();
		dto.setUserId(String.valueOf(userInfo.getId()));
		dto.setExpireTime(SESSION_EXPIRE_TIME);
		dto.setRefreshTime(System.currentTimeMillis());
		sessionRedisService.set(sessionId, dto);
		// cookie
		CookieUtils.setCookie(response, COOKIE_SESSION_ID, sessionId, null, COOKIE_PATH, ifRemember ? COOKIE_MAX_AGE : COOKIE_AGE, true);
		return sessionId;
	}
	@Override
	public void doAuthentication(boolean ifRemember) {
		// Cookie获取sessionId
		Cookie cookie = CookieUtils.getCookie(request, COOKIE_SESSION_ID);
		if (cookie != null) {
			String sessionId = cookie.getValue();
			AuthInfoDTO dto = sessionRedisService.get(sessionId);
			if (dto == null) {
				return;
			}
			// refresh
			if (System.currentTimeMillis() - dto.getRefreshTime() > dto.getExpireTime() / 2) {
				// delete old session
				sessionRedisService.delete(sessionId);
				// destroy old cookie
				CookieUtils.destroy(request, response, sessionId);
				// new sessionId
				sessionId = DigestUtils.md5DigestAsHex(dto.getUserId() + UUID.randomUUID().toString());
				// set new session
				dto.setRefreshTime(System.currentTimeMillis());
				sessionRedisService.set(sessionId, dto);
				// set new cookie
				CookieUtils.setCookie(response, COOKIE_SESSION_ID, sessionId, null, COOKIE_PATH, ifRemember ? COOKIE_MAX_AGE : COOKIE_AGE, true);
			}
		}
	}
	@Override
	public void logout() {
		// cookie获取sessionId
		Cookie cookie = CookieUtils.getCookie(request, COOKIE_SESSION_ID);
		if (cookie != null) {
			// sessionId
			String sessionId = cookie.getValue();
			// delete session
			sessionRedisService.delete(sessionId);
			// destroy cookie
			CookieUtils.destroy(request, response, sessionId);
		}
	}
}
