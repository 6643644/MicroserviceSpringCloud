package com.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.springcloud.resources.dto.UserResponse;

@Configuration
//@PropertySource(value="classpath:redisConfig.properties", ignoreResourceNotFound=true)
public class RedisConfig {

    @Autowired
    private RedisConfigBean redisConfigBean;

    // @Value("${redis.hostName}")
    // private String hostName;
    //
    // @Value("${redis.port}")
    // private int port;
    //
    // @Value("${redis.database}")
    // private int database;
    //
    // @Value("${redis.timeout}")
    // private int timeout;

    // @Bean
    // public JedisConnectionFactory jedisConnectionFactory() {
    // JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
    // jedisConnectionFactory.setHostName("127.0.0.1");
    // jedisConnectionFactory.setPort(9980);
    // jedisConnectionFactory.setDatabase(0);
    // return jedisConnectionFactory;
    // }

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
	JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
	jedisConnectionFactory.setHostName(redisConfigBean.getHost());
	jedisConnectionFactory.setPort(redisConfigBean.getPort());
	jedisConnectionFactory.setDatabase(redisConfigBean.getDatabase());
	jedisConnectionFactory.setTimeout(redisConfigBean.getTimeout());
	return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, UserResponse> redisTemplate(RedisConnectionFactory factory) {
	RedisTemplate<String, UserResponse> template = new RedisTemplate<String, UserResponse>();
	template.setConnectionFactory(redisConnectionFactory());
	template.setKeySerializer(new StringRedisSerializer());
	template.setValueSerializer(new RedisObjectSerializer());
	return template;
    }
}
