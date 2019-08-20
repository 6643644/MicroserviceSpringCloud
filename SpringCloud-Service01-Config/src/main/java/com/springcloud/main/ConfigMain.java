package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * @author Miles    
 *  
 * SpringBoot 的入口:        
 * 1. @ComponentScan 自動掃描       
 * 2. @SpringBootApplication SprngBoot 啟動路口      
 *    
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。
 * 注意:建立了.gitignore檔案可以排除不需要push的檔案 (參考:https://www.cnblogs.com/kevingrace/p/5690241.html) 後續會加入筆記中
 * 
 *******************************************************************************************/
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com.springcloud" })
public class ConfigMain {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMain.class, args);
	}
}
