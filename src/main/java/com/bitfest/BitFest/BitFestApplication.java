package com.bitfest.BitFest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = "com.bitfest.BitFest")
public class BitFestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BitFestApplication.class, args);
	}

}
