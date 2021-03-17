package com.liziczh.app.sso.api.utils;

import java.util.Base64;

import com.liziczh.app.sso.api.dto.token.TokenHeader;
import com.liziczh.app.sso.api.dto.token.TokenPayload;
import com.liziczh.base.common.util.HmacSHA256;
import com.liziczh.base.common.util.JacksonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Slf4j
public class TokenUtils {
	public static final String TYPE = "JWT";
	public static final String ALGORITHM = "HS256";
	public static final String SEPARATOR = ".";
	public static final String ISSUER = "";

	/**
	 * 生成Token
	 * @param tokenHeader 头部信息
	 * @param tokenPayload 载荷信息
	 * @param secret 密钥
	 * @return token
	 */
	public static String createToken(TokenHeader tokenHeader, TokenPayload tokenPayload, String secret) {
		// Json
		String header = JacksonUtils.toJSONString(tokenHeader);
		String payload = JacksonUtils.toJSONString(tokenPayload);
		// Base64
		String headerBase64 = Base64.getEncoder().encodeToString(header.getBytes());
		String payloadBase64 = Base64.getEncoder().encodeToString(payload.getBytes());
		// sign
		String sign = HmacSHA256.hmacSHA256(headerBase64 + SEPARATOR + payloadBase64, secret);
		return headerBase64 + SEPARATOR + payloadBase64 + SEPARATOR + sign;
	}
	/**
	 * 校验token
	 * @param token token
	 * @return 校验结果
	 */
	public static Boolean checkToken(String token, String secret) {
		// 拆分Header、Payload、Sign
		if (!token.contains(SEPARATOR)) {
			log.info("token is invalid");
			return false;
		}
		String[] tokenSplit = token.split("\\.");
		if (tokenSplit.length != 3) {
			log.info("token is invalid");
			return false;
		}
		String headerBase64 = tokenSplit[0];
		String payloadBase64 = tokenSplit[1];
		String sign = tokenSplit[2];
		// 校验sign
		String newSign = HmacSHA256.hmacSHA256(headerBase64 + SEPARATOR + payloadBase64, secret);
		if (!sign.equals(newSign)) {
			log.info("token is invalid");
			return false;
		}
		// Json
		String header = new String(Base64.getDecoder().decode(headerBase64));
		String payload = new String(Base64.getDecoder().decode(payloadBase64));
		return true;
	}
}
