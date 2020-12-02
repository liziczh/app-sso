package com.liziczh.app.sso.admin.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.sso.admin.service.UserInfoService;
import com.liziczh.app.sso.api.condition.UserCondition;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.base.common.service.BaseMgmService;
import com.liziczh.base.mvc.controller.BaseMgmController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(value = "/userInfo/")
@RestController
public class UserInfoController extends BaseMgmController<TUserInfo, Integer, UserCondition> {
	@Autowired
	private UserInfoService userInfoService;

	@Override
	public String getIndex() {
		return "modules/userInfo/userInfo.html";
	}
	@Override
	public BaseMgmService<TUserInfo, Integer, UserCondition> getService() {
		return userInfoService;
	}
}
