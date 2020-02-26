package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.config.RedisObjectSerializer;

/******************************************************************************************
 * 1.使用Spring boot 2.x Redis 
 * 
 * @author Miles
 * 
 *******************************************************************************************/
@RestController
public class MainRestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping(value = "/test")
    public void test() {
	// redis存储数据
//	String key = "name";
//	redisTemplate.opsForValue().set(key, "yukong");
//	// 获取数据
//	String value = (String) redisTemplate.opsForValue().get(key);
//	System.out.println("获取缓存中key为" + key + "的值为：" + value);
//
//	RedisObjectSerializer user = new RedisObjectSerializer();
//	user.setUsername("yukong");
//	user.setSex(18);
//	user.setId(1L);
//	String userKey = "yukong";
//	redisTemplate.opsForValue().set(userKey, user);
//	RedisObjectSerializer newUser = (RedisObjectSerializer) redisTemplate.opsForValue().get(userKey);
//	System.out.println("获取缓存中key为" + userKey + "的值为：" + newUser);
    }

}
