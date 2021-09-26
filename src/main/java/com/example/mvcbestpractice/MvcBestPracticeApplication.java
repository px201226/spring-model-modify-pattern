package com.example.mvcbestpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class MvcBestPracticeApplication {


	public static void main(String[] args) {
		SpringApplication.run(MvcBestPracticeApplication.class, args);
	}


}
