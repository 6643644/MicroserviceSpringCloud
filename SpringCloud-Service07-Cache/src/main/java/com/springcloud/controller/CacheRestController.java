package com.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.resources.FeignClientResource;
import com.springcloud.resources.dto.UserResponse;

@RestController
public class CacheRestController {

    @Autowired
    private FeignClientResource feignClientResource;

    @RequestMapping(value = "/test")
    @Cacheable(value = "allUser")
    public String test() {
	System.out.println("test");
	List<UserResponse> allUserList = feignClientResource.getAllUser();
	return "test...";
    }
}
