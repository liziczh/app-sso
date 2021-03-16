package com.liziczh.app.sso.service.service.impl;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.app.sso.api.dto.session.AuthInfoDTO;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.LoginService;
import com.liziczh.app.sso.api.utils.CookieUtils;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.base.common.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class LoginByCookieServiceImpl implements LoginService {
	@Autowired
	private TUserInfoMapper userInfoMapper;
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private HttpServletResponse response;

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
		Cookie cookie = new Cookie("SESSION_ID", sessionId);
		cookie.setPath("/");
		cookie.setMaxAge(Integer.MAX_VALUE);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
		return sessionId;
	}
	@Override
	public AuthInfoDTO doAuthentication(String sessionId) {
		return null;
	}
	@Override
	public void logout(String sessionId) {
		// Cookie销毁会话信息
		CookieUtils.destroy(request, response, sessionId);
	}
}
