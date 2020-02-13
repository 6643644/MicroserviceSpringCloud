package com.springcloud.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

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
//@RestController
public class ConfigMain extends SpringBootServletInitializer {

    private static Class<ConfigMain> applicationClass = ConfigMain.class;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	return application.sources(applicationClass);
    }

    public static void main(String[] args) {
	SpringApplication.run(ConfigMain.class, args);
    }

    /**
     * 1.授權中心
     * 2. @Order 暫時不知道
     * 
     * 
     */
    @Configuration
    @EnableWebSecurity
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    protected static class webSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated().and().csrf().disable();
	}
    }

    /**
     * 1.這是授權中心，提供JWT認證
     * 
     * 
     * 
     */
    @Configuration
    @EnableAuthorizationServer
    protected static class OAuth2AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

	}

    }

}
