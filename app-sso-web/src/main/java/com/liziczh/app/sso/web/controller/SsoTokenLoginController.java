package com.liziczh.app.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liziczh.app.sso.api.dto.user.param.LoginDTO;
import com.liziczh.app.sso.api.service.SsoTokenLoginService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/token/")
@Controller
public class SsoTokenLoginController extends BaseController {
	@Autowired
	private SsoTokenLoginService ssoTokenLoginService;

	@ApiOperation(value = "login", notes = "登录")
	@PostMapping(value = "login")
	public String login(@RequestBody LoginDTO param, @RequestParam String appKey, @RequestParam String redirectUrl) {
		String token = ssoTokenLoginService.login(param, appKey);
		return;
	}
	@ApiOperation(value = "authorize", notes = "认证")
	@PostMapping(value = "authorize")
	public Response<String> authorize(@RequestParam String token, @RequestParam String appKey, @RequestParam String redirectUrl) {
		ssoTokenLoginService.doAuthentication(token, appKey);
		return new Response<String>().complete(token);
	}
	@ApiOperation(value = "logout", notes = "注销")
	@GetMapping(value = "logout")
	public Response<String> logout(@RequestParam String appKey, @RequestParam String token) {
		ssoTokenLoginService.logout(token);
		return new Response<String>().success();
	}
	private String redirectUrl(String redirectUrl) {
	}
}
