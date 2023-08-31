package com.ybakyurek;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.TimeZone;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareBeanMethod")

// Spring Security
@SpringBootApplication(exclude = {
		//SecurityAutoConfiguration.class,
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
		org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class
}
)
public class ToDoList {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	}


	public static void main(String[] args) {

		//Disables headless JOptionPane
		System.setProperty("java.awt.headless", "false");

		SpringApplication.run(ToDoList.class, args);
	}

}
