package com.milagro.springmoneytransferservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestSpringMoneyTransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(SpringMoneyTransferServiceApplication::main).with(TestSpringMoneyTransferServiceApplication.class).run(args);
	}

}
