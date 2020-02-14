package com.springcloud.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/******************************************************************************************
 * Spring Cloud 的OAuth Server<br>
 * 
 * @author Miles
 *******************************************************************************************/
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

}
