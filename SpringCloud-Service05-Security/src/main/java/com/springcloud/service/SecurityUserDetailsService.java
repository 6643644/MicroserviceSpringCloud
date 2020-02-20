package com.springcloud.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

//@Service
public class SecurityUserDetailsService {
//implements UserDetailsService {

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//	User user = new User(username, PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("123456"),
//		AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
//
//	return user;
//    }

}
