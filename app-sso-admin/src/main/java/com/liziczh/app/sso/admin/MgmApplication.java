package com.liziczh.app.sso.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

-sso.dao.DaoApplication;-sso.ref.RefApplication;

@SpringBootApplication
public class MgmApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { DaoApplication.class, MgmApplication.class, RefApplication.class };
		SpringApplication.run(sources, args);
	}
}
