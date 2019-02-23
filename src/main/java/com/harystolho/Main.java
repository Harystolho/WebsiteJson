package com.harystolho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class Main {

	static {
		System.setProperty("user.timezone", "UTC");
		System.out.println("USE TDD");
	}
	
	public static void main(String[] args) {
		AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication.run(Main.class, args);
		ctx.registerShutdownHook();
	}

}
