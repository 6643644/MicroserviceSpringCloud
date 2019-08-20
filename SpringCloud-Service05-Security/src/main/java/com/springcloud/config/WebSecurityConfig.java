package com.springcloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/******************************************************************************************
 * @author Miles
 * 
 * 
 *         暫時還不知道Spring Security的運作原理，所以該專案先暫時把網路範例拿來使用
 * 
 *         該專案為Spring Security 練習，並且搭配Spring Boot整合 1. @Configuration 代表這是一個Java
 *         Config 配置檔 2. @EnableWebSecurity 啟動Spring Web Security 機制
 *         3. @EnableGlobalMethodSecurity 還沒研究
 * 
 *
 *         參考URL:https://www.cnblogs.com/cjsblog/p/9152455.html
 *
 *******************************************************************************************/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) // 啟動Security註解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 防止 CSRF攻擊，中文名稱:跨站請求偽造 ，也被稱為:one click attack/session
		// riding,縮寫為:CSRF/XSRF。
		http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();

		// 允許所有用戶訪問"/"與"/test"
		http.authorizeRequests().antMatchers("/test").permitAll()

				.anyRequest().authenticated().and().formLogin()

				.loginPage("/aaaa")

				.defaultSuccessUrl("/welcome").permitAll().and().logout().logoutUrl("/logout")

				.logoutSuccessUrl("/login").permitAll();

	}

	// 暫時不知道這段的目的是什麼
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}
}
