package com.designPatterns.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "com.designPatterns" })
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
	SpringApplication.run(Main.class, args);
    }
}
