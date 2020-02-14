package com.springcloud.controller;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @GetMapping("/hello")
    public String hello(OAuth2Authentication oauth) {
	return "hello " + oauth.getName();
    }
}
