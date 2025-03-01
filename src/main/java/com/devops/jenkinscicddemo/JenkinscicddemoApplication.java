package com.devops.jenkinscicddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JenkinscicddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JenkinscicddemoApplication.class, args);
	}

	@GetMapping("/setup/{name}")
	public String setupCicd(@PathVariable("name") String userName) {
		return "Hello " + userName + ", Jenkins CI/CD setup is done.";
	}
}
