package com.springcloud.oauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;

/******************************************************************************************
 * 存放使用者資源的伺服器
 * 
 * https://openhome.cc/Gossip/Spring/OAuth2ClientGrant1.html
 * https://tpu.thinkpower.com.tw/tpu/articleDetails/957
 * 
 * 
 * @author Miles
 *******************************************************************************************/
@EnableResourceServer
@Configuration
public class OAuthresourceServerConfigure extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
	http.authorizeRequests().antMatchers("/hello").access("#oauth2.hasAnyScope('account', 'message', 'email')");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
	resources.resourceId("resource");
    }

}
