package com.liziczh.app.sso.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.user.UserRegisterParam;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.UserService;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserInfoMapper tUserInfoMapper;

	@Override
	public String register(UserRegisterParam param) {
		// TODO 校验参数
		// 注册用户
		TUserInfo userInfo = new TUserInfo();
		userInfo.setNickname(param.getNickname());
		userInfo.setGender(param.getGender());
		userInfo.setEmail(param.getEmail());
		userInfo.setMobile(param.getMobile());
		userInfo.setPassword(param.getPassword());
		tUserInfoMapper.insert(userInfo);
		return null;
	}
	@Override
	public String login(String username, String password) {
		return null;
	}
	@Override
	public void logout(String userId, String token) {
	}
}
