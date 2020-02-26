package com.springcloud.config;

import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /** 產生CacheManager的方式(預設方式) */
    //        @Bean
    //        public CacheManager cacheManager(RedisConnectionFactory factory) {
    //    	RedisCacheManager cacheManager = RedisCacheManager.create(factory);
    //    	return cacheManager;
    //        }

    /** 產生CacheManager的方式(自定義方式) */
    @Bean
    public CacheManager cacheManager() {
	RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
	config = config.entryTtl(Duration.ofMinutes(1)).disableCachingNullValues();

	// 设置一个初始化的缓存空间set集合
	Set<String> cacheNames = new HashSet<>();
	cacheNames.add("my-redis-cache1");
	cacheNames.add("my-redis-cache2");

	// 对每个缓存空间应用不同的配置
	Map<String, RedisCacheConfiguration> configMap = new HashMap<>();
	configMap.put("my-redis-cache1", config);
	configMap.put("my-redis-cache2", config.entryTtl(Duration.ofSeconds(120)));

	RedisCacheManager cacheManager = RedisCacheManager.builder(redisConnectionFactory).initialCacheNames(cacheNames)
		.withInitialCacheConfigurations(configMap).build();
	return cacheManager;
    }

    /**
     * a. 配置自定义redisTemplate
     * 
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
	RedisTemplate<String, Object> template = new RedisTemplate<>();
	template.setConnectionFactory(redisConnectionFactory);

	//使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
	Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

	ObjectMapper mapper = new ObjectMapper();
	mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
	mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	serializer.setObjectMapper(mapper);

	template.setValueSerializer(serializer);
	//使用StringRedisSerializer来序列化和反序列化redis的key值
	template.setKeySerializer(new StringRedisSerializer());
	template.setHashKeySerializer(new StringRedisSerializer());
	template.setHashValueSerializer(serializer);
	template.afterPropertiesSet();
	return template;
    }
}
