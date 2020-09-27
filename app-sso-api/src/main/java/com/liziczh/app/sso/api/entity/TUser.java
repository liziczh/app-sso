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
public class TUser extends BaseEntity {
	private static final long serialVersionUID = -3399850105386695874L;
	@ApiModelProperty(value = "ID")
	@JsonProperty("id")
	@TableId(value = "ID", type = IdType.AUTO)
	private Integer id;
	@ApiModelProperty(value = "姓名")
	@JsonProperty("name")
	@TableField(value = "NAME")
	private String name;
	@ApiModelProperty(value = "邮箱")
	@JsonProperty("email")
	@TableField(value = "EMAIL")
	private String email;
	@ApiModelProperty(value = "手机号")
	@JsonProperty("mobile")
	@TableField(value = "MOBILE")
	private String mobile;
	@ApiModelProperty(value = "证件号")
	@JsonProperty("idCard")
	@TableField(value = "ID_CARD")
	private String idCard;
	@ApiModelProperty(value = "详细地址")
	@JsonProperty("address")
	@TableField(value = "ADDRESS")
	private String address;
	@ApiModelProperty(value = "创建时间")
	@JsonProperty("create_time")
	@TableField("CREATE_TIME")
	private Date createTime;
	@ApiModelProperty(value = "创建人")
	@JsonProperty("create_user")
	@TableField("CREATE_USER")
	private String createUser;
	@ApiModelProperty(value = "更新时间")
	@JsonProperty("update_time")
	@TableField("UPDATE_TIME")
	private Date updateTime;
	@ApiModelProperty(value = "更新人")
	@JsonProperty("update_user")
	@TableField("UPDATE_USER")
	private String updateUser;
	@ApiModelProperty(value = "权限角色")
	@JsonProperty("permit_role")
	@TableField("PERMIT_ROLE")
	private String permitRole;
	@ApiModelProperty(value = "是否有效")
	@JsonProperty("valid")
	@TableField("VALID")
	private String valid;
}
