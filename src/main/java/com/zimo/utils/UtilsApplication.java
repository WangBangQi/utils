package com.zimo.utils;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
@MapperScan("com.zimo.utils.mapper")
public class UtilsApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilsApplication.class, args);
	}
}
