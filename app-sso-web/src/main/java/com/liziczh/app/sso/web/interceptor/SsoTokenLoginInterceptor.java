package com.liziczh.app.sso.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.liziczh.app.sso.api.service.SsoTokenLoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Component
@Slf4j
public class SsoTokenLoginInterceptor extends HandlerInterceptorAdapter {
	public static final String AUTHORIZATION = "Authorization";
	@Autowired
	private SsoTokenLoginService ssoTokenLoginService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 登录验证
		String token = request.getHeader(AUTHORIZATION);
		boolean isLogin = ssoTokenLoginService.doAuthentication(token);
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
	}
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
	}
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	}
}
