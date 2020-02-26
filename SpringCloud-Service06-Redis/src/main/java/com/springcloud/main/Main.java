package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * 1. @EnableRedisHttpSession 代表啟動Redis HttpSession管理Session機制<br>
 * 2. 網站參考URL:https://tpu.thinkpower.com.tw/tpu/articleDetails/1525<br>
 * 
 * @author Miles
 *******************************************************************************************/
@ComponentScan(basePackages = { "com" })
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = { "com.springcloud" })
public class Main {

    public static void main(String[] args) {
	SpringApplication.run(Main.class, args);
    }
}
