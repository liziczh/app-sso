package com.liziczh.app.sso.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liziczh.app.sso.admin.service.DemoMgmService;
import com.liziczh.base.common.result.Result;
import com.liziczh.base.common.result.ResultBuilder;
import com.liziczh.base.common.service.BaseMgmService;
import com.liziczh.base.mvc.controller.BaseMgmController;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

-sso.api.condition.DemoCondition;
		-sso.api.entity.TDemo;

@Slf4j
@RequestMapping(value = "/demo/")
@RestController
public class DemoController extends BaseMgmController<TDemo, Integer, DemoCondition> {
	@Autowired
	private DemoMgmService demoMgmService;

	@Override
	public String getIndex() {
		return "modules/demo/demo.html";
	}
	@Override
	public BaseMgmService<TDemo, Integer, DemoCondition> getService() {
		return demoMgmService;
	}
	@ApiOperation(value = "分页条件查询", notes = "分页查询", tags = "v1.0.0")
	@RequestMapping(value = "selectByCondition", method = RequestMethod.POST)
	public Result<PageInfo<TDemo>> selectByCondition(@RequestBody DemoCondition condition) {
		PageHelper.startPage(condition.getPageCondition().getPageNum(), condition.getPageCondition().getPageSize());
		List<TDemo> demoList = demoMgmService.selectByCondition(condition);
		PageInfo<TDemo> pageInfo = new PageInfo<>(demoList);
		return new ResultBuilder<PageInfo<TDemo>>().complete(pageInfo);
	}
}
