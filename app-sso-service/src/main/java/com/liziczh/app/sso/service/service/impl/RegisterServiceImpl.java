package com.liziczh.app.sso.service.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liziczh.app.sso.api.dto.user.param.RegisterParam;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.api.service.RegisterService;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.base.common.util.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 用户服务
 * @author zhehao.chen
 */
@Slf4j
@Service
public class RegisterServiceImpl implements RegisterService {
	@Autowired
	private TUserInfoMapper tUserInfoMapper;

	@Override
	public String register(RegisterParam param) {
		// TODO 校验参数
		// 注册用户
		TUserInfo userInfo = new TUserInfo();
		userInfo.setUsername(param.getUsername());
		userInfo.setPassword(DigestUtils.md5DigestAsHex(param.getPassword()));
		userInfo.setEmail(param.getEmail());
		userInfo.setMobile(param.getMobile());
		userInfo.setNickname(param.getNickname());
		userInfo.setGender(param.getGender());
		userInfo.setBirthday(param.getBirthday());
		userInfo.setCreateTime(new Date());
		userInfo.setCreateUser(param.getUsername());
		return String.valueOf(tUserInfoMapper.insert(userInfo));
	}
}
