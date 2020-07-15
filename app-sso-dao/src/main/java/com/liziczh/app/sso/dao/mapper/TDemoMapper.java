package com.liziczh.app.sso.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.liziczh.app.sso.api.condition.DemoCondition;
import com.liziczh.app.sso.api.entity.TDemo;
import com.liziczh.base.common.repository.BaseRepository;

@Repository
@Mapper
public interface TDemoMapper extends BaseRepository<TDemo, Integer, DemoCondition> {
}
