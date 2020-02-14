package com.springcloud.oauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.builders.ClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/******************************************************************************************
 * 認證resource owner，成功後回覆Token的伺服器。
 * https://openhome.cc/Gossip/Spring/JWT.html
 * 
 * @author Miles
 *******************************************************************************************/
@EnableAuthorizationServer
@Configuration
public class OAuthAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

	/** 將Client資訊存放在記憶體中 */
	ClientDetailsServiceBuilder<InMemoryClientDetailsServiceBuilder> builder = clients.inMemory();

	builder.withClient("webclient").secret(passwordEncoder.encode("webclient12345678"))
		.scopes("account", "message", "email").resourceIds("resource")
		.authorizedGrantTypes("client_credentials");

    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	//	endpoints.accessTokenConverter(accessTokenConverter()).authenticationManager(authenticationManager)
	//		.userDetailsService(webSecurityConfigurerAdapter.userDetailsServiceBean());
    }
    //
    //    @Override
    //    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    //	oauthServer.checkTokenAccess("isAuthenticated()");
    //    }

    @Bean
    public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
	JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
	converter.setSigningKey("CATERPILLAR_KEY");
	return converter;
    }

}
