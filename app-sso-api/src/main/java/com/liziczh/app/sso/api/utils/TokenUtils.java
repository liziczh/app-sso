package com.liziczh.app.sso.api.utils;

import java.util.Base64;
import java.util.UUID;

import com.liziczh.app.sso.api.dto.token.TokenHeader;
import com.liziczh.app.sso.api.dto.token.TokenPayload;
import com.liziczh.base.common.util.JacksonUtils;

/**
 * @author zhehao.chen
 */
public class TokenUtils {
	public static final String TYPE = "JWT";
	public static final String ALGORITHM = "AES";
	public static final String ISSUER = "";
	public static final Integer EXPIRE_DAYS = 30;
	public static final String TOKEN_AES_KEY = "123456";
	public static final String REFRESH_TOKEN_AES_KEY = "refresh123456";

	/**
	 * 生成Token
	 * @param tokenHeader 头部信息
	 * @param tokenPayload 载荷信息
	 * @return token
	 */
	public static String createToken(TokenHeader tokenHeader, TokenPayload tokenPayload) {
		// Json
		String header = JacksonUtils.toJSONString(tokenHeader);
		String payload = JacksonUtils.toJSONString(tokenPayload);
		// Base64
		String headerBase64 = Base64.getEncoder().encodeToString(header.getBytes());
		String payloadBase64 = Base64.getEncoder().encodeToString(payload.getBytes());
		String sign = AESUtils.aesEncrypt(headerBase64 + "." + payloadBase64, TOKEN_AES_KEY);
		String signBase64 = Base64.getEncoder().encodeToString(sign.getBytes());
		String token = headerBase64 + "." + payloadBase64 + "." + signBase64;
		return Base64.getEncoder().encodeToString(token.getBytes());
	}
	/**
	 * 校验token
	 * @param token token
	 * @return 校验结果
	 */
	public static boolean checkToken(String token) {
		return false;
	}
	public static void main(String[] args) {
		long currentTime = System.currentTimeMillis();
		// TokenHeader
		TokenHeader tokenHeader = new TokenHeader();
		tokenHeader.setTyp(TYPE);
		tokenHeader.setAlg(ALGORITHM);
		// TokenPayload
		TokenPayload tokenPayload = new TokenPayload();
		tokenPayload.setJid(String.valueOf(UUID.randomUUID()));
		tokenPayload.setIss(ISSUER);
		tokenPayload.setIat(String.valueOf(currentTime));
		tokenPayload.setNbf(String.valueOf(currentTime));
		tokenPayload.setExp(String.valueOf(currentTime + EXPIRE_DAYS * 24 * 60 * 60 * 1000L));
		tokenPayload.setSub("主题");
		tokenPayload.setAud("受众");
		// createToken
		String token = createToken(tokenHeader, tokenPayload);
		System.out.println(token);
		// checkToken
		Boolean result = checkToken(token);
		System.out.println(result);
	}
}
