package com.liziczh.app.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.sso.api.dto.user.UserLoginParam;
import com.liziczh.app.sso.api.dto.user.UserLogoutParam;
import com.liziczh.app.sso.api.dto.user.UserRegisterParam;
import com.liziczh.app.sso.api.service.UserService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/user/")
@RestController
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@ApiOperation(value = "register", notes = "注册")
	@GetMapping(value = "register")
	public Response<String> register(@RequestBody UserRegisterParam param) {
		String userId = userService.register(param);
		return new Response<String>().complete(userId);
	}
	@ApiOperation(value = "login", notes = "登录")
	@GetMapping(value = "login")
	public Response<String> login(@RequestBody UserLoginParam param) {
		String userId = userService.login(param.getUsername(), param.getPassword());
		return new Response<String>().complete(userId);
	}
	@ApiOperation(value = "logout", notes = "注销")
	@GetMapping(value = "logout")
	public Response<String> logout(@RequestBody UserLogoutParam param) {
		userService.logout(param.getUserId(), param.getToken());
		return new Response<String>().success();
	}
}
