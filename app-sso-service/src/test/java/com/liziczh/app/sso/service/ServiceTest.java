package com.liziczh.app.sso.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liziczh.app.sso.api.common.Constants;
import com.liziczh.app.sso.api.condition.DemoCondition;
import com.liziczh.app.sso.api.service.DemoService;
import com.liziczh.app.sso.dao.DaoApplication;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringJUnitConfig(classes = { DaoApplication.class, ServiceApplication.class })
@SpringBootTest()
@ActiveProfiles("test")
@Slf4j
public class ServiceTest {
	@Autowired
	public DemoService demoService;

	@Test
	public void selectByConditionTest() throws Exception {
		DemoCondition condition = new DemoCondition();
		condition.setValid(Constants.COMMON_STATUS.VALID.getCode());
		demoService.selectByCondition(condition);
	}
	@Test
	public void getDemoTest() {
		try {
			demoService.getDemo(String.valueOf(1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
