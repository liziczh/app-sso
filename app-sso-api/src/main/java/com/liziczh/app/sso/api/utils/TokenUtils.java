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
	public static final String TYPE = "";
	public static final String ALGORITHM = "";
	public static final String ISSUER = "";

	public static String getToken() {
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
		tokenPayload.setExp(String.valueOf(currentTime + 30 * 24 * 60 * 60 * 1000L));
		tokenPayload.setSub("主题");
		tokenPayload.setAud("受众");
		// Json
		String header = JacksonUtils.toJSONString(tokenHeader);
		String payload = JacksonUtils.toJSONString(tokenPayload);
		// Base64
		String headerBase64 = Base64.getEncoder().encodeToString(header.getBytes());
		String payloadBase64 = Base64.getEncoder().encodeToString(payload.getBytes());
		return null;
	}
}
