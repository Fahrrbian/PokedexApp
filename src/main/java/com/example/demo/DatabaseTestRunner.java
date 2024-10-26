package com.example.demo;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Component
public class DatabaseTestRunner {

	 @Bean
	    CommandLineRunner testDatabase(DataSource dataSource) {
	        return args -> {
	            try (Connection connection = dataSource.getConnection()) {
	                if (connection.isValid(2)) {
	                    System.out.println("Connection to SQLite established successfully.");
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        };
	    }
}
