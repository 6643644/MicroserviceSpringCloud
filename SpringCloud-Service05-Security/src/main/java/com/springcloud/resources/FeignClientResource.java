package com.springcloud.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.resources.dto.UserRequest;
import com.springcloud.resources.dto.UserResponse;

@FeignClient(name = "business")
public interface FeignClientResource {

    @RequestMapping(value = "/bus/jpa/user/name", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getUserByNameAndPasswrod(@RequestBody UserRequest request);

}