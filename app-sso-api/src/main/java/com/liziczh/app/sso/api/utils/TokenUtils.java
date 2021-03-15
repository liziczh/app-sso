package com.liziczh.app.sso.api.utils;

import java.util.Base64;
import java.util.UUID;

import com.liziczh.app.sso.api.dto.token.TokenHeader;
import com.liziczh.app.sso.api.dto.token.TokenPayload;
import com.liziczh.base.common.util.AESUtils;
import com.liziczh.base.common.util.JacksonUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhehao.chen
 */
@Slf4j
public class TokenUtils {
	public static final String TYPE = "JWT";
	public static final String ALGORITHM = "AES";
	public static final String ISSUER = "";
	public static final Integer EXPIRE_DAYS = 30;
	public static final String TOKEN_AES_KEY = "0123456789012345";
	public static final String REFRESH_TOKEN_AES_KEY = "refresh123456";
	public static final String SEPARATOR = ".";
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
		String sign = AESUtils.aesEncrypt(headerBase64 + SEPARATOR + payloadBase64, TOKEN_AES_KEY);
		String token = headerBase64 + SEPARATOR + payloadBase64 + SEPARATOR + sign;
		return Base64.getEncoder().encodeToString(token.getBytes());
	}
	/**
	 * 校验token
	 * @param tokenBase64 tokenBase64
	 * @return 校验结果
	 */
	public static Boolean checkToken(String tokenBase64) {
		// 拆分Header、Payload、Sign
		String token = new String(Base64.getDecoder().decode(tokenBase64));
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
		String newSign = AESUtils.aesEncrypt(headerBase64 + SEPARATOR + payloadBase64, TOKEN_AES_KEY);
		if (!sign.equals(newSign)) {
			log.info("token is invalid");
			return false;
		}
		// Json
		String header = new String(Base64.getDecoder().decode(headerBase64));
		String payload = new String(Base64.getDecoder().decode(payloadBase64));
		return true;
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
