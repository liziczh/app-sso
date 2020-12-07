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
public class TokenHeader implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "类型（Type）")
	@JsonProperty("typ")
	private String typ;
	@ApiModelProperty(value = "算法（Algorithm）")
	@JsonProperty("alg")
	private String alg;
}
