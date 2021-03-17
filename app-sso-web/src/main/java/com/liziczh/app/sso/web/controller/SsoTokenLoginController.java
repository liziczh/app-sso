package com.liziczh.app.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.sso.api.dto.user.param.LoginParam;
import com.liziczh.app.sso.api.service.SsoTokenLoginService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/token/")
@RestController
public class SsoTokenLoginController extends BaseController {
	@Autowired
	private SsoTokenLoginService ssoTokenLoginService;

	@ApiOperation(value = "login", notes = "登录")
	@GetMapping(value = "login")
	public Response<String> login(@RequestBody LoginParam param) {
		String sessionId = ssoTokenLoginService.login(param.getUsername(), param.getPassword());
		return new Response<String>().complete(sessionId);
	}
	@ApiOperation(value = "logout", notes = "注销")
	@GetMapping(value = "logout")
	public Response<String> logout() {
		String token = "";
		ssoTokenLoginService.logout(token);
		return new Response<String>().success();
	}
}
