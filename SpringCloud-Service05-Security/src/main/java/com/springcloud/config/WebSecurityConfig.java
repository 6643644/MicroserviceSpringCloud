package com.springcloud.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer.UserDetailsBuilder;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.AuthorizedUrl;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/******************************************************************************************
 * 該專案為Spring Security 練習，並且搭配Spring Boot整合<br>
 * 
 * 1. @Configuration 代表這是一個Java Config 配置檔 <br>
 * 2. @EnableWebSecurity 啟動Spring Web Security 機制，使用了Spring Boot的時候 可以不需要使用EnableWebSecurity，原因在技術文件當中有說明<br>
 * 3. @EnableGlobalMethodSecurity 還沒研究<br>
 * 4. 繼承 WebSecurityConfigurerAdapter 啟用Spring Security 相關配置<br>
 * 
 * A 暫時還不知道Spring Security的運作原理，所以該專案先暫時把網路範例拿來使用<br>
 * B 參考URL:https://www.cnblogs.com/cjsblog/p/9152455.html<br>
 * C 參考URL:https://openhome.cc/Gossip/Spring/LoginOutForm.html<br>
 * D 參考URL:https://blog.csdn.net/u013435893/article/details/79596628<br>
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
     * 配置HTTP攔截器<br>
     * 1. HTTP攔截配置方式為所有reuqest都攔截，並且導入同一的登入畫面(spring預設的登入畫面)<br>
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

	/**
	 * 攔截ServletHttpRequest 需要使用到authorizeRequest方法，該方法幫我們產生Filter <br>
	 * 
	 */
	ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry expressionInterceptUrlRegistry = http
		.authorizeRequests();

	/**
	 * 攔截所有的request<br>
	 * 指定任何經過身份驗證的用戶都允許使用URL。<br>
	 */
	expressionInterceptUrlRegistry.anyRequest().authenticated();

	/**
	 * 如果要在繼續增加攔截攔截條件 要加上and()<br>
	 *
	 */
	HttpSecurity http2 = expressionInterceptUrlRegistry.and();

	/**
	 * 建立登入表單機制 <br>
	 * 如果沒有設定FormLoginConfigurer#loginPage(String)會跳到預設的登入頁面<br>
	 */
	FormLoginConfigurer<HttpSecurity> formLoginConfigurer = http2.formLogin();

	/**
	 * 如果要在繼續增加攔截攔截條件 要加上and()<br>
	 *
	 */
	HttpSecurity http3 = formLoginConfigurer.and();

	/**
	 * 提供註銷支持。 使用時會自動應用WebSecurityConfigurerAdapter<br>
	 * 默認是訪問URL"/logout" 將通過使HTTP會話無效來註銷用戶，清理所有<br>
	 * 已配置的 {@link #rememberMe（）} 身份驗證，清除了
	 * {@link SecurityContextHolder}，然後重定向到"/login?success"
	 */
	http3.logout();

	/**
	 * 以下簡短的配置 可以解釋為 只要是任何HttpServletRequest的URL都要做登入安全驗證，除了/test的URL之外
	 */
	//FormLoginConfigurer<HttpSecurity> formLoginConfigurer = http.authorizeRequests().antMatchers("/test")
	//.permitAll().anyRequest().authenticated().and().formLogin();

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
	super.configure(web);
    }

    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //	
    //
    //	
    //	
    //
    //	
    //    }

    //    /**
    //     * 基本配置方式(身分驗證管理器)
    //     * 1. 使用者的角色驗證與權限範圍 都存放在記憶體當中
    //     */
    //    //=============================================================================================================================================
    /**
     * 配置身分驗證管理器
     * 
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	/** 將驗證資訊存放在記憶體中 */
	InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryUserDetailsManagerConfigurer = auth
		.inMemoryAuthentication();

	/** 配置密碼的編碼方式 spring secutiry5 之後強制要求密碼需要進行編碼 我們使用Spring 官方推薦的加密演算法方法BCryptPasswordEncoder */
	PasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
	inMemoryUserDetailsManagerConfigurer.passwordEncoder(pwdEncoder);

	/** 建立使用者身分 */
	UserDetailsBuilder userDetailsBuilder = inMemoryUserDetailsManagerConfigurer.withUser("admin");

	/** 使用者的密碼，需要編碼 */
	userDetailsBuilder.password(pwdEncoder.encode("123456"));

	/** 使用者的權限 */
	userDetailsBuilder.roles("ADMIN", "MEMBER");

	/** 使用And 可以再產生另一個使用者身分 */
	UserDetailsManagerConfigurer userDetailsManagerConfigurer = userDetailsBuilder.and();

	UserDetailsBuilder userDetailsBuilder2 = userDetailsManagerConfigurer.withUser("caterpillar");

	userDetailsBuilder2.password(pwdEncoder.encode("12345678"));

	userDetailsBuilder2.roles("MEMBER");

	/** 可以再繼續and() ....and()... 多個身分 */

    }

    //=============================================================================================================================================

    //    @Autowired
    //    private UserServiceBasedPasswordEncoder userServiceBasedPasswordEncoder;

    //    /**
    //     * 基本配置方式(自定義身分驗證管理器 1)
    //     * 
    //     */
    //=============================================================================================================================================
    //    /**
    //     * 配置身分驗證管理器
    //     * 
    //     * @param auth
    //     * 
    //     */
    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //
    //	auth.userDetailsService(username -> {
    //	    System.out.println("username:" + username);
    //	    return new User(username, username + ":" + "123456",
    //		    Arrays.asList(new SimpleGrantedAuthority("ROLE_MEMBER")));
    //
    //	}).passwordEncoder(userServiceBasedPasswordEncoder);
    //    }

    //==============================================================================================================================================

    //    @Autowired
    //    private TestUserDetailService testUserDetailService;

    //    /**
    //     * 基本配置方式(自定義身分驗證管理器 2 自行實作UserDetailsService)
    //     *
    //     */
    //=============================================================================================================================================
    //    /**
    //     * 配置身分驗證管理器
    //     * 
    //     */
    //    @Override
    //    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //
    //	//	auth.userDetailsService(username -> {
    //	//	    System.out.println("username:" + username);
    //	//	    return new User(username, username + ":" + "123456",
    //	//		    Arrays.asList(new SimpleGrantedAuthority("ROLE_MEMBER")));
    //	//
    //	//	}).passwordEncoder(userServiceBasedPasswordEncoder);
    //
    //	auth.userDetailsService(testUserDetailService).passwordEncoder(userServiceBasedPasswordEncoder);
    //
    //    }
    //=============================================================================================================================================

    //    @Component
    //    public static class TestUserDetailService implements UserDetailsService {
    //
    //	@Override
    //	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //
    //	    return new CustomUser(username);
    //	}
    //
    //	public class CustomUser implements UserDetails {
    //
    //	    private String username;
    //
    //	    private String password;
    //
    //	    private boolean enabled = true;
    //
    //	    public CustomUser(String username) {
    //		super();
    //		this.username = username;
    //	    }
    //
    //	    @Override
    //	    public Collection<? extends GrantedAuthority> getAuthorities() {
    //		List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_MEMBER"));
    //
    //		return authorities;
    //	    }
    //
    //	    @Override
    //	    public boolean isAccountNonExpired() {
    //		return true;
    //	    }
    //
    //	    @Override
    //	    public boolean isAccountNonLocked() {
    //		// we never lock accounts
    //		return true;
    //	    }
    //
    //	    @Override
    //	    public boolean isCredentialsNonExpired() {
    //		// credentials never expire
    //		return true;
    //	    }
    //
    //	    @Override
    //	    public boolean isEnabled() {
    //		return enabled;
    //	    }
    //
    //	    @Override
    //	    public String getPassword() {
    //		// Not going to save user pw
    //		return "";
    //	    }
    //
    //	    @Override
    //	    public String getUsername() {
    //		return username;
    //	    }
    //	}
    //
    //    }
    //
    //    @Component
    //    public static class UserServiceBasedPasswordEncoder implements PasswordEncoder {
    //
    //	@Override
    //	public String encode(CharSequence rawPassword) {
    //	    // 不用編碼，因為後續實際上會使用 UserService 的 encryptedPassword 方法
    //	    return rawPassword.toString();
    //	}
    //
    //	@Override
    //	public boolean matches(CharSequence rawPassword, String encodedPassword) {
    //	    System.out.println("encodedPassword:" + encodedPassword);
    //	    String[] namePassword = encodedPassword.split(":");
    //	    //	    String name = namePassword[0];
    //	    String password = namePassword[1];
    //	    //假設有撈取DB並且符合密碼123456
    //	    System.out.println("password:" + password);
    //	    return StringUtils.equals("123456", password);
    //	}
    //
    //    }

    //======================================================================================================================================
    //    /**
    //     * 配置HTTP攔截器<br>
    //     * 1. HTTP攔截配置方式為所有reuqest都攔截，並且導入同一的登入畫面(spring預設的登入畫面)<br>
    //     * 
    //     */
    //    @Override
    //    protected void configure(HttpSecurity http) throws Exception {
    //
    //	// 防止 CSRF攻擊，中文名稱:跨站請求偽造 ，也被稱為:one click attack/session
    //	// riding,縮寫為:CSRF/XSRF。
    //	//	http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();
    //
    //	http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic().and().logout().and()
    //		.httpBasic();
    //    }

}
