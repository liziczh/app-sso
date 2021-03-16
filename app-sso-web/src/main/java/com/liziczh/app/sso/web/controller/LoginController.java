package com.liziczh.app.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.sso.api.dto.user.param.LoginParam;
import com.liziczh.app.sso.api.dto.user.param.RegisterParam;
import com.liziczh.app.sso.api.service.LoginBySessionService;
import com.liziczh.app.sso.api.service.RegisterService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/user/")
@RestController
public class LoginController extends BaseController {
	@Autowired
	private RegisterService registerService;
	@Autowired
	private LoginBySessionService loginBySessionService;

	@ApiOperation(value = "register", notes = "注册")
	@GetMapping(value = "register")
	public Response<String> register(@RequestBody RegisterParam param) {
		String userId = registerService.register(param);
		return new Response<String>().complete(userId);
	}
	@ApiOperation(value = "login", notes = "登录")
	@GetMapping(value = "login")
	public Response<String> login(@RequestBody LoginParam param) {
		String sessionId = loginBySessionService.login(param.getUsername(), param.getPassword(), param.isIfRemember());
		return new Response<String>().complete(sessionId);
	}
	@ApiOperation(value = "logout", notes = "注销")
	@GetMapping(value = "logout")
	public Response<String> logout() {
		loginBySessionService.logout();
		return new Response<String>().success();
	}
}
