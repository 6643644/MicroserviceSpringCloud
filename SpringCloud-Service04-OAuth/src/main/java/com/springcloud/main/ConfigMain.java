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
 * a.注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * b.參考關於OAuth 產生的URL: https://x8795278.blogspot.com/2019/12/spring-boot-spring-security-rest-api.html<br>
 * 
 * @author Miles
 *******************************************************************************************/
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class ConfigMain {

    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }

}
