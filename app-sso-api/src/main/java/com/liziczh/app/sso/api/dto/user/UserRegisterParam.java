package com.liziczh.app.sso.api.dto.user;

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
public class UserRegisterParam implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "昵称")
	@JsonProperty("nickname")
	private String nickname;
	@ApiModelProperty(value = "性别")
	@JsonProperty("gender")
	private String gender;
	@ApiModelProperty(value = "邮箱")
	@JsonProperty("email")
	private String email;
	@ApiModelProperty(value = "手机号")
	@JsonProperty("mobile")
	private String mobile;
	@ApiModelProperty(value = "密码")
	@JsonProperty("password")
	private String password;
}
