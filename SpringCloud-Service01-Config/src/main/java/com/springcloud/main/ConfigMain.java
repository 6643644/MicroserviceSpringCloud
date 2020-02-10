package com.springcloud.main;

import javax.servlet.Filter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

import com.springcloud.filter.TimeConsumingCalculationFilter;

/******************************************************************************************
 * Spring Cloud 的Config Server<br>
 * 
 * 1. @ComponentScan 自動掃描<br>
 * 2. @SpringBootApplication SprngBoot 啟動路口<br>
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * 繼承 SpringBootServletInitializer 使用非嵌入式容器需打包成War檔。 <br>
 * 實作 WebApplicationInitializer (SpringBootServletInitializer已經實作了該介面)
 * 
 * @author Miles
 *******************************************************************************************/
@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
@Configuration
public class ConfigMain extends SpringBootServletInitializer implements WebApplicationInitializer {

    private static Class<ConfigMain> applicationClass = ConfigMain.class;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(applicationClass);
    }

    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }

    @Bean
    public Filter filter1() {
	return new TimeConsumingCalculationFilter();
    }
    
//    @Bean
//    public Filter filter2() {
//        return new TimeConsumingCalculationFilter2();
//    }
}
