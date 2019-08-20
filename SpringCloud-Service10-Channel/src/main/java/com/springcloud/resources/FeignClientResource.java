package com.springcloud.resources;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.resources.dto.UserRequest;
import com.springcloud.resources.dto.UserResponse;

@FeignClient(name = "business")
public interface FeignClientResource {

	@RequestMapping(value = "/bus/test", method = RequestMethod.GET)
	public String testFeignClinetResource();

	@RequestMapping(value = "/bus/jpa/allUser", method = RequestMethod.GET)
	public List<UserResponse> getAllUser();

	@RequestMapping(value = "/bus/jpa/createUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse createUser(@RequestBody UserRequest request);

}