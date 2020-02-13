package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * 該專案為Spring Cloud Eureka Server端 <br>
 * 
 * 1. @ComponentScan 自動掃描<br>
 * 2. @EnableEurekaServer 開啟 Eureka Server端<br>
 * 3. @SpringBootApplication SprngBoot 啟動路口<br>
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * 順便測試 高可用性<br>
 * C:\Windows\System32\drivers\etc\hosts 修改內容如下:<br>
 * 
 * @author Miles
 * 
 *******************************************************************************************/
@ComponentScan(basePackages = { "com.springcloud" })
@EnableEurekaServer
@SpringBootApplication
public class ConfigMain extends SpringBootServletInitializer {

    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }
}
