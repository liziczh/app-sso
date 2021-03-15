package com.liziczh.app.sso.api.dto.session;

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
public class AuthInfoDTO implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "用户ID")
	@JsonProperty("user_id")
	private String userId;
	@ApiModelProperty(value = "过期时间")
	@JsonProperty("expire_time")
	private long expireTime;
	@ApiModelProperty(value = "刷新时间")
	@JsonProperty("refresh_time")
	private long refreshTime;
}
