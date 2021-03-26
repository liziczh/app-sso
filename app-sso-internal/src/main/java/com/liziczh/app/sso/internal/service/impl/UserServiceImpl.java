package com.liziczh.app.sso.internal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.internal.service.UserService;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.base.common.exception.BizInfoException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserInfoMapper userInfoMapper;

	@Override
	public TUserInfo getUserByUsername(String username) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getUsername, username);
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("400", "用户不存在");
		}
		return userInfo;
	}
	@Override
	public TUserInfo getUserByMobile(String mobile) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getMobile, mobile);
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("400", "用户不存在");
		}
		return userInfo;
	}
	@Override
	public TUserInfo getUserByEmail(String email) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getEmail, email);
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("400", "用户不存在");
		}
		return userInfo;
	}
}
