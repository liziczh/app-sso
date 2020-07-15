package com.liziczh.archetype.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.liziczh.archetype.dao.DaoApplication;
import com.liziczh.archetype.ref.RefApplication;

@SpringBootApplication
public class MgmApplication {
	public static void main(String[] args) {
		Class<?>[] sources = new Class<?>[] { DaoApplication.class, MgmApplication.class, RefApplication.class };
		SpringApplication.run(sources, args);
	}
}
