package com.mit.lab1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.mit.lab1.controller.HelloWorldController;

@SpringBootApplication
public class Lab1Application {

	public static void main(String[] args) {
		SpringApplication.run(Lab1Application.class, args);
		System.out.println(new HelloWorldController().getHelloWorld());
	}

}
