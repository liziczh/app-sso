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
public class TokenPayload implements Serializable {
	private static final long serialVersionUID = -3640216333547585805L;
	@ApiModelProperty(value = "编号（JWT ID）")
	@JsonProperty("jid")
	private String jid;
	@ApiModelProperty(value = "签发人（Issuer）")
	@JsonProperty("iss")
	private String iss;
	@ApiModelProperty(value = "签发时间（Issued At）")
	@JsonProperty("iat")
	private String iat;
	@ApiModelProperty(value = "生效时间（Not Before）")
	@JsonProperty("nbf")
	private String nbf;
	@ApiModelProperty(value = "过期时间（Expiration time）")
	@JsonProperty("exp")
	private String exp;
	@ApiModelProperty(value = "主题（Subject）")
	@JsonProperty("sub")
	private String sub;
	@ApiModelProperty(value = "受众（Audience）")
	@JsonProperty("aud")
	private String aud;
}
