package com.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springcloud.resources.FeignClientResource;
import com.springcloud.resources.dto.UserRequest;
import com.springcloud.resources.dto.UserResponse;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    @Autowired
    FeignClientResource feignClientResource;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	UserResponse UserData = feignClientResource.getUserByNameAndPasswrod(new UserRequest(username));

	UserDetails userDetail = User.builder().username(UserData.getName()).password("{noop}" + UserData.getPassword())
		.roles("admin").build();

	//	User user = new User(username, PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"),
	//		AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));

	return userDetail;
    }

}
