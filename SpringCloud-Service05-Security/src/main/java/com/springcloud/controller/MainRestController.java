package com.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/******************************************************************************************
 * @author Miles
 * 
 * 
 * 
 *******************************************************************************************/
@RestController
public class MainRestController {

    @RequestMapping(value = "/test")
    public String test() {
	System.out.println("test");
	return "test...";
    }

    @RequestMapping(value = "/test1")
    public String test1() {
	System.out.println("test1");
	return "test1...";
    }

    @RequestMapping(value = "/test2")
    public String test2() {
	System.out.println("test2");
	return "test2...";
    }

    @RequestMapping(value = "/test3")
    public String test3() {
	System.out.println("test3");
	return "test3...";
    }

}
