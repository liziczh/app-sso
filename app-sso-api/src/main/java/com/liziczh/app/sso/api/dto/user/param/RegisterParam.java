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
public class RegisterParam implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "账号")
	@JsonProperty("username")
	private String username;
	@ApiModelProperty(value = "密码")
	@JsonProperty("password")
	private String password;
	@ApiModelProperty(value = "昵称")
	@JsonProperty("nickname")
	private String nickname;
	@ApiModelProperty(value = "性别")
	@JsonProperty("gender")
	private String gender;
	@ApiModelProperty(value = "生日")
	@JsonProperty("birthday")
	private String birthday;
	@ApiModelProperty(value = "邮箱")
	@JsonProperty("email")
	private String email;
	@ApiModelProperty(value = "手机号")
	@JsonProperty("mobile")
	private String mobile;
}
