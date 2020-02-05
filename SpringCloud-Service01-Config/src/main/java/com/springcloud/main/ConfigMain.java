package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * Spring Cloud 的Config Server<br>
 * 
 * 1. @ComponentScan 自動掃描<br>
 * 2. @SpringBootApplication SprngBoot 啟動路口<br>
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * @author Miles
 *******************************************************************************************/
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class ConfigMain {

    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }
}
