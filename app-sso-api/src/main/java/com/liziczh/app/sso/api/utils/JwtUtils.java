package com.liziczh.app.sso.api.utils;

import java.util.Calendar;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Slf4j
public class JwtUtils {
	public static final int EXPIRE_HOUR = 24;

	/**
	 * 生成Token
	 * @param payload 载荷信息
	 * @param secret 密钥
	 * @return token
	 */
	public static String createToken(Map<String, String> payload, String secret) {
		Long currentTime = System.currentTimeMillis();
		JWTCreator.Builder builder = JWT.create();
		// payload
		payload.forEach(builder::withClaim);
		// expire_time
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR, EXPIRE_HOUR);
		builder.withExpiresAt(calendar.getTime());
		// sign
		return builder.sign(Algorithm.HMAC256(secret.getBytes()));
	}
	/**
	 * 校验token，获取token载荷
	 * @param token token
	 * @param secret secret
	 * @return 校验结果
	 */
	public static String getPayload(String token, String secret) {
		DecodedJWT jwt = JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
		return jwt.getPayload();
	}
}
