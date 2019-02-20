package com.harystolho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = (AbstractApplicationContext) SpringApplication.run(Main.class, args);
	}

}
