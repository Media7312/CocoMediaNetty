package com.example.coconetty;

import com.example.MediaStart.MyApplicationListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoconettyApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(CoconettyApplication.class);
		springApplication.addListeners(new MyApplicationListener());
		springApplication.run(args);
		System.out.println("启动成功");
	}
}
