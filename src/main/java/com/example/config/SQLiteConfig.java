package com.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class SQLiteConfig {

	@Bean
	public DataSource dataSource() {
		HikariConfig config = new HikariConfig();
	    config.setJdbcUrl("jdbc:sqlite:pokedex.db"); // Update with your database path
        config.setDriverClassName("org.sqlite.JDBC");
	    config.setReadOnly(false); // Setze auf false
	    return new HikariDataSource(config);
	}
}
