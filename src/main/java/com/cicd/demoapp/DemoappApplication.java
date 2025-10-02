package com.cicd.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoappApplication {


	@GetMapping("/dummy")
	public String dummy() {
		return "success";
	}
	public static void main(String[] args) {
		SpringApplication.run(DemoappApplication.class, args);
	}

}
