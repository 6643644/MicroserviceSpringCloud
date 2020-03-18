package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * a. @EnableCaching 啟動Spring Cache
 * 
 * 
 * 
 * 
 * @author Miles
 *******************************************************************************************/
@ComponentScan(basePackages = { "com" })
@EnableFeignClients(basePackages = { "com.springcloud" })
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
public class MainAppliecation {

    public static void main(String[] args) {
	SpringApplication.run(MainAppliecation.class, args);
    }
    
    
}
