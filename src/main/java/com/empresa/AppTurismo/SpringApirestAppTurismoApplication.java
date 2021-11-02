package com.empresa.AppTurismo;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages= "com")
public class SpringApirestAppTurismoApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringApirestAppTurismoApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
		app.run(args);
		//SpringApplication.run(SpringApirestAppTurismoApplication.class, args);
	}

}
