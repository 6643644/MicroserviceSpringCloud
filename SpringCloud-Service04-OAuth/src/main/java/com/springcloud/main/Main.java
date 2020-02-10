package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * Spring Cloud 的OAuth Server<br>
 * 
 * 1. @ComponentScan 自動掃描<br>
 * 2. @SpringBootApplication SprngBoot 啟動路口<br>
 * 3. @EnableDiscoveryClient 註冊 Eureka 發現 <br>
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * @author Miles
 *******************************************************************************************/
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class Main {
    public static void main(String[] args) {
	SpringApplication.run(Main.class, args);
    }
}
