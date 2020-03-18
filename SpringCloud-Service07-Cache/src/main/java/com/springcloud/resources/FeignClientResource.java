package com.springcloud.resources;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springcloud.resources.dto.UserResponse;

@FeignClient(name = "business")
public interface FeignClientResource {

    @RequestMapping(value = "/bus/jpa/allUser", method = RequestMethod.GET)
    public List<UserResponse> getAllUser();

}