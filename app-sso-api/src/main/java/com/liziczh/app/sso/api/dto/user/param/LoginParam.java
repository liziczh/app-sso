package com.liziczh.app.sso.api.dto.user.param;

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
public class LoginParam implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "账号")
	@JsonProperty("username")
	private String username;
	@ApiModelProperty(value = "密码")
	@JsonProperty("password")
	private String password;
}
