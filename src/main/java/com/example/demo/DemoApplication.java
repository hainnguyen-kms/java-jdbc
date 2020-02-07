package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String ...args) {
		initTable();
	}

	private void initTable() {
		jdbcTemplate.execute("DROP TABLE IF EXISTS employees");
		jdbcTemplate.execute("CREATE TABLE employees(" +
				"id SERIAL, name VARCHAR(255), role VARCHAR(255))");
	}
}
