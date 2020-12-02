package com.liziczh.app.sso.admin.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liziczh.app.sso.admin.service.UserInfoService;
import com.liziczh.app.sso.api.common.Constants;
import com.liziczh.app.sso.api.condition.UserCondition;
import com.liziczh.app.sso.api.entity.TUserInfo;
import com.liziczh.app.sso.mybatisplus.mapper.TUserInfoMapper;
import com.liziczh.base.common.condition.PageCondition;
import com.liziczh.base.common.condition.SortCondition;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	private TUserInfoMapper tUserInfoMapper;

	@Override
	public List<TUserInfo> selectByCondition(UserCondition condition) {
		PageCondition pageCondition = condition.getPageCondition();
		List<SortCondition> sortConditionList = condition.getSortConditionList();
		QueryWrapper<TUserInfo> queryWrapper = new QueryWrapper<>();
		queryWrapper.lambda().like(TUserInfo::getNickname, condition.getNickname()).lt(TUserInfo::getCreateTime, new Date()).eq(TUserInfo::getValid, Constants.COMMON_STATUS.VALID.getCode());
		for (SortCondition sortCondition : sortConditionList) {
			queryWrapper.orderByDesc(sortCondition.getColumnName());
		}
		Page<TUserInfo> demoPage = tUserInfoMapper.selectPage(new Page<>(pageCondition.getPageNum(), pageCondition.getPageSize()), queryWrapper);
		return demoPage.getRecords();
	}
	@Override
	public List<TUserInfo> getAll() {
		return tUserInfoMapper.selectList(new QueryWrapper<>());
	}
	@Override
	public void addItem(TUserInfo entity) {
		entity.setCreateTime(new Date());
		entity.setCreateUser(Constants.SYS_USER);
		entity.setValid(Constants.COMMON_STATUS.VALID.getCode());
		tUserInfoMapper.insert(entity);
	}
	@Override
	public void updateItem(TUserInfo entity) {
		entity.setUpdateTime(new Date());
		entity.setUpdateUser(Constants.SYS_USER);
		tUserInfoMapper.updateById(entity);
	}
	@Override
	public TUserInfo get(Integer id) {
		return tUserInfoMapper.selectById(id);
	}
	@Override
	public void delete(Integer id) {
		tUserInfoMapper.deleteById(id);
	}
}
