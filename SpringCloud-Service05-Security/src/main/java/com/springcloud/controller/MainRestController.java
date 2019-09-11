package com.springcloud.controller;

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
	
	@RequestMapping("/test")
	public String test() {
		return "Test...";
	}
	
}
