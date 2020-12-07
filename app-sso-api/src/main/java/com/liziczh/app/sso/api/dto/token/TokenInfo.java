package com.liziczh.app.sso.api.dto.token;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户注册参数
 * @author zhehao.chen
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TokenInfo implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "token")
	@JsonProperty("token")
	private String token;
	@ApiModelProperty(value = "刷新Token")
	@JsonProperty("refresh_token")
	private String refreshToken;
	@ApiModelProperty(value = "过期时间")
	@JsonProperty("expire_time")
	private String expireTime;
}
