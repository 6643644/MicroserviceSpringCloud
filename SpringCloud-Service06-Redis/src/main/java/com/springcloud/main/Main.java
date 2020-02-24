package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * @EnableRedisHttpSession 代表啟動Redis HttpSession管理Session機制
 * 
 * a. 網站參考URL:https://tpu.thinkpower.com.tw/tpu/articleDetails/1525
 * 
 * @author Miles
 *******************************************************************************************/
@ComponentScan(basePackages = { "com.springcloud" })
@EnableDiscoveryClient
@EnableFeignClients(basePackages = { "com.springcloud" })
@SpringBootApplication
//@EnableRedisHttpSession
public class Main {

    public static void main(String[] args) {
	SpringApplication.run(Main.class, args);
    }
}
