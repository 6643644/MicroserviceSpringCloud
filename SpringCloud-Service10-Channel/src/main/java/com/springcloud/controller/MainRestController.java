package com.springcloud.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.resources.FeignClientResource;
import com.springcloud.resources.dto.LoginRequest;
import com.springcloud.resources.dto.LoginResponse;
import com.springcloud.resources.dto.UserRequest;
import com.springcloud.resources.dto.UserResponse;

/******************************************************************************************
 * 該Service的入口端 <br>
 * 1. @RestController Spring Restful實現 <br>
 * 2. @CrossOrigin 排除AJAX 與 瀏覽器安全 不取得response <br>
 * 3. 使用了Apache Log4j 這個日誌系統是Spring Boot內建的，因為Spring Boot本身內建Tomcat所以預設Log4j功能 <br>
 * 但因為Spring boot 1.4以後支援Log4j2，而且效能與速度上Log4j2大勝於其他的日誌系統，故我們就來使用看看。<br>
 * 
 * 
 * @author Miles
 * 
 *******************************************************************************************/
@CrossOrigin
@RestController
public class MainRestController extends AbstractBaseApplication {

    @Autowired
    FeignClientResource feignClientResource;

    @RequestMapping(path = "/Login", method = RequestMethod.POST)
    @ResponseBody
    public LoginResponse login(@RequestParam String username, @RequestParam String password) {
	System.out.println("username:" + username);
	System.out.println("password:" + password);

	LoginResponse response = new LoginResponse();
	response.setStatus("successful");
	response.setMessage("message~");
	return response;
    }

    @RequestMapping(path = "/Show", method = RequestMethod.GET)
    @ResponseBody
    public LoginResponse showLoginData() {
	LoginResponse response = new LoginResponse();
	response.setUsername("testName");
	response.setPassword("testPass");
	return response;
    }

    @RequestMapping("/testMain")
    public String testMain() {
	return "測試~~";
    }

    @RequestMapping("/test")
    public String testJPA() {
	return feignClientResource.testFeignClinetResource();
    }

    @RequestMapping("/allUser")
    public List<UserResponse> testLog4j2(HttpServletResponse rs) {
	List<UserResponse> users = feignClientResource.getAllUser();
	if (users != null) {
	    users.forEach(u -> {
		System.out.println("User ID:" + u.getId() + ";Name:" + u.getName() + ";Address:" + u.getAddress());
	    });
	} else {
	    System.out.println("users is null...");
	}
//		Logger log = LogUtils.getExceptionLogger();
//		Logger log1 = LogUtils.getBussinessLogger();
//		Logger log2 = LogUtils.getDBLogger();
//		log.error("getExceptionLogger===日誌測試");
//		log1.info("getBussinessLogger===日誌測試");
//		log2.debug("getDBLogger===日誌測試");
//		rs.setHeader("Access-Control-Allow-Origin", "*");
//		rs.setHeader("Cache-Control","no-cache"); 
	return users;
    }

    @RequestMapping("/create")
    public UserResponse createUser() {
	UserRequest request = new UserRequest();
	request.setName("John");
	request.setAddress("新北市板橋區文化路6段544號499樓");
	return feignClientResource.createUser(request);

    }
}
