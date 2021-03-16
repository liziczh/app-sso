package com.liziczh.app.sso.api.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhehao.chen
 */
public class CookieUtils {
	/**
	 * 查询Cookie
	 * @param request 请求
	 * @param key 键
	 * @return javax.servlet.http.Cookie
	 * @date 2021/3/16 10:22
	 */
	public static Cookie getCookie(HttpServletRequest request, String key) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (key.equals(cookie.getName())) {
				return cookie;
			}
		}
		return null;
	}
	/**
	 * 设置Cookie
	 * @param response 相应
	 * @param key 键
	 * @param value 值
	 * @param domain
	 * @param path 路径
	 * @param maxAge 生命周期
	 * @param isHttpOnly
	 * @return void
	 * @date 2021/3/16 10:21
	 */
	public static void setCookie(HttpServletResponse response, String key, String value, String domain, String path, int maxAge, boolean isHttpOnly) {
		Cookie cookie = new Cookie(key, value);
		if (domain != null) {
			cookie.setDomain(domain);
		}
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		cookie.setHttpOnly(isHttpOnly);
		response.addCookie(cookie);
	}
	/**
	 * 销毁Cookie
	 * @param request 请求
	 * @param response 响应
	 * @param key 键
	 * @return void
	 * @date 2021/3/16 10:22
	 */
	public static void destroy(HttpServletRequest request, HttpServletResponse response, String key) {
		Cookie cookie = getCookie(request, key);
		if (cookie != null) {
			cookie.setValue("");
			cookie.setMaxAge(0);
			cookie.setPath("/");
			cookie.setHttpOnly(true);
			response.addCookie(cookie);
		}
	}
}
