package com.springcloud.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.resources.FeignClientResource;
import com.springcloud.resources.dto.UserResponse;

/******************************************************************************************
 * @author Miles
 * 
 *         練習session用，實際說明可以參考文件
 *
 * 
 *******************************************************************************************/
@RestController
public class MainRestController {

	@Autowired
	private FeignClientResource feignClientResource;

	@Autowired
	private RedisTemplate<String, UserResponse> redisTemplate;

	@RequestMapping("/tSession")
	public String testSession(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("cookie:" + cookie.getName() + ":" + cookie.getValue());
			}
		} else {
			System.out.println("cookies is null");
		}

		if (request.getSession(false) == null) {
			return "session is null. Create Session and Session Id is :" + request.getSession().getId();
		} else {
			return "session is not null.The Session Id is :" + request.getSession(false).getId();
		}

	}

	@RequestMapping(value = "/tSession/User", method = RequestMethod.GET)
	public String testSessionByUser(@RequestParam("id") Integer id) {
		UserResponse responseRedis = redisTemplate.opsForValue().get(id.toString());
		if (responseRedis == null) {
			System.out.println("responseRedis is null");
			responseRedis = feignClientResource.getUserById(id);
			if (responseRedis != null) {
				redisTemplate.opsForValue().set(responseRedis.getId().toString(), responseRedis);
			}
		}
		return "test user Id:" + responseRedis.getId() + ",Name:" + responseRedis.getName();
	}
}
