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
    
    @GetMapping(value = "/miya")
    public String miya() {
	System.out.println("進來了miya1");
	return "AAAAAA";
    }
    
    
    @RequestMapping(value = "/aaa2")
    public String test2() {
	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	return "Test2...";
    }

    @RequestMapping(value = "/aaa")
    public String test() {
	System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
	return "Test...";
    }

}
