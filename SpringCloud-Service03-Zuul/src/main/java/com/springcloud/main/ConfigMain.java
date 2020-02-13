package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * 該專案為Spring Cloud Zuul Server端<br>
 * 
 * 1. @ComponentScan 自動掃描 <br>
 * 2. @EnableDiscoveryClient<br>
 * 3. @EnableZuulProxy 開啟 Zuul Server端<br>
 * 3. @SpringBootApplication SprngBoot 啟動路口
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * @author Miles
 *******************************************************************************************/
@ComponentScan(basePackages = { "com.springcloud" })
@EnableDiscoveryClient
@EnableZuulProxy
@SpringBootApplication
public class ConfigMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }

}
