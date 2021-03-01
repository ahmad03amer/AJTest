package com.accessjobs.pjp;

import org.apache.catalina.Server;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;
import java.util.concurrent.Flow;

@SpringBootApplication
public class PjpApplication {

	public static void main(String[] args) {
		SpringApplication.run(PjpApplication.class, args);
	}

}
