package com.springcloud.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/******************************************************************************************
 * @author Miles
 * 
 * 
 * 
 * 
 * 
 *******************************************************************************************/
@ComponentScan(basePackages = { "com.springcloud" })
@EnableDiscoveryClient
@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	// @Bean
	// public EmbeddedServletContainerFactory servletContainer() {
	// TomcatEmbeddedServletContainerFactory tomcat = new
	// TomcatEmbeddedServletContainerFactory();
	// tomcat.setPort(9082); //設定port
	// tomcat.setBaseDirectory(new File("C:/Spring Cloud Tomcat")); //設定日誌存放位置
	// // tomcat.setUriEncoding("UTF-8"); //如果沒設定語系則預設UTF-8
	//
	// return tomcat;
	// }

}
