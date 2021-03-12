package com.liziczh.app.sso.api.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.liziczh.base.common.entity.BaseEntity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TUserInfo extends BaseEntity {
	private static final long serialVersionUID = -3399850105386695874L;
	@ApiModelProperty(value = "ID")
	@JsonProperty("id")
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	@ApiModelProperty(value = "账号")
	@JsonProperty("username")
	@TableField(value = "USERNAME")
	private String username;
	@ApiModelProperty(value = "密码")
	@JsonProperty("password")
	@TableField(value = "PASSWORD")
	private String password;
	@ApiModelProperty(value = "昵称")
	@JsonProperty("nickname")
	@TableField(value = "NICKNAME")
	private String nickname;
	@ApiModelProperty(value = "性别")
	@JsonProperty("gender")
	@TableField(value = "GENDER")
	private String gender;
	@ApiModelProperty(value = "生日")
	@JsonProperty("birthday")
	@TableField(value = "BIRTHDAY")
	private String birthday;
	@ApiModelProperty(value = "邮箱")
	@JsonProperty("email")
	@TableField(value = "EMAIL")
	private String email;
	@ApiModelProperty(value = "手机号")
	@JsonProperty("mobile")
	@TableField(value = "MOBILE")
	private String mobile;
	@ApiModelProperty(value = "真实姓名")
	@JsonProperty("id_name")
	@TableField(value = "ID_NAME")
	private String idName;
	@ApiModelProperty(value = "证件类型")
	@JsonProperty("id_card_type")
	@TableField(value = "ID_CARD_TYPE")
	private String idCardType;
	@ApiModelProperty(value = "证件号")
	@JsonProperty("id_card")
	@TableField(value = "ID_CARD")
	private String idCard;
	@ApiModelProperty(value = "创建时间")
	@JsonProperty("create_time")
	@TableField(value = "CREATE_TIME")
	private Date createTime;
	@ApiModelProperty(value = "创建人")
	@JsonProperty("create_user")
	@TableField(value = "CREATE_USER")
	private String createUser;
	@ApiModelProperty(value = "更新时间")
	@JsonProperty("update_time")
	@TableField(value = "UPDATE_TIME")
	private Date updateTime;
	@ApiModelProperty(value = "更新人")
	@JsonProperty("update_user")
	@TableField(value = "UPDATE_USER")
	private String updateUser;
	@ApiModelProperty(value = "是否有效")
	@JsonProperty("valid")
	@TableField(value = "VALID")
	private String valid;
}
