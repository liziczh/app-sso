package com.liziczh.app.sso.api.condition;

import java.util.Date;

import com.liziczh.base.common.condition.BaseCondition;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserCondition extends BaseCondition {
	private static final long serialVersionUID = -7473402179827602416L;
	private Integer id;
	private String nickname;
	private String email;
	private String mobile;
	private String password;
	private String idName;
	private String idCard;
	private String address;
	private Date startTime;
	private Date endTime;
	private String valid;
}
