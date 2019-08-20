package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Miles
 * 
 * 這個Service 我們把它當作所有前端request的入口，然後如果取得DB資訊則呼叫SpringCloud-Server2
 * 
 * 1. @ComponentScan 自動掃描 
 * 2. @EnableDiscoveryClient 註冊 eureka 客戶端
 * 3. @EnableFeignClients 開啟Feign 聲明式Web Service客戶端
 * 4. @SpringBootApplication SprngBoot 啟動路口 
 * 5. @EnableJpaRepositories 開啟JPA Repositories 6. @EntityScan 自動掃描Entity
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。
 * 
 */
@ComponentScan(basePackages = { "com.example" })
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.example.repository" })
@EntityScan(basePackages = { "com.example.entity" })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

}
