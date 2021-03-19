package com.liziczh.app.sso.internal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.internal.service.UserService;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.base.common.exception.BizInfoException;
import com.liziczh.base.common.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private TUserInfoMapper userInfoMapper;

	@Override
	public TUserInfo getUserByUsernameAndPassword(String username, String password) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getUsername, username).eq(TUserInfo::getPassword, DigestUtils.md5DigestAsHex(password));
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("用户不存在");
		}
		return userInfo;
	}
	@Override
	public TUserInfo getUserByMobileAndPassword(String mobile, String password) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getMobile, mobile).eq(TUserInfo::getPassword, DigestUtils.md5DigestAsHex(password));
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("用户不存在");
		}
		return userInfo;
	}
	@Override
	public TUserInfo getUserByEmailAndPassword(String email, String password) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getEmail, email).eq(TUserInfo::getPassword, DigestUtils.md5DigestAsHex(password));
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("用户不存在");
		}
		return userInfo;
	}
	@Override
	public TUserInfo getUserByMobile(String mobile) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getMobile, mobile);
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("用户不存在");
		}
		return userInfo;
	}
	@Override
	public TUserInfo getUserByEmail(String email) {
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().eq(TUserInfo::getEmail, email);
		TUserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
		if (userInfo == null) {
			throw new BizInfoException("用户不存在");
		}
		return userInfo;
	}
}
