package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * @author Miles
 * 
 * 該專案為Spring Cloud Eureka Server端     
 * 
 * 1. @ComponentScan 自動掃描
 * 2. @EnableEurekaServer 開啟 Eureka Server端
 * 3. @SpringBootApplication SprngBoot 啟動路口   
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。
 * 
 * 順便測試 高可用性
 * C:\Windows\System32\drivers\etc\hosts 修改內容如下:
 * 
 * 
 *******************************************************************************************/
@ComponentScan(basePackages = { "com.springcloud" })
@EnableEurekaServer
@SpringBootApplication
public class ConfigMain {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMain.class, args);
	}
}
