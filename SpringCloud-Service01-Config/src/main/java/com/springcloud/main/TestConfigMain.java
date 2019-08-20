package com.springcloud.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestConfigMain {

	@Value("${spring.profiles.active}")
	private String profilesActice;

	@Value("${server.port}")
	private String serverPort;

	@Value("${spring.cloud.config.server.git.uri}")
	private String uri;

	@RequestMapping(value = "/miya")
	public String miya() {
		return profilesActice;
	}

	@RequestMapping(value = "/miya2")
	public String miya2() {
		System.out.println("進來了miya2");
		return serverPort;
	}

	@RequestMapping(value = "/miya3")
	public String miya3() {
		return uri;
	}
}
