package com.liziczh.app.sso.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.liziczh.app.sso.api.dto.user.param.LoginDTO;
import com.liziczh.app.sso.api.service.SsoCookieLoginService;
import com.liziczh.base.common.controller.BaseController;
import com.liziczh.base.common.response.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author zhehao.chen
 */
@Api(value = "示例接口", tags = "示例接口")
@RequestMapping(value = "/cookie/")
@RestController
public class SsoCookieLoginController extends BaseController {
	@Autowired
	private SsoCookieLoginService ssoCookieLoginService;

	@ApiOperation(value = "login", notes = "登录")
	@PostMapping(value = "login")
	public Response<String> login(@RequestBody LoginDTO param) {
		String sessionId = ssoCookieLoginService.login(param);
		return new Response<String>().complete(sessionId);
	}
	@ApiOperation(value = "logout", notes = "注销")
	@GetMapping(value = "logout")
	public Response<String> logout() {
		ssoCookieLoginService.logout();
		return new Response<String>().success();
	}
}
