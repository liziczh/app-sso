package com.liziczh.app.sso.web.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.liziczh.app.sso.web.interceptor.SsoTokenLoginInterceptor;

@Component
public class InterceptorConfig implements WebMvcConfigurer {
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SsoTokenLoginInterceptor()).excludePathPatterns("/login/**")
				.addPathPatterns("/**");
	}
}
