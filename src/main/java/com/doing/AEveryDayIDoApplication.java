package com.doing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.doing"})	// 扫描所有需要的包
@SpringBootApplication
public class AEveryDayIDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AEveryDayIDoApplication.class, args);
	}

}
