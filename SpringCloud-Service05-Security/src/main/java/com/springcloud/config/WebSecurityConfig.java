package com.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;

import com.springcloud.service.SecurityUserDetailsService;

/******************************************************************************************
 * 該專案為Spring Security 練習，並且搭配Spring Boot整合<br>
 * 
 * 1. @Configuration 代表這是一個Java Config 配置檔 <br>
 * 2. @EnableWebSecurity 啟動Spring Web Security 機制，使用了Spring Boot的時候 可以不需要使用EnableWebSecurity，原因在技術文件當中有說明<br>
 * 3. @EnableGlobalMethodSecurity 還沒研究<br>
 * 4. 繼承 WebSecurityConfigurerAdapter 啟用Spring Security 相關配置<br>
 * 
 * E 運作原理可以參考 URL:https://www.jianshu.com/p/0c54788c94f3<br>
 * F 運作原理可以參考2 URL:https://www.jianshu.com/p/4fcdcf677371<br>
 * 
 * 
 * @author Miles
 * 
 *******************************************************************************************/
//@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 啟動Security註解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 1. 配置HTTP攔截器<br>
     * 2. HTTP攔截配置方式為所有reuqest都攔截，並且導入同一的登入畫面(spring預設的登入畫面)<br>
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

	/**
	 * 1. 攔截ServletHttpRequest 需要使用到authorizeRequest方法，該方法幫我們產生Filter <br>
	 */
	ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http
		.authorizeRequests();

	/**
	 * 1. 攔截所有的request<br>
	 * 2. 指定任何經過身份驗證的用戶都允許使用URL。<br>
	 */
	expressionInterceptUrlRegistry.anyRequest().authenticated();

	/**
	 * 1. 如果要在繼續增加攔截攔截條件 要加上and()<br>
	 */
	HttpSecurity http2 = expressionInterceptUrlRegistry.and();

	/**
	 * 1. 建立登入表單機制 <br>
	 * 2. 如果沒有設定FormLoginConfigurer#loginPage(String)會跳到預設的登入頁面<br>
	 */
	FormLoginConfigurer<HttpSecurity> formLoginConfigurer = http2.formLogin();

	/**
	 * 1. 如果要在繼續增加攔截攔截條件 要加上and()<br>
	 */
	HttpSecurity http3 = formLoginConfigurer.and();

	/**
	 * 1. 提供註銷支持。 使用時會自動應用WebSecurityConfigurerAdapter<br>
	 * 2. 默認是訪問URL"/logout" 將通過使HTTP會話無效來註銷用戶，清理所有<br>
	 * 3. 已配置的 {@link #rememberMe（）} 身份驗證，清除了 {@link SecurityContextHolder}，然後重定向到"/login?success"
	 */
	http3.logout();

	/**
	 * 1.以下簡短的配置 可以解釋為 只要是任何HttpServletRequest的URL都要做登入安全驗證，除了/test的URL之外
	 */
	//FormLoginConfigurer<HttpSecurity> formLoginConfigurer = http.authorizeRequests().antMatchers("/test")
	//.permitAll().anyRequest().authenticated().and().formLogin();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	super.configure(web);
    }

    @Autowired
    private SecurityUserDetailsService securityUserDetailsService;

    /**
     * 1. 配置身分驗證管理器
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	// 使用inMemoryAuthentication方法
	//	auth.inMemoryAuthentication()
	//		.withUser("user") //新增帳號
	//		.password("{noop}123456") // 新增密碼
	//		.roles("amdin"); // 新增權限

	//	UserDetails userDetail = User.builder().username("aaa").password("{noop}123456").roles("admin").build();
	//	auth.inMemoryAuthentication().withUser(userDetail);

	// 使用authenticationProvider方法
	DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
	authenticationProvider.setUserDetailsService(securityUserDetailsService);
	auth.authenticationProvider(authenticationProvider);

	/** 使用載入 userDetailsSerive */
	//	auth.userDetailsService(securityUserDetailsService);

    }

}
