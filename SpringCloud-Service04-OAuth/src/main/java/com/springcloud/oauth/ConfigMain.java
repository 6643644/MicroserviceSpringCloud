package com.springcloud.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

/******************************************************************************************
 * Spring Cloud 的OAuth Server<br>
 * 
 * 1. @ComponentScan 自動掃描<br>
 * 2. @SpringBootApplication SprngBoot 啟動路口<br>
 * 3. @EnableDiscoveryClient 註冊 Eureka 發現 <br>
 * 
 * 注意:如果SpringBootAppliction的路口放在某個目錄底下，當我們啟動SpringBoot並且掃描Bean的產生時，只會掃描路口所屬的路徑底下。<br>
 * 
 * @author Miles
 *******************************************************************************************/
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class ConfigMain {
    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }

    //    @Autowired
    //    private PasswordEncoder passwordEncoder;
    //
    //    @Bean
    //    public AuthorizationServerConfigurerAdapter authorizationServerConfigurer() {
    //	return new AuthorizationServerConfigurerAdapter() {
    //
    //	    @Override
    //	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    //		
    //		ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder> builder = clients.inMemory();
    //		
    //		
    //		
    //		
    //		clients.inMemory().withClient("webclient").secret(passwordEncoder.encode("webclient12345678"))
    //			.scopes("account", "message", "email").resourceIds("resource")
    //			.authorizedGrantTypes("client_credentials");
    //	    }
    //
    //	    @Override
    //	    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    //		oauthServer.checkTokenAccess("isAuthenticated()");
    //	    }
    //	};
    //    }
    //
    //    @Bean
    //    public PasswordEncoder passwordEncoder() {
    //	return new BCryptPasswordEncoder();
    //    }

}
