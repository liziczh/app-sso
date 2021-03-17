package com.liziczh.app.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.sso.api.dto.user.param.RegisterParam;
import com.liziczh.app.sso.api.service.RegisterService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户接口", tags = "示例接口")
@RequestMapping(value = "/user/")
@RestController
public class UserController extends BaseController {
	@Autowired
	private RegisterService registerService;

	@ApiOperation(value = "register", notes = "注册")
	@GetMapping(value = "register")
	public Response<String> register(@RequestBody RegisterParam param) {
		String userId = registerService.register(param);
		return new Response<String>().complete(userId);
	}
}
