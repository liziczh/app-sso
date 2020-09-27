package com.liziczh.app.sso.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liziczh.app.sso.api.entity.TDemo;

@Repository
@Mapper
public interface TDemoMapper extends BaseMapper<TDemo> {
}
