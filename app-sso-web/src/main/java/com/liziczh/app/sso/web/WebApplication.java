package com.liziczh.app.sso.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.app.sso.dao.DaoApplication;
import com.liziczh.app.sso.ref.RefApplication;
import com.liziczh.app.sso.service.ServiceApplication;

@SpringBootApplication(scanBasePackages = { "com.liziczh.*" })
public class WebApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { DaoApplication.class, ServiceApplication.class, RefApplication.class, WebApplication.class };
		SpringApplication.run(sources, args);
	}
}
