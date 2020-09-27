package com.liziczh.app.sso.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.app.sso.mybatisplus.MybatisPlusApplication;
import com.liziczh.app.sso.ref.RefApplication;

@SpringBootApplication
public class MgmApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { MybatisPlusApplication.class, MgmApplication.class, RefApplication.class };
		SpringApplication.run(sources, args);
	}
}
