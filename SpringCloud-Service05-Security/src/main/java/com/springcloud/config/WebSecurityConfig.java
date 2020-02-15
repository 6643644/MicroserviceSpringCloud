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
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/******************************************************************************************
 * 該專案為Spring Security 練習，並且搭配Spring Boot整合<br>
 * 
 * 1. @Configuration 代表這是一個Java Config 配置檔 <br>
 * 2. @EnableWebSecurity 啟動Spring Web Security 機制<br>
 * 3. @EnableGlobalMethodSecurity 還沒研究<br>
 * 
 * 暫時還不知道Spring Security的運作原理，所以該專案先暫時把網路範例拿來使用<br>
 * 參考URL:https://www.cnblogs.com/cjsblog/p/9152455.html<br>
 * 參考URL:https://openhome.cc/Gossip/Spring/LoginOutForm.html<br>
 * 
 * @author Miles
 * 
 *******************************************************************************************/
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true) // 啟動Security註解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 基本配置方式(身分驗證管理器)
     * 1. 使用者的角色驗證與權限範圍 都存放在記憶體當中
     */
    //=============================================================================================================================================
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
    /**
     * 配置HTTP攔截器<br>
     * 1. HTTP攔截配置方式為所有reuqest都攔截，並且導入同一的登入畫面(spring預設的登入畫面)<br>
     * 
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

	// 防止 CSRF攻擊，中文名稱:跨站請求偽造 ，也被稱為:one click attack/session
	// riding,縮寫為:CSRF/XSRF。
	//	http.authorizeRequests().anyRequest().authenticated().and().csrf().disable();

	http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic().and().logout().and()
		.httpBasic();
    }

}
