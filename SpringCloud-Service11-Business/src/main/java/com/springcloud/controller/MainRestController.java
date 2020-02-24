package com.springcloud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.entitys.User;
import com.springcloud.model.UserRequest;
import com.springcloud.repository.UserRepository;

/******************************************************************************************
 * 該Service的入口端<br>
 * 1. @RestController<br>
 * 2. 使用了Logback，該日誌系統為Spring Boot內建預設的並且支援使用slf4j。
 * 
 * @author Miles
 * 
 *******************************************************************************************/
@RestController
public class MainRestController {

    //	private final Logger log = LoggerFactory.getLogger(MainRestController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(path = "/bus/test")
    public String testFeignClinetResourceClient() {
	//		log.info("URL:/Test1;testFeignClinetResourceClient()");
	return "testFeignClinetResource";
    }

    @RequestMapping(path = "/bus/jpa/allUser")
    public ResponseEntity<?> getAllUserByJPA() {
	//		log.info("URL:/TestJPA;getAllUserByJPA()");
	List<User> users = userRepository.findAll();
	ResponseEntity<?> response = ResponseEntity.ok(users);
	return response;
    }

    @RequestMapping(path = "/bus/jpa/user/name", method = RequestMethod.POST)
    public ResponseEntity<?> getUserByNameAndPassword(@RequestBody UserRequest request) {
	Optional<User> users = userRepository.findByName(request.getName());
	ResponseEntity<?> response = ResponseEntity.ok(users.get());
	return response;
    }

    @RequestMapping(path = "/bus/jpa/user/id", method = RequestMethod.GET)
    public ResponseEntity<?> getUserById(@RequestParam("id") Integer id) {
	Optional<User> users = userRepository.findById(id);
	ResponseEntity<?> response = ResponseEntity.ok(users.get());
	return response;
    }

    @RequestMapping(path = "/bus/jpa/createUser", method = RequestMethod.POST)
    public ResponseEntity<?> createUser(@RequestBody UserRequest request) {
	//		log.info("createUser");
	User user = new User();
	user.setName(request.getName());
	user.setAddress(request.getAddress());
	User reUser = userRepository.save(user);
	return ResponseEntity.ok(reUser);
    }

}
