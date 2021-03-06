package com.liziczh.app.sso.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.app.sso.mybatisplus.MybatisPlusApplication;
import com.liziczh.app.sso.ref.RefApplication;

@SpringBootApplication(scanBasePackages = { "com.liziczh.*" })
public class ServiceApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { MybatisPlusApplication.class, RefApplication.class, ServiceApplication.class };
		SpringApplication.run(sources, args);
	}
}
