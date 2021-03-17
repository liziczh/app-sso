package com.liziczh.app.sso.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.liziczh.app.sso.api.service.SsoCookieLoginService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Component
@Slf4j
public class SsoCookieLoginInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private SsoCookieLoginService ssoCookieLoginService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 登录验证
		ssoCookieLoginService.doAuthentication();
		// 用户信息
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
